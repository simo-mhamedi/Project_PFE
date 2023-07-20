package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.DeclarationTva;
import ma.sir.dgi.bean.core.FactureCharge;
import ma.sir.dgi.bean.core.FactureProduit;
import ma.sir.dgi.bean.core.Societe;
import ma.sir.dgi.dao.facade.core.FactureChargeDao;
import ma.sir.dgi.dao.facade.core.FactureProduitDao;
import ma.sir.dgi.dao.facade.core.TauxRetardTvaDao;
import ma.sir.dgi.dao.facade.core.TvaDao;
import ma.sir.dgi.service.facade.admin.TvaAdminService;
import ma.sir.dgi.ws.dto.DeclarationIsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TvaAdminServiceImpl implements TvaAdminService {

    @Autowired
    private final TvaDao tvaDao;
    private final FactureProduitDao factureProduitDao;
    private final FactureChargeDao factureChargeDao;
    private final TauxRetardTvaDao tauxRetardTvaDao;
    public TvaAdminServiceImpl(TvaDao tvaDao, FactureProduitDao factureProduitDao, FactureChargeDao factureChargeDao, TauxRetardTvaDao tauxRetardTvaDao) {
        this.tvaDao = tvaDao;
        this.factureProduitDao = factureProduitDao;
        this.factureChargeDao = factureChargeDao;
        this.tauxRetardTvaDao = tauxRetardTvaDao;
    }

    @Override
    public int save(DeclarationIsDto declarationIsDto) {
        DeclarationTva check = this.tvaDao.findByTrimistreAndAnneeAndSocieteId(declarationIsDto.getTrimistre()
                , declarationIsDto.getAnnee()
                , declarationIsDto.getSociete().getId());
        if (check != null) {
            return -1;
        } else {
            DeclarationTva declarationTva =new DeclarationTva();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            LocalDateTime localDateTime = LocalDateTime.parse(declarationIsDto.getDateDeclarationStr(), formatter);
            declarationTva.setDateDeclaration(localDateTime);
            declarationTva.setTrimistre(declarationIsDto.getTrimistre());
            declarationTva.setAnnee(declarationIsDto.getAnnee());
            List<FactureProduit> factureProduits = this.factureProduitDao.findBySocieteIdAndSocieteDernierAnneePayerTvaAndSocieteDernierTrimestrePayerTva
                    (declarationIsDto.getSociete().getId(), declarationIsDto.getAnnee(), declarationIsDto.getTrimistre());
            declarationTva.setTotalTvaCollecte(calculateTotalTvaCollecte(factureProduits));

            List<FactureCharge> factureCharges = this.factureChargeDao.findBySocieteIdAndSocieteDernierAnneePayerTvaAndSociete_DernierTrimestrePayerTva
                    (declarationIsDto.getSociete().getId(), declarationIsDto.getAnnee(), declarationIsDto.getTrimistre());
            declarationTva.setTotalTvaDue(calculateTotalTvaDue(factureCharges));
            calculateMontantTvaDifference(declarationTva);
            declarationTva.setTauxRetardTva(this.tauxRetardTvaDao.findTauxRetardTvaBetweenDates(localDateTime));
            if(declarationTva.getTauxRetardTva() != null)
            {
                declarationTva.setMontantTva(declarationTva.getDifferenceTva().add(declarationTva.getTauxRetardTva().getMontant()));
            }
            Societe societe=new Societe();
            societe.setId(declarationIsDto.getSociete().getId());
            societe.setIce(declarationIsDto.getSociete().getIce());
            societe.setSiege(declarationIsDto.getSociete().getSiege());
            societe.setDernierAnneePayerIs(declarationIsDto.getSociete().getDernierAnneePayerIs());
            societe.setDernierAnneePayerTva(declarationIsDto.getSociete().getDernierAnneePayerTva());
            societe.setDernierTrimestrePayerTva(declarationIsDto.getSociete().getDernierTrimestrePayerTva());
            societe.setDernierTrimestrePayerIs(declarationIsDto.getSociete().getDernierTrimestrePayerIs());
            societe.setBloqued(declarationIsDto.getSociete().getBloqued());
            declarationTva.setSociete(societe);
            this.tvaDao.save(declarationTva);
            return 0;
        }
    }
    public BigDecimal calculateTotalTvaCollecte(List<FactureProduit> factureProduits) {
        BigDecimal totalAmount = BigDecimal.ZERO; // Initialize total amount to zero

        for (FactureProduit factureProduit : factureProduits) {
            // Perform the calculation: montantHt * montantTva
            BigDecimal montantHt = factureProduit.getMontantHt();
            BigDecimal montantTva = factureProduit.getMontantTva();
            BigDecimal product = montantHt.multiply(montantTva);

            // Add the product to the total amount
            totalAmount = totalAmount.add(product);
        }

        return totalAmount;
    }

    public BigDecimal calculateTotalTvaDue(List<FactureCharge> factureCharges) {
        BigDecimal totalAmount = BigDecimal.ZERO; // Initialize total amount to zero

        for (FactureCharge factureCharge : factureCharges) {
            // Perform the calculation: montantHt * montantTva
            BigDecimal montantHt = factureCharge.getMontantHt();
            BigDecimal montantTva = factureCharge.getMontantTva();
            BigDecimal product = montantHt.multiply(montantTva);

            // Add the product to the total amount
            totalAmount = totalAmount.add(product);
        }

        return totalAmount;
    }

    public void calculateMontantTvaDifference(DeclarationTva check) {
        BigDecimal totalTvaCollecte = check.getTotalTvaCollecte();
        BigDecimal totalTvaDue = check.getTotalTvaDue();

        BigDecimal montantTva = totalTvaCollecte.subtract(totalTvaDue);
        check.setMontantTva(montantTva);
    }
}



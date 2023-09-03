package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.TauxIs;
import ma.sir.dgi.dao.facade.core.*;
import ma.sir.dgi.ws.dto.DeclarationIsDto;
import ma.sir.dgi.ws.dto.FactureProduitDto;
import ma.sir.dgi.ws.dto.TauxIsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DeclarationIsService {
    @Autowired
    private final FactureProduitDao factureProduitDao;
    private final FactureChargeDao factureChargeDao;

    private final TauxIsDao tauxIsDao;
    public DeclarationIsService(FactureProduitDao factureProduitDao, FactureChargeDao factureChargeDao, TauxIsDao tauxIsDao) {
        this.factureProduitDao = factureProduitDao;
        this.factureChargeDao = factureChargeDao;
        this.tauxIsDao = tauxIsDao;
    }

    public DeclarationIsDto calculate(DeclarationIsDto declarationIsDto){
        DeclarationIsDto declarationIsDto1 = new DeclarationIsDto();
        declarationIsDto1.setTotalCharge(factureChargeDao
                .sumMontantHtBySocieteIdAndAnneeAndTrimestre(declarationIsDto.getSociete().getId(),declarationIsDto.getAnnee(),
                        declarationIsDto.getTrimistre()));

        declarationIsDto1.setTotalProduit(factureProduitDao
                .sumMontantHtBySocieteIdAndAnneeAndTrimestre(declarationIsDto.getSociete().getId(),declarationIsDto.getAnnee(),
                        declarationIsDto.getTrimistre()));

        declarationIsDto1.setResultatAvantImpot(declarationIsDto1.getTotalProduit().subtract(declarationIsDto1.getTotalCharge()));
        TauxIs tauxIs=tauxIsDao.findTauxIsInRange(declarationIsDto1.getResultatAvantImpot());
        TauxIsDto tauxIsDto=new TauxIsDto();

        tauxIsDto.setId(tauxIs.getId());
        tauxIsDto.setPourcentage(tauxIs.getPourcentage());
        tauxIsDto.setResultatMin(tauxIs.getResultatMin());
        tauxIsDto.setResultatMax(tauxIs.getResultatMax());
        tauxIsDto.setCotisationMinimale(tauxIs.getCotisationMinimale());
        if(tauxIs !=null)
        {
            declarationIsDto1.setMontantImpot(tauxIs.getPourcentage().multiply(declarationIsDto1.getResultatAvantImpot()));
        }
        declarationIsDto1.setResultatApresImpot(declarationIsDto1.getResultatAvantImpot().subtract(declarationIsDto1.getMontantImpot()));
        declarationIsDto1.setTauxIs(tauxIsDto);
        return  declarationIsDto1;
    }
}

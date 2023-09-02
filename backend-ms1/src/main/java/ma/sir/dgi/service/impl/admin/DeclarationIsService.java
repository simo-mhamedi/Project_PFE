package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.dao.facade.core.FactureChargeDao;
import ma.sir.dgi.dao.facade.core.FactureProduitDao;
import ma.sir.dgi.dao.facade.core.TauxRetardTvaDao;
import ma.sir.dgi.dao.facade.core.TvaDao;
import ma.sir.dgi.ws.dto.DeclarationIsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service

public class DeclarationIsService {
    @Autowired
    private final FactureProduitDao factureProduitDao;
    private final FactureChargeDao factureChargeDao;
    public DeclarationIsService(FactureProduitDao factureProduitDao, FactureChargeDao factureChargeDao) {
        this.factureProduitDao = factureProduitDao;
        this.factureChargeDao = factureChargeDao;
    }

    public void calculate(DeclarationIsDto declarationIsDto){
        BigDecimal totalFactureCharge=factureChargeDao
                .sumMontantHtBySocieteIdAndAnneeAndTrimestre(declarationIsDto.getSociete().getId(),declarationIsDto.getAnnee(),
                        declarationIsDto.getTrimistre());

        BigDecimal totalFactureProduit=factureProduitDao
                .sumMontantHtBySocieteIdAndAnneeAndTrimestre(declarationIsDto.getSociete().getId(),declarationIsDto.getAnnee(),
                        declarationIsDto.getTrimistre());
    }
}

package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.DeclarationIs;
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


}

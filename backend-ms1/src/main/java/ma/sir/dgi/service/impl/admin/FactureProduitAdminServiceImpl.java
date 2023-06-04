package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.FactureProduit;
import ma.sir.dgi.bean.history.FactureProduitHistory;
import ma.sir.dgi.dao.criteria.core.FactureProduitCriteria;
import ma.sir.dgi.dao.criteria.history.FactureProduitHistoryCriteria;
import ma.sir.dgi.dao.facade.core.FactureProduitDao;
import ma.sir.dgi.dao.facade.history.FactureProduitHistoryDao;
import ma.sir.dgi.dao.specification.core.FactureProduitSpecification;
import ma.sir.dgi.service.facade.admin.FactureProduitAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.FactureProduitDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.dgi.service.facade.admin.DeclarationIsAdminService ;
import ma.sir.dgi.service.facade.admin.SocieteAdminService ;


import java.util.List;
@Service
public class FactureProduitAdminServiceImpl extends AbstractServiceImpl<FactureProduit,FactureProduitHistory, FactureProduitCriteria, FactureProduitHistoryCriteria, FactureProduitDao,
FactureProduitHistoryDao> implements FactureProduitAdminService {
    public static final String TEMPLATE = "template/factureProduit.vm";
    public static final String FILE_NAME = "factureProduit.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(FactureProduitDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<FactureProduit> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<FactureProduit> findByDeclarationIsId(Long id){
        return dao.findByDeclarationIsId(id);
    }
    public int deleteByDeclarationIsId(Long id){
        return dao.deleteByDeclarationIsId(id);
    }




    public void configure() {
        super.configure(FactureProduit.class,FactureProduitHistory.class, FactureProduitHistoryCriteria.class, FactureProduitSpecification.class);
    }

    @Autowired
    private DeclarationIsAdminService declarationIsService ;
    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public FactureProduitAdminServiceImpl(FactureProduitDao dao, FactureProduitHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
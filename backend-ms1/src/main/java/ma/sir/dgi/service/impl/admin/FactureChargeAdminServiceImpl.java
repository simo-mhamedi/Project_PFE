package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.FactureCharge;
import ma.sir.dgi.bean.history.FactureChargeHistory;
import ma.sir.dgi.dao.criteria.core.FactureChargeCriteria;
import ma.sir.dgi.dao.criteria.history.FactureChargeHistoryCriteria;
import ma.sir.dgi.dao.facade.core.FactureChargeDao;
import ma.sir.dgi.dao.facade.history.FactureChargeHistoryDao;
import ma.sir.dgi.dao.specification.core.FactureChargeSpecification;
import ma.sir.dgi.service.facade.admin.FactureChargeAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.FactureChargeDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.dgi.service.facade.admin.DeclarationIsAdminService ;
import ma.sir.dgi.service.facade.admin.SocieteAdminService ;


import java.util.List;
@Service
public class FactureChargeAdminServiceImpl extends AbstractServiceImpl<FactureCharge,FactureChargeHistory, FactureChargeCriteria, FactureChargeHistoryCriteria, FactureChargeDao,
FactureChargeHistoryDao> implements FactureChargeAdminService {
    public static final String TEMPLATE = "template/factureCharge.vm";
    public static final String FILE_NAME = "factureCharge.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(FactureChargeDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<FactureCharge> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<FactureCharge> findByDeclarationIsId(Long id){
        return dao.findByDeclarationIsId(id);
    }
    public int deleteByDeclarationIsId(Long id){
        return dao.deleteByDeclarationIsId(id);
    }




    public void configure() {
        super.configure(FactureCharge.class,FactureChargeHistory.class, FactureChargeHistoryCriteria.class, FactureChargeSpecification.class);
    }

    @Autowired
    private DeclarationIsAdminService declarationIsService ;
    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public FactureChargeAdminServiceImpl(FactureChargeDao dao, FactureChargeHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
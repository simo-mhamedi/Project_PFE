package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.DeclarationTva;
import ma.sir.dgi.bean.history.DeclarationTvaHistory;
import ma.sir.dgi.dao.criteria.core.DeclarationTvaCriteria;
import ma.sir.dgi.dao.criteria.history.DeclarationTvaHistoryCriteria;
import ma.sir.dgi.dao.facade.core.DeclarationTvaDao;
import ma.sir.dgi.dao.facade.history.DeclarationTvaHistoryDao;
import ma.sir.dgi.dao.specification.core.DeclarationTvaSpecification;
import ma.sir.dgi.service.facade.admin.DeclarationTvaAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.DeclarationTvaDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.dgi.service.facade.admin.TauxRetardTvaAdminService ;
import ma.sir.dgi.service.facade.admin.SocieteAdminService ;


import java.util.List;
@Service
public class DeclarationTvaAdminServiceImpl extends AbstractServiceImpl<DeclarationTva,DeclarationTvaHistory, DeclarationTvaCriteria, DeclarationTvaHistoryCriteria, DeclarationTvaDao,
DeclarationTvaHistoryDao> implements DeclarationTvaAdminService {
    public static final String TEMPLATE = "template/declarationTva.vm";
    public static final String FILE_NAME = "declarationTva.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DeclarationTvaDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<DeclarationTva> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<DeclarationTva> findByTauxRetardTvaId(Long id){
        return dao.findByTauxRetardTvaId(id);
    }
    public int deleteByTauxRetardTvaId(Long id){
        return dao.deleteByTauxRetardTvaId(id);
    }




    public void configure() {
        super.configure(DeclarationTva.class,DeclarationTvaHistory.class, DeclarationTvaHistoryCriteria.class, DeclarationTvaSpecification.class);
    }

    @Autowired
    private TauxRetardTvaAdminService tauxRetardTvaService ;
    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DeclarationTvaAdminServiceImpl(DeclarationTvaDao dao, DeclarationTvaHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
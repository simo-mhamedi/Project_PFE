package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.SousClassComptable;
import ma.sir.dgi.bean.history.SousClassComptableHistory;
import ma.sir.dgi.dao.criteria.core.SousClassComptableCriteria;
import ma.sir.dgi.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.dgi.dao.facade.core.SousClassComptableDao;
import ma.sir.dgi.dao.facade.history.SousClassComptableHistoryDao;
import ma.sir.dgi.dao.specification.core.SousClassComptableSpecification;
import ma.sir.dgi.service.facade.admin.SousClassComptableAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.SousClassComptableDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.dgi.service.facade.admin.ClassComptableAdminService ;


import java.util.List;
@Service
public class SousClassComptableAdminServiceImpl extends AbstractServiceImpl<SousClassComptable,SousClassComptableHistory, SousClassComptableCriteria, SousClassComptableHistoryCriteria, SousClassComptableDao,
SousClassComptableHistoryDao> implements SousClassComptableAdminService {
    public static final String TEMPLATE = "template/sousClassComptable.vm";
    public static final String FILE_NAME = "sousClassComptable.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SousClassComptableDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<SousClassComptable> findByClassComptableId(Long id){
        return dao.findByClassComptableId(id);
    }
    public int deleteByClassComptableId(Long id){
        return dao.deleteByClassComptableId(id);
    }




    public void configure() {
        super.configure(SousClassComptable.class,SousClassComptableHistory.class, SousClassComptableHistoryCriteria.class, SousClassComptableSpecification.class);
    }

    @Autowired
    private ClassComptableAdminService classComptableService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public SousClassComptableAdminServiceImpl(SousClassComptableDao dao, SousClassComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
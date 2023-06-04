package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.Societe;
import ma.sir.dgi.bean.history.SocieteHistory;
import ma.sir.dgi.dao.criteria.core.SocieteCriteria;
import ma.sir.dgi.dao.criteria.history.SocieteHistoryCriteria;
import ma.sir.dgi.dao.facade.core.SocieteDao;
import ma.sir.dgi.dao.facade.history.SocieteHistoryDao;
import ma.sir.dgi.dao.specification.core.SocieteSpecification;
import ma.sir.dgi.service.facade.admin.SocieteAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.SocieteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class SocieteAdminServiceImpl extends AbstractServiceImpl<Societe,SocieteHistory, SocieteCriteria, SocieteHistoryCriteria, SocieteDao,
SocieteHistoryDao> implements SocieteAdminService {
    public static final String TEMPLATE = "template/societe.vm";
    public static final String FILE_NAME = "societe.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SocieteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Societe findByReferenceEntity(Societe t){
        return  dao.findByIce(t.getIce());
    }





    public void configure() {
        super.configure(Societe.class,SocieteHistory.class, SocieteHistoryCriteria.class, SocieteSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public SocieteAdminServiceImpl(SocieteDao dao, SocieteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
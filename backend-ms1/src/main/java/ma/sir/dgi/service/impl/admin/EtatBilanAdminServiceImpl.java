package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.EtatBilan;
import ma.sir.dgi.bean.history.EtatBilanHistory;
import ma.sir.dgi.dao.criteria.core.EtatBilanCriteria;
import ma.sir.dgi.dao.criteria.history.EtatBilanHistoryCriteria;
import ma.sir.dgi.dao.facade.core.EtatBilanDao;
import ma.sir.dgi.dao.facade.history.EtatBilanHistoryDao;
import ma.sir.dgi.dao.specification.core.EtatBilanSpecification;
import ma.sir.dgi.service.facade.admin.EtatBilanAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.EtatBilanDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatBilanAdminServiceImpl extends AbstractServiceImpl<EtatBilan,EtatBilanHistory, EtatBilanCriteria, EtatBilanHistoryCriteria, EtatBilanDao,
EtatBilanHistoryDao> implements EtatBilanAdminService {
    public static final String TEMPLATE = "template/etatBilan.vm";
    public static final String FILE_NAME = "etatBilan.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatBilanDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }







    public void configure() {
        super.configure(EtatBilan.class,EtatBilanHistory.class, EtatBilanHistoryCriteria.class, EtatBilanSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatBilanAdminServiceImpl(EtatBilanDao dao, EtatBilanHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
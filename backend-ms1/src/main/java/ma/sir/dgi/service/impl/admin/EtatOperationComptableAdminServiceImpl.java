package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.EtatOperationComptable;
import ma.sir.dgi.bean.history.EtatOperationComptableHistory;
import ma.sir.dgi.dao.criteria.core.EtatOperationComptableCriteria;
import ma.sir.dgi.dao.criteria.history.EtatOperationComptableHistoryCriteria;
import ma.sir.dgi.dao.facade.core.EtatOperationComptableDao;
import ma.sir.dgi.dao.facade.history.EtatOperationComptableHistoryDao;
import ma.sir.dgi.dao.specification.core.EtatOperationComptableSpecification;
import ma.sir.dgi.service.facade.admin.EtatOperationComptableAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.EtatOperationComptableDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class EtatOperationComptableAdminServiceImpl extends AbstractServiceImpl<EtatOperationComptable,EtatOperationComptableHistory, EtatOperationComptableCriteria, EtatOperationComptableHistoryCriteria, EtatOperationComptableDao,
EtatOperationComptableHistoryDao> implements EtatOperationComptableAdminService {
    public static final String TEMPLATE = "template/etatOperationComptable.vm";
    public static final String FILE_NAME = "etatOperationComptable.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(EtatOperationComptableDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }







    public void configure() {
        super.configure(EtatOperationComptable.class,EtatOperationComptableHistory.class, EtatOperationComptableHistoryCriteria.class, EtatOperationComptableSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public EtatOperationComptableAdminServiceImpl(EtatOperationComptableDao dao, EtatOperationComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
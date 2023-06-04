package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.TauxIs;
import ma.sir.dgi.bean.history.TauxIsHistory;
import ma.sir.dgi.dao.criteria.core.TauxIsCriteria;
import ma.sir.dgi.dao.criteria.history.TauxIsHistoryCriteria;
import ma.sir.dgi.dao.facade.core.TauxIsDao;
import ma.sir.dgi.dao.facade.history.TauxIsHistoryDao;
import ma.sir.dgi.dao.specification.core.TauxIsSpecification;
import ma.sir.dgi.service.facade.admin.TauxIsAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.TauxIsDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class TauxIsAdminServiceImpl extends AbstractServiceImpl<TauxIs,TauxIsHistory, TauxIsCriteria, TauxIsHistoryCriteria, TauxIsDao,
TauxIsHistoryDao> implements TauxIsAdminService {
    public static final String TEMPLATE = "template/tauxIs.vm";
    public static final String FILE_NAME = "tauxIs.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(TauxIsDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }







    public void configure() {
        super.configure(TauxIs.class,TauxIsHistory.class, TauxIsHistoryCriteria.class, TauxIsSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public TauxIsAdminServiceImpl(TauxIsDao dao, TauxIsHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
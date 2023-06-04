package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.TauxRetardTva;
import ma.sir.dgi.bean.history.TauxRetardTvaHistory;
import ma.sir.dgi.dao.criteria.core.TauxRetardTvaCriteria;
import ma.sir.dgi.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.dgi.dao.facade.core.TauxRetardTvaDao;
import ma.sir.dgi.dao.facade.history.TauxRetardTvaHistoryDao;
import ma.sir.dgi.dao.specification.core.TauxRetardTvaSpecification;
import ma.sir.dgi.service.facade.admin.TauxRetardTvaAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.TauxRetardTvaDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class TauxRetardTvaAdminServiceImpl extends AbstractServiceImpl<TauxRetardTva,TauxRetardTvaHistory, TauxRetardTvaCriteria, TauxRetardTvaHistoryCriteria, TauxRetardTvaDao,
TauxRetardTvaHistoryDao> implements TauxRetardTvaAdminService {
    public static final String TEMPLATE = "template/tauxRetardTva.vm";
    public static final String FILE_NAME = "tauxRetardTva.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(TauxRetardTvaDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }







    public void configure() {
        super.configure(TauxRetardTva.class,TauxRetardTvaHistory.class, TauxRetardTvaHistoryCriteria.class, TauxRetardTvaSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public TauxRetardTvaAdminServiceImpl(TauxRetardTvaDao dao, TauxRetardTvaHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
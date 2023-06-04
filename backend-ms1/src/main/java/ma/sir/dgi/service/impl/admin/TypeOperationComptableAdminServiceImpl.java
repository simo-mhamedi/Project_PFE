package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.TypeOperationComptable;
import ma.sir.dgi.bean.history.TypeOperationComptableHistory;
import ma.sir.dgi.dao.criteria.core.TypeOperationComptableCriteria;
import ma.sir.dgi.dao.criteria.history.TypeOperationComptableHistoryCriteria;
import ma.sir.dgi.dao.facade.core.TypeOperationComptableDao;
import ma.sir.dgi.dao.facade.history.TypeOperationComptableHistoryDao;
import ma.sir.dgi.dao.specification.core.TypeOperationComptableSpecification;
import ma.sir.dgi.service.facade.admin.TypeOperationComptableAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.TypeOperationComptableDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class TypeOperationComptableAdminServiceImpl extends AbstractServiceImpl<TypeOperationComptable,TypeOperationComptableHistory, TypeOperationComptableCriteria, TypeOperationComptableHistoryCriteria, TypeOperationComptableDao,
TypeOperationComptableHistoryDao> implements TypeOperationComptableAdminService {
    public static final String TEMPLATE = "template/typeOperationComptable.vm";
    public static final String FILE_NAME = "typeOperationComptable.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(TypeOperationComptableDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }







    public void configure() {
        super.configure(TypeOperationComptable.class,TypeOperationComptableHistory.class, TypeOperationComptableHistoryCriteria.class, TypeOperationComptableSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public TypeOperationComptableAdminServiceImpl(TypeOperationComptableDao dao, TypeOperationComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
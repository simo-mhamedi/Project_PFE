package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.OperationComptable;
import ma.sir.dgi.bean.history.OperationComptableHistory;
import ma.sir.dgi.dao.criteria.core.OperationComptableCriteria;
import ma.sir.dgi.dao.criteria.history.OperationComptableHistoryCriteria;
import ma.sir.dgi.dao.facade.core.OperationComptableDao;
import ma.sir.dgi.dao.facade.history.OperationComptableHistoryDao;
import ma.sir.dgi.dao.specification.core.OperationComptableSpecification;
import ma.sir.dgi.service.facade.admin.OperationComptableAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.service.Attribute;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.OperationComptableDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.dgi.service.facade.admin.EtatOperationComptableAdminService;
import ma.sir.dgi.service.facade.admin.CompteComptableAdminService;
import ma.sir.dgi.service.facade.admin.SocieteAdminService;
import ma.sir.dgi.service.facade.admin.TypeOperationComptableAdminService;


import java.util.List;

@Service
public class OperationComptableAdminServiceImpl extends AbstractServiceImpl<OperationComptable, OperationComptableHistory, OperationComptableCriteria, OperationComptableHistoryCriteria, OperationComptableDao,
        OperationComptableHistoryDao> implements OperationComptableAdminService {
    public static final String TEMPLATE = "template/operationComptable.vm";
    public static final String FILE_NAME = "operationComptable.pdf";
    public static final List<Attribute> ATTRIBUTES = new ArrayList<>();

    static {
        ATTRIBUTES.add(new Attribute("id", "Long"));
        ATTRIBUTES.add(new Attribute("libelle"));
        ATTRIBUTES.add(new Attribute("annee", "Integer"));
        ATTRIBUTES.add(new Attribute("mois", "Integer"));
        ATTRIBUTES.add(new Attribute("montant", "BigDecimal"));
    }

    @Override
    public HttpEntity<byte[]> createPdf(OperationComptableDto dto) throws Exception {
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public List<OperationComptable> findBySocieteId(Long id) {
        return dao.findBySocieteId(id);
    }

    public int deleteBySocieteId(Long id) {
        return dao.deleteBySocieteId(id);
    }

    public List<OperationComptable> findByCompteComptableId(Long id) {
        return dao.findByCompteComptableId(id);
    }

    public int deleteByCompteComptableId(Long id) {
        return dao.deleteByCompteComptableId(id);
    }

    public List<OperationComptable> findByTypeOperationComptableId(Long id) {
        return dao.findByTypeOperationComptableId(id);
    }

    public int deleteByTypeOperationComptableId(Long id) {
        return dao.deleteByTypeOperationComptableId(id);
    }

    public List<OperationComptable> findByEtatOperationComptableId(Long id) {
        return dao.findByEtatOperationComptableId(id);
    }

    public int deleteByEtatOperationComptableId(Long id) {
        return dao.deleteByEtatOperationComptableId(id);
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }


    public void configure() {
        super.configure(OperationComptable.class, OperationComptableHistory.class, OperationComptableHistoryCriteria.class, OperationComptableSpecification.class);
    }

    @Autowired
    private EtatOperationComptableAdminService etatOperationComptableService;
    @Autowired
    private CompteComptableAdminService compteComptableService;
    @Autowired
    private SocieteAdminService societeService;
    @Autowired
    private TypeOperationComptableAdminService typeOperationComptableService;
    @Autowired
    private VelocityPdf velocityPdf;

    public OperationComptableAdminServiceImpl(OperationComptableDao dao, OperationComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
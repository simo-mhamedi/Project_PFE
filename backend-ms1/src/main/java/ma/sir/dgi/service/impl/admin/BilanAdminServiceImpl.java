package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.Bilan;
import ma.sir.dgi.bean.history.BilanHistory;
import ma.sir.dgi.dao.criteria.core.BilanCriteria;
import ma.sir.dgi.dao.criteria.history.BilanHistoryCriteria;
import ma.sir.dgi.dao.facade.core.BilanDao;
import ma.sir.dgi.dao.facade.history.BilanHistoryDao;
import ma.sir.dgi.dao.specification.core.BilanSpecification;
import ma.sir.dgi.service.facade.admin.BilanAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.service.Attribute;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.BilanDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.dgi.service.facade.admin.EtatBilanAdminService ;
import ma.sir.dgi.service.facade.admin.SocieteAdminService ;


import java.util.List;
@Service
public class BilanAdminServiceImpl extends AbstractServiceImpl<Bilan,BilanHistory, BilanCriteria, BilanHistoryCriteria, BilanDao,
BilanHistoryDao> implements BilanAdminService {
    public static final String TEMPLATE = "template/bilan.vm";
    public static final String FILE_NAME = "bilan.pdf";
public static final List<Attribute> ATTRIBUTES = new ArrayList<>();
    static{
    ATTRIBUTES.add(new Attribute("id","Long"));
    ATTRIBUTES.add(new Attribute("ref"));
    ATTRIBUTES.add(new Attribute("annee","Integer"));
    ATTRIBUTES.add(new Attribute("immobilisationsIncorporelles","BigDecimal"));
    ATTRIBUTES.add(new Attribute("immobilisationsCorporelles","BigDecimal"));
    ATTRIBUTES.add(new Attribute("immobilisationsFinancieres","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalActifImmobolise","BigDecimal"));
    ATTRIBUTES.add(new Attribute("stocks","BigDecimal"));
    ATTRIBUTES.add(new Attribute("creancesClients","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalActifCirculant","BigDecimal"));
    ATTRIBUTES.add(new Attribute("depotEnBanque","BigDecimal"));
    ATTRIBUTES.add(new Attribute("avoirEnCaisse","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalTresorieActif","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalActif","BigDecimal"));
    ATTRIBUTES.add(new Attribute("capitalPersonnel","BigDecimal"));
    ATTRIBUTES.add(new Attribute("emprunts","BigDecimal"));
    ATTRIBUTES.add(new Attribute("resultat","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalFinnancementPermanant","BigDecimal"));
    ATTRIBUTES.add(new Attribute("dettesFournisseurs","BigDecimal"));
    ATTRIBUTES.add(new Attribute("autresDettesCirculantes","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalPassifCirculant","BigDecimal"));
    ATTRIBUTES.add(new Attribute("totalPassif","BigDecimal"));
    }


    @Override
    public HttpEntity<byte[]> createPdf(BilanDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Bilan findByReferenceEntity(Bilan t){
        return  dao.findByRef(t.getRef());
    }

    public List<Bilan> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<Bilan> findByEtatBilanId(Long id){
        return dao.findByEtatBilanId(id);
    }
    public int deleteByEtatBilanId(Long id){
        return dao.deleteByEtatBilanId(id);
    }


    @Override
    protected List<Attribute> getAttributes() {
        return ATTRIBUTES;
    }


    public void configure() {
        super.configure(Bilan.class,BilanHistory.class, BilanHistoryCriteria.class, BilanSpecification.class);
    }

    @Autowired
    private EtatBilanAdminService etatBilanService ;
    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public BilanAdminServiceImpl(BilanDao dao, BilanHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
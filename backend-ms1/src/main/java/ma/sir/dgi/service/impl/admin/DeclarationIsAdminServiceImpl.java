package ma.sir.dgi.service.impl.admin;

import ma.sir.dgi.bean.core.DeclarationIs;
import ma.sir.dgi.bean.history.DeclarationIsHistory;
import ma.sir.dgi.dao.criteria.core.DeclarationIsCriteria;
import ma.sir.dgi.dao.criteria.history.DeclarationIsHistoryCriteria;
import ma.sir.dgi.dao.facade.core.DeclarationIsDao;
import ma.sir.dgi.dao.facade.history.DeclarationIsHistoryDao;
import ma.sir.dgi.dao.specification.core.DeclarationIsSpecification;
import ma.sir.dgi.service.facade.admin.DeclarationIsAdminService;
import ma.sir.dgi.zynerator.service.AbstractServiceImpl;
import ma.sir.dgi.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.dgi.zynerator.util.VelocityPdf;
import ma.sir.dgi.ws.dto.DeclarationIsDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.dgi.bean.core.FactureCharge;
import ma.sir.dgi.bean.core.FactureProduit;

import ma.sir.dgi.service.facade.admin.FactureChargeAdminService ;
import ma.sir.dgi.service.facade.admin.FactureProduitAdminService ;
import ma.sir.dgi.service.facade.admin.SocieteAdminService ;
import ma.sir.dgi.service.facade.admin.TauxIsAdminService ;


import java.util.List;
@Service
public class DeclarationIsAdminServiceImpl extends AbstractServiceImpl<DeclarationIs,DeclarationIsHistory, DeclarationIsCriteria, DeclarationIsHistoryCriteria, DeclarationIsDao,
DeclarationIsHistoryDao> implements DeclarationIsAdminService {
    public static final String TEMPLATE = "template/declarationIs.vm";
    public static final String FILE_NAME = "declarationIs.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DeclarationIsDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public DeclarationIs create(DeclarationIs t) {
        super.create(t);
        if (t.getFactureCharges() != null) {
                t.getFactureCharges().forEach(element-> {
                    element.setDeclarationIs(t);
                    factureChargeService.create(element);
            });
        }
        if (t.getFactureProduits() != null) {
                t.getFactureProduits().forEach(element-> {
                    element.setDeclarationIs(t);
                    factureProduitService.create(element);
            });
        }
        return t;
    }

    public DeclarationIs findWithAssociatedLists(Long id){
        DeclarationIs result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setFactureCharges(factureChargeService.findByDeclarationIsId(id));
            result.setFactureProduits(factureProduitService.findByDeclarationIsId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        factureChargeService.deleteByDeclarationIsId(id);
        factureProduitService.deleteByDeclarationIsId(id);
    }


    public void updateWithAssociatedLists(DeclarationIs declarationIs){
    if(declarationIs !=null && declarationIs.getId() != null){
            List<List<FactureCharge>> resultFactureCharges= factureChargeService.getToBeSavedAndToBeDeleted(factureChargeService.findByDeclarationIsId(declarationIs.getId()),declarationIs.getFactureCharges());
            factureChargeService.delete(resultFactureCharges.get(1));
            ListUtil.emptyIfNull(resultFactureCharges.get(0)).forEach(e -> e.setDeclarationIs(declarationIs));
            factureChargeService.update(resultFactureCharges.get(0),true);
            List<List<FactureProduit>> resultFactureProduits= factureProduitService.getToBeSavedAndToBeDeleted(factureProduitService.findByDeclarationIsId(declarationIs.getId()),declarationIs.getFactureProduits());
            factureProduitService.delete(resultFactureProduits.get(1));
            ListUtil.emptyIfNull(resultFactureProduits.get(0)).forEach(e -> e.setDeclarationIs(declarationIs));
            factureProduitService.update(resultFactureProduits.get(0),true);
    }
    }


    public List<DeclarationIs> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<DeclarationIs> findByTauxIsId(Long id){
        return dao.findByTauxIsId(id);
    }
    public int deleteByTauxIsId(Long id){
        return dao.deleteByTauxIsId(id);
    }




    public void configure() {
        super.configure(DeclarationIs.class,DeclarationIsHistory.class, DeclarationIsHistoryCriteria.class, DeclarationIsSpecification.class);
    }

    @Autowired
    private FactureChargeAdminService factureChargeService ;
    @Autowired
    private FactureProduitAdminService factureProduitService ;
    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private TauxIsAdminService tauxIsService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DeclarationIsAdminServiceImpl(DeclarationIsDao dao, DeclarationIsHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
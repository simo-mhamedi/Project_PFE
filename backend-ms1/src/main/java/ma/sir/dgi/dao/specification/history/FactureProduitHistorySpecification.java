package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.FactureProduitHistoryCriteria;
import ma.sir.dgi.bean.history.FactureProduitHistory;


public class FactureProduitHistorySpecification extends AbstractHistorySpecification<FactureProduitHistoryCriteria, FactureProduitHistory> {

    public FactureProduitHistorySpecification(FactureProduitHistoryCriteria criteria) {
        super(criteria);
    }

    public FactureProduitHistorySpecification(FactureProduitHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

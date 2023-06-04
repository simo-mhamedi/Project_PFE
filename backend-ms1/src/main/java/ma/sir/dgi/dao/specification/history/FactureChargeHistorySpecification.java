package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.FactureChargeHistoryCriteria;
import ma.sir.dgi.bean.history.FactureChargeHistory;


public class FactureChargeHistorySpecification extends AbstractHistorySpecification<FactureChargeHistoryCriteria, FactureChargeHistory> {

    public FactureChargeHistorySpecification(FactureChargeHistoryCriteria criteria) {
        super(criteria);
    }

    public FactureChargeHistorySpecification(FactureChargeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

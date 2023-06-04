package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.DeclarationIsHistoryCriteria;
import ma.sir.dgi.bean.history.DeclarationIsHistory;


public class DeclarationIsHistorySpecification extends AbstractHistorySpecification<DeclarationIsHistoryCriteria, DeclarationIsHistory> {

    public DeclarationIsHistorySpecification(DeclarationIsHistoryCriteria criteria) {
        super(criteria);
    }

    public DeclarationIsHistorySpecification(DeclarationIsHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

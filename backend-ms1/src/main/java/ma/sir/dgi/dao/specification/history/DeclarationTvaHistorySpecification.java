package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.DeclarationTvaHistoryCriteria;
import ma.sir.dgi.bean.history.DeclarationTvaHistory;


public class DeclarationTvaHistorySpecification extends AbstractHistorySpecification<DeclarationTvaHistoryCriteria, DeclarationTvaHistory> {

    public DeclarationTvaHistorySpecification(DeclarationTvaHistoryCriteria criteria) {
        super(criteria);
    }

    public DeclarationTvaHistorySpecification(DeclarationTvaHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

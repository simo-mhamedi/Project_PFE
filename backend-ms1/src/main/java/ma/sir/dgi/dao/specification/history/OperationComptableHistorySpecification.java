package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.OperationComptableHistoryCriteria;
import ma.sir.dgi.bean.history.OperationComptableHistory;


public class OperationComptableHistorySpecification extends AbstractHistorySpecification<OperationComptableHistoryCriteria, OperationComptableHistory> {

    public OperationComptableHistorySpecification(OperationComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public OperationComptableHistorySpecification(OperationComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

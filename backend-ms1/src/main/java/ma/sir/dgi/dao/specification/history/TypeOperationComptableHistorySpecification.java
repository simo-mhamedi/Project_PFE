package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.TypeOperationComptableHistoryCriteria;
import ma.sir.dgi.bean.history.TypeOperationComptableHistory;


public class TypeOperationComptableHistorySpecification extends AbstractHistorySpecification<TypeOperationComptableHistoryCriteria, TypeOperationComptableHistory> {

    public TypeOperationComptableHistorySpecification(TypeOperationComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public TypeOperationComptableHistorySpecification(TypeOperationComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

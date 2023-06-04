package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.ClassComptableHistoryCriteria;
import ma.sir.dgi.bean.history.ClassComptableHistory;


public class ClassComptableHistorySpecification extends AbstractHistorySpecification<ClassComptableHistoryCriteria, ClassComptableHistory> {

    public ClassComptableHistorySpecification(ClassComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public ClassComptableHistorySpecification(ClassComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

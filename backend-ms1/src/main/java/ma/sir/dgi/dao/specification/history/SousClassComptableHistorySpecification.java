package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.dgi.bean.history.SousClassComptableHistory;


public class SousClassComptableHistorySpecification extends AbstractHistorySpecification<SousClassComptableHistoryCriteria, SousClassComptableHistory> {

    public SousClassComptableHistorySpecification(SousClassComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public SousClassComptableHistorySpecification(SousClassComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

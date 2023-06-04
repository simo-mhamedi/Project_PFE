package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.dgi.bean.history.TauxRetardTvaHistory;


public class TauxRetardTvaHistorySpecification extends AbstractHistorySpecification<TauxRetardTvaHistoryCriteria, TauxRetardTvaHistory> {

    public TauxRetardTvaHistorySpecification(TauxRetardTvaHistoryCriteria criteria) {
        super(criteria);
    }

    public TauxRetardTvaHistorySpecification(TauxRetardTvaHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

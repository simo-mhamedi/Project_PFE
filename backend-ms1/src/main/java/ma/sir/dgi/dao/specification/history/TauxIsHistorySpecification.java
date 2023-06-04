package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.TauxIsHistoryCriteria;
import ma.sir.dgi.bean.history.TauxIsHistory;


public class TauxIsHistorySpecification extends AbstractHistorySpecification<TauxIsHistoryCriteria, TauxIsHistory> {

    public TauxIsHistorySpecification(TauxIsHistoryCriteria criteria) {
        super(criteria);
    }

    public TauxIsHistorySpecification(TauxIsHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

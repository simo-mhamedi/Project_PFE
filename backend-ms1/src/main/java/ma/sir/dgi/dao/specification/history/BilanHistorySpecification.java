package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.BilanHistoryCriteria;
import ma.sir.dgi.bean.history.BilanHistory;


public class BilanHistorySpecification extends AbstractHistorySpecification<BilanHistoryCriteria, BilanHistory> {

    public BilanHistorySpecification(BilanHistoryCriteria criteria) {
        super(criteria);
    }

    public BilanHistorySpecification(BilanHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

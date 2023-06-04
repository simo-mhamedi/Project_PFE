package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.EtatBilanHistoryCriteria;
import ma.sir.dgi.bean.history.EtatBilanHistory;


public class EtatBilanHistorySpecification extends AbstractHistorySpecification<EtatBilanHistoryCriteria, EtatBilanHistory> {

    public EtatBilanHistorySpecification(EtatBilanHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatBilanHistorySpecification(EtatBilanHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

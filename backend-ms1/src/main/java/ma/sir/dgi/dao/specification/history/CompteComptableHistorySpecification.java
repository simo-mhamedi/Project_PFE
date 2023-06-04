package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.CompteComptableHistoryCriteria;
import ma.sir.dgi.bean.history.CompteComptableHistory;


public class CompteComptableHistorySpecification extends AbstractHistorySpecification<CompteComptableHistoryCriteria, CompteComptableHistory> {

    public CompteComptableHistorySpecification(CompteComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public CompteComptableHistorySpecification(CompteComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

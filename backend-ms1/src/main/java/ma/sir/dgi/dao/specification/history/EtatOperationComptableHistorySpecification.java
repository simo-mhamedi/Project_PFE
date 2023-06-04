package  ma.sir.dgi.dao.specification.history;

import ma.sir.dgi.zynerator.specification.AbstractHistorySpecification;
import ma.sir.dgi.dao.criteria.history.EtatOperationComptableHistoryCriteria;
import ma.sir.dgi.bean.history.EtatOperationComptableHistory;


public class EtatOperationComptableHistorySpecification extends AbstractHistorySpecification<EtatOperationComptableHistoryCriteria, EtatOperationComptableHistory> {

    public EtatOperationComptableHistorySpecification(EtatOperationComptableHistoryCriteria criteria) {
        super(criteria);
    }

    public EtatOperationComptableHistorySpecification(EtatOperationComptableHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

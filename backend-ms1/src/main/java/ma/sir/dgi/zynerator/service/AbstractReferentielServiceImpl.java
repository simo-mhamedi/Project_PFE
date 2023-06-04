package ma.sir.dgi.zynerator.service;

import ma.sir.dgi.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sir.dgi.zynerator.criteria.BaseCriteria;
import ma.sir.dgi.zynerator.history.HistBusinessObject;
import ma.sir.dgi.zynerator.history.HistCriteria;
import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}
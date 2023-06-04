package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.EtatOperationComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatOperationComptableHistoryDao extends AbstractHistoryRepository<EtatOperationComptableHistory,Long> {

}

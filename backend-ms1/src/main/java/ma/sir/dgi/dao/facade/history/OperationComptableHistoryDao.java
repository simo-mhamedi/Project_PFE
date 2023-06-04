package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.OperationComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationComptableHistoryDao extends AbstractHistoryRepository<OperationComptableHistory,Long> {

}

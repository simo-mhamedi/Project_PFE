package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.TypeOperationComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOperationComptableHistoryDao extends AbstractHistoryRepository<TypeOperationComptableHistory,Long> {

}

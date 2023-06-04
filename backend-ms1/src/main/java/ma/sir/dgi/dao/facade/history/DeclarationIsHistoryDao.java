package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.DeclarationIsHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationIsHistoryDao extends AbstractHistoryRepository<DeclarationIsHistory,Long> {

}

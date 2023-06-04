package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.DeclarationTvaHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationTvaHistoryDao extends AbstractHistoryRepository<DeclarationTvaHistory,Long> {

}

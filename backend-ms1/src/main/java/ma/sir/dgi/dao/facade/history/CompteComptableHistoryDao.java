package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.CompteComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteComptableHistoryDao extends AbstractHistoryRepository<CompteComptableHistory,Long> {

}

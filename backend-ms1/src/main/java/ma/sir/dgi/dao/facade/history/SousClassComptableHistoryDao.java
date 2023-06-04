package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.SousClassComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SousClassComptableHistoryDao extends AbstractHistoryRepository<SousClassComptableHistory,Long> {

}

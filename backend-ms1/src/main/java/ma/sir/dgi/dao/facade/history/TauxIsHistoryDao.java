package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.TauxIsHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxIsHistoryDao extends AbstractHistoryRepository<TauxIsHistory,Long> {

}

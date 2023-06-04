package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.TauxRetardTvaHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxRetardTvaHistoryDao extends AbstractHistoryRepository<TauxRetardTvaHistory,Long> {

}

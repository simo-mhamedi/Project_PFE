package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.BilanHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BilanHistoryDao extends AbstractHistoryRepository<BilanHistory,Long> {

}

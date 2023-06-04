package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.SocieteHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteHistoryDao extends AbstractHistoryRepository<SocieteHistory,Long> {

}

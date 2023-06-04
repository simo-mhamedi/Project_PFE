package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.FactureChargeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureChargeHistoryDao extends AbstractHistoryRepository<FactureChargeHistory,Long> {

}

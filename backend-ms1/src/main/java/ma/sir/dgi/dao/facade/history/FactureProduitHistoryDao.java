package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.FactureProduitHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureProduitHistoryDao extends AbstractHistoryRepository<FactureProduitHistory,Long> {

}

package ma.sir.dgi.dao.facade.history;

import ma.sir.dgi.zynerator.repository.AbstractHistoryRepository;
import ma.sir.dgi.bean.history.ClassComptableHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassComptableHistoryDao extends AbstractHistoryRepository<ClassComptableHistory,Long> {

}

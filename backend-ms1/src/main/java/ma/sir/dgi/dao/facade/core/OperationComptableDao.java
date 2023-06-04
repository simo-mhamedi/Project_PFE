package ma.sir.dgi.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.OperationComptable;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface OperationComptableDao extends AbstractRepository<OperationComptable,Long>  {

    List<OperationComptable> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<OperationComptable> findByCompteComptableId(Long id);
    int deleteByCompteComptableId(Long id);
    List<OperationComptable> findByTypeOperationComptableId(Long id);
    int deleteByTypeOperationComptableId(Long id);
    List<OperationComptable> findByEtatOperationComptableId(Long id);
    int deleteByEtatOperationComptableId(Long id);

    @Query("SELECT NEW OperationComptable(item.id,item.libelle) FROM OperationComptable item")
    List<OperationComptable> findAllOptimized();
}

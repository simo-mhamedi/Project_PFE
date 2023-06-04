package ma.sir.dgi.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.EtatOperationComptable;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EtatOperationComptableDao extends AbstractRepository<EtatOperationComptable,Long>  {


    @Query("SELECT NEW EtatOperationComptable(item.id,item.libelle) FROM EtatOperationComptable item")
    List<EtatOperationComptable> findAllOptimized();
}

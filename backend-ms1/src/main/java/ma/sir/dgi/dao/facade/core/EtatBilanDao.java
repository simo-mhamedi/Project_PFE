package ma.sir.dgi.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.EtatBilan;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EtatBilanDao extends AbstractRepository<EtatBilan,Long>  {


    @Query("SELECT NEW EtatBilan(item.id,item.libelle) FROM EtatBilan item")
    List<EtatBilan> findAllOptimized();
}

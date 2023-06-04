package ma.sir.dgi.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.Bilan;
import org.springframework.stereotype.Repository;
import ma.sir.dgi.bean.core.Bilan;
import java.util.List;


@Repository
public interface BilanDao extends AbstractRepository<Bilan,Long>  {
    Bilan findByRef(String ref);
    int deleteByRef(String ref);

    List<Bilan> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<Bilan> findByEtatBilanId(Long id);
    int deleteByEtatBilanId(Long id);

    @Query("SELECT NEW Bilan(item.id,item.ref) FROM Bilan item")
    List<Bilan> findAllOptimized();
}

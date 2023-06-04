package ma.sir.dgi.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.SousClassComptable;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SousClassComptableDao extends AbstractRepository<SousClassComptable,Long>  {

    List<SousClassComptable> findByClassComptableId(Long id);
    int deleteByClassComptableId(Long id);

    @Query("SELECT NEW SousClassComptable(item.id,item.libelle) FROM SousClassComptable item")
    List<SousClassComptable> findAllOptimized();
}

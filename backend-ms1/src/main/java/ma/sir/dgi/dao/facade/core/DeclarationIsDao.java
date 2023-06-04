package ma.sir.dgi.dao.facade.core;

import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.DeclarationIs;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DeclarationIsDao extends AbstractRepository<DeclarationIs,Long>  {

    List<DeclarationIs> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationIs> findByTauxIsId(Long id);
    int deleteByTauxIsId(Long id);

}

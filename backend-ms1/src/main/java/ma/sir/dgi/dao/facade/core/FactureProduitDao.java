package ma.sir.dgi.dao.facade.core;

import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.FactureProduit;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FactureProduitDao extends AbstractRepository<FactureProduit,Long>  {

    List<FactureProduit> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<FactureProduit> findByDeclarationIsId(Long id);
    int deleteByDeclarationIsId(Long id);

}

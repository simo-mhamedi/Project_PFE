package ma.sir.dgi.dao.facade.core;

import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.FactureCharge;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface FactureChargeDao extends AbstractRepository<FactureCharge,Long>  {

    List<FactureCharge> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<FactureCharge> findByDeclarationIsId(Long id);
    int deleteByDeclarationIsId(Long id);

}

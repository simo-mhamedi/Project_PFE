package ma.sir.dgi.dao.facade.core;

import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.TauxIs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface TauxIsDao extends AbstractRepository<TauxIs,Long>  {

    @Query(value = "SELECT t FROM TauxIs t WHERE t.resultatMax >= :montant AND t.resultatMin <= :montant ORDER BY t.resultatMax ASC")
    List<TauxIs> findTauxIsInRange(@Param("montant") BigDecimal montant);



}

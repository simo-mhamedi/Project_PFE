package ma.sir.dgi.dao.facade.core;

import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.TauxRetardTva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TauxRetardTvaDao extends AbstractRepository<TauxRetardTva,Long>  {

    @Query("SELECT t FROM TauxRetardTva t " +
            "WHERE t.dateApplicationMin <= :date AND t.dateApplicationMax >= :date")
    TauxRetardTva findTauxRetardTvaBetweenDates(LocalDateTime date);

}

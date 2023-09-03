package ma.sir.dgi.dao.facade.core;

import ma.sir.dgi.bean.core.FactureProduit;
import ma.sir.dgi.zynerator.repository.AbstractRepository;
import ma.sir.dgi.bean.core.FactureCharge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface FactureChargeDao extends AbstractRepository<FactureCharge,Long>  {

    List<FactureCharge> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<FactureCharge> findByDeclarationIsId(Long id);
    int deleteByDeclarationIsId(Long id);
    List<FactureCharge> findBySocieteIce(String ice);
    List<FactureCharge> findBySocieteIdAndDeclarationIsAnneeAndDeclarationIsTrimistre
            (Long id,Integer annee,Integer Trimestre);
    @Query("SELECT SUM(f.montantHt) FROM FactureCharge f WHERE f.societe.id = :societeId AND f.declarationIs.annee = :annee AND f.declarationIs.trimistre = :trimestre")
    BigDecimal sumMontantHtBySocieteIdAndAnneeAndTrimestre(
            @Param("societeId") Long societeId,
            @Param("annee") Integer annee,
            @Param("trimestre") Integer trimestre
    );
}

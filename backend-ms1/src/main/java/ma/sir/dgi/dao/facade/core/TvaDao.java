package ma.sir.dgi.dao.facade.core;

import ma.sir.dgi.bean.core.DeclarationTva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvaDao  extends JpaRepository<DeclarationTva,Long> {
    DeclarationTva findByTrimistreAndAnneeAndSocieteId(Integer trimistre, Integer annee, Long societeId);
}

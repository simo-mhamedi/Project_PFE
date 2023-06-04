package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.FactureProduit;
import ma.sir.dgi.dao.criteria.core.FactureProduitCriteria;
import ma.sir.dgi.dao.criteria.history.FactureProduitHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.FactureProduitDto;
import org.springframework.http.HttpEntity;

public interface FactureProduitAdminService extends  IService<FactureProduit,FactureProduitCriteria, FactureProduitHistoryCriteria>  {

    List<FactureProduit> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<FactureProduit> findByDeclarationIsId(Long id);
    int deleteByDeclarationIsId(Long id);

    HttpEntity<byte[]> createPdf(FactureProduitDto dto) throws Exception;


}

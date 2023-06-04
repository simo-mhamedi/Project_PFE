package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.DeclarationIs;
import ma.sir.dgi.dao.criteria.core.DeclarationIsCriteria;
import ma.sir.dgi.dao.criteria.history.DeclarationIsHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.DeclarationIsDto;
import org.springframework.http.HttpEntity;

public interface DeclarationIsAdminService extends  IService<DeclarationIs,DeclarationIsCriteria, DeclarationIsHistoryCriteria>  {

    List<DeclarationIs> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationIs> findByTauxIsId(Long id);
    int deleteByTauxIsId(Long id);

    HttpEntity<byte[]> createPdf(DeclarationIsDto dto) throws Exception;


}

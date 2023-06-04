package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.DeclarationTva;
import ma.sir.dgi.dao.criteria.core.DeclarationTvaCriteria;
import ma.sir.dgi.dao.criteria.history.DeclarationTvaHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.DeclarationTvaDto;
import org.springframework.http.HttpEntity;

public interface DeclarationTvaAdminService extends  IService<DeclarationTva,DeclarationTvaCriteria, DeclarationTvaHistoryCriteria>  {

    List<DeclarationTva> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<DeclarationTva> findByTauxRetardTvaId(Long id);
    int deleteByTauxRetardTvaId(Long id);

    HttpEntity<byte[]> createPdf(DeclarationTvaDto dto) throws Exception;


}

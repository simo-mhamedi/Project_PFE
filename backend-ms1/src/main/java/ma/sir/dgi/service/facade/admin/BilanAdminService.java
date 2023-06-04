package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.Bilan;
import ma.sir.dgi.dao.criteria.core.BilanCriteria;
import ma.sir.dgi.dao.criteria.history.BilanHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.BilanDto;
import org.springframework.http.HttpEntity;

public interface BilanAdminService extends  IService<Bilan,BilanCriteria, BilanHistoryCriteria>  {

    List<Bilan> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<Bilan> findByEtatBilanId(Long id);
    int deleteByEtatBilanId(Long id);

    HttpEntity<byte[]> createPdf(BilanDto dto) throws Exception;


}

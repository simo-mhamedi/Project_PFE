package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.EtatBilan;
import ma.sir.dgi.dao.criteria.core.EtatBilanCriteria;
import ma.sir.dgi.dao.criteria.history.EtatBilanHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.EtatBilanDto;
import org.springframework.http.HttpEntity;

public interface EtatBilanAdminService extends  IService<EtatBilan,EtatBilanCriteria, EtatBilanHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatBilanDto dto) throws Exception;


}

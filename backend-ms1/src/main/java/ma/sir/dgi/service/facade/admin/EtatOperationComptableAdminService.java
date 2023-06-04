package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.EtatOperationComptable;
import ma.sir.dgi.dao.criteria.core.EtatOperationComptableCriteria;
import ma.sir.dgi.dao.criteria.history.EtatOperationComptableHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.EtatOperationComptableDto;
import org.springframework.http.HttpEntity;

public interface EtatOperationComptableAdminService extends  IService<EtatOperationComptable,EtatOperationComptableCriteria, EtatOperationComptableHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(EtatOperationComptableDto dto) throws Exception;


}

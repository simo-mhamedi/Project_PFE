package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.TypeOperationComptable;
import ma.sir.dgi.dao.criteria.core.TypeOperationComptableCriteria;
import ma.sir.dgi.dao.criteria.history.TypeOperationComptableHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.TypeOperationComptableDto;
import org.springframework.http.HttpEntity;

public interface TypeOperationComptableAdminService extends  IService<TypeOperationComptable,TypeOperationComptableCriteria, TypeOperationComptableHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(TypeOperationComptableDto dto) throws Exception;


}

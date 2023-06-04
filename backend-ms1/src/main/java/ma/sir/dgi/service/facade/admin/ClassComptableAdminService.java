package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.ClassComptable;
import ma.sir.dgi.dao.criteria.core.ClassComptableCriteria;
import ma.sir.dgi.dao.criteria.history.ClassComptableHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.ClassComptableDto;
import org.springframework.http.HttpEntity;

public interface ClassComptableAdminService extends  IService<ClassComptable,ClassComptableCriteria, ClassComptableHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ClassComptableDto dto) throws Exception;


}

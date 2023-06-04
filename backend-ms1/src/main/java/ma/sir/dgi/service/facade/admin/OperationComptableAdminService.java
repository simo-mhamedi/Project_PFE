package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.OperationComptable;
import ma.sir.dgi.dao.criteria.core.OperationComptableCriteria;
import ma.sir.dgi.dao.criteria.history.OperationComptableHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.OperationComptableDto;
import org.springframework.http.HttpEntity;

public interface OperationComptableAdminService extends  IService<OperationComptable,OperationComptableCriteria, OperationComptableHistoryCriteria>  {

    List<OperationComptable> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<OperationComptable> findByCompteComptableId(Long id);
    int deleteByCompteComptableId(Long id);
    List<OperationComptable> findByTypeOperationComptableId(Long id);
    int deleteByTypeOperationComptableId(Long id);
    List<OperationComptable> findByEtatOperationComptableId(Long id);
    int deleteByEtatOperationComptableId(Long id);

    HttpEntity<byte[]> createPdf(OperationComptableDto dto) throws Exception;


}

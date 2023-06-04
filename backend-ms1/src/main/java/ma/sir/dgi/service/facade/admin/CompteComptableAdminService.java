package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.CompteComptable;
import ma.sir.dgi.dao.criteria.core.CompteComptableCriteria;
import ma.sir.dgi.dao.criteria.history.CompteComptableHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.CompteComptableDto;
import org.springframework.http.HttpEntity;

public interface CompteComptableAdminService extends  IService<CompteComptable,CompteComptableCriteria, CompteComptableHistoryCriteria>  {

    List<CompteComptable> findBySousClassComptableId(Long id);
    int deleteBySousClassComptableId(Long id);

    HttpEntity<byte[]> createPdf(CompteComptableDto dto) throws Exception;


}

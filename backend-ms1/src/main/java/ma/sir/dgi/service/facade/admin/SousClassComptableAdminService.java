package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.SousClassComptable;
import ma.sir.dgi.dao.criteria.core.SousClassComptableCriteria;
import ma.sir.dgi.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.SousClassComptableDto;
import org.springframework.http.HttpEntity;

public interface SousClassComptableAdminService extends  IService<SousClassComptable,SousClassComptableCriteria, SousClassComptableHistoryCriteria>  {

    List<SousClassComptable> findByClassComptableId(Long id);
    int deleteByClassComptableId(Long id);

    HttpEntity<byte[]> createPdf(SousClassComptableDto dto) throws Exception;


}

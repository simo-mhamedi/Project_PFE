package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.FactureCharge;
import ma.sir.dgi.dao.criteria.core.FactureChargeCriteria;
import ma.sir.dgi.dao.criteria.history.FactureChargeHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.FactureChargeDto;
import org.springframework.http.HttpEntity;

public interface FactureChargeAdminService extends  IService<FactureCharge,FactureChargeCriteria, FactureChargeHistoryCriteria>  {

    List<FactureCharge> findBySocieteId(Long id);
    int deleteBySocieteId(Long id);
    List<FactureCharge> findByDeclarationIsId(Long id);
    int deleteByDeclarationIsId(Long id);

    HttpEntity<byte[]> createPdf(FactureChargeDto dto) throws Exception;


}

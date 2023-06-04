package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.TauxIs;
import ma.sir.dgi.dao.criteria.core.TauxIsCriteria;
import ma.sir.dgi.dao.criteria.history.TauxIsHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.TauxIsDto;
import org.springframework.http.HttpEntity;

public interface TauxIsAdminService extends  IService<TauxIs,TauxIsCriteria, TauxIsHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(TauxIsDto dto) throws Exception;


}

package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.TauxRetardTva;
import ma.sir.dgi.dao.criteria.core.TauxRetardTvaCriteria;
import ma.sir.dgi.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.TauxRetardTvaDto;
import org.springframework.http.HttpEntity;

public interface TauxRetardTvaAdminService extends  IService<TauxRetardTva,TauxRetardTvaCriteria, TauxRetardTvaHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(TauxRetardTvaDto dto) throws Exception;


}

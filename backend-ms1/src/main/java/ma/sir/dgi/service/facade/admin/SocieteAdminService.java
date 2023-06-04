package ma.sir.dgi.service.facade.admin;

import java.util.List;
import ma.sir.dgi.bean.core.Societe;
import ma.sir.dgi.dao.criteria.core.SocieteCriteria;
import ma.sir.dgi.dao.criteria.history.SocieteHistoryCriteria;
import ma.sir.dgi.zynerator.service.IService;

import ma.sir.dgi.ws.dto.SocieteDto;
import org.springframework.http.HttpEntity;

public interface SocieteAdminService extends  IService<Societe,SocieteCriteria, SocieteHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(SocieteDto dto) throws Exception;


}

package  ma.sir.dgi.ws.dto;

import ma.sir.dgi.zynerator.audit.Log;
import ma.sir.dgi.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtatBilanDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;




    public EtatBilanDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }






}

package  ma.sir.dgi.ws.dto;

import ma.sir.dgi.zynerator.audit.Log;
import ma.sir.dgi.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class FactureChargeDto  extends AuditBaseDto {

    private String dateFacuture ;
    private String ice  ;
    private BigDecimal montantHt  ;
    private BigDecimal montantTtc  ;
    private BigDecimal montantTva  ;

    private SocieteDto societe ;
    private DeclarationIsDto declarationIs ;



    public FactureChargeDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFacuture(){
        return this.dateFacuture;
    }
    public void setDateFacuture(String dateFacuture){
        this.dateFacuture = dateFacuture;
    }

    @Log
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }

    @Log
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }

    @Log
    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }

    @Log
    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }


    public SocieteDto getSociete(){
        return this.societe;
    }

    public void setSociete(SocieteDto societe){
        this.societe = societe;
    }
    public DeclarationIsDto getDeclarationIs(){
        return this.declarationIs;
    }

    public void setDeclarationIs(DeclarationIsDto declarationIs){
        this.declarationIs = declarationIs;
    }




}

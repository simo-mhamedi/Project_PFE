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
public class DeclarationTvaDto  extends AuditBaseDto {

    private String dateDeclaration ;
    private String dateDeclarationStr ;
    private Integer trimistre  = 0 ;
    private Integer annee  = 0 ;
    private BigDecimal totalTvaCollecte  ;
    private BigDecimal totalTvaDue  ;
    private BigDecimal differenceTva  ;
    private BigDecimal montantTva  ;

    private SocieteDto societe ;
    private TauxRetardTvaDto tauxRetardTva ;



    public DeclarationTvaDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDeclaration(){
        return this.dateDeclaration;
    }
    public void setDateDeclaration(String dateDeclaration){
        this.dateDeclaration = dateDeclaration;
    }

    @Log
    public Integer getTrimistre(){
        return this.trimistre;
    }
    public void setTrimistre(Integer trimistre){
        this.trimistre = trimistre;
    }

    @Log
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }

    @Log
    public BigDecimal getTotalTvaCollecte(){
        return this.totalTvaCollecte;
    }
    public void setTotalTvaCollecte(BigDecimal totalTvaCollecte){
        this.totalTvaCollecte = totalTvaCollecte;
    }

    @Log
    public BigDecimal getTotalTvaDue(){
        return this.totalTvaDue;
    }
    public void setTotalTvaDue(BigDecimal totalTvaDue){
        this.totalTvaDue = totalTvaDue;
    }

    @Log
    public BigDecimal getDifferenceTva(){
        return this.differenceTva;
    }
    public void setDifferenceTva(BigDecimal differenceTva){
        this.differenceTva = differenceTva;
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
    public TauxRetardTvaDto getTauxRetardTva(){
        return this.tauxRetardTva;
    }

    public void setTauxRetardTva(TauxRetardTvaDto tauxRetardTva){
        this.tauxRetardTva = tauxRetardTva;
    }


    public String getDateDeclarationStr() {
        return dateDeclarationStr;
    }

    public void setDateDeclarationStr(String dateDeclarationStr) {
        this.dateDeclarationStr = dateDeclarationStr;
    }
}

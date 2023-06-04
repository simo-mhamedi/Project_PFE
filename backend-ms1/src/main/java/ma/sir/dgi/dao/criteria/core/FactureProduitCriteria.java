package  ma.sir.dgi.dao.criteria.core;


import ma.sir.dgi.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class FactureProduitCriteria extends  BaseCriteria  {

    private LocalDateTime dateFacuture;
    private LocalDateTime dateFacutureFrom;
    private LocalDateTime dateFacutureTo;
    private String ice;
    private String iceLike;
    private String montantHt;
    private String montantHtMin;
    private String montantHtMax;
    private String montantTtc;
    private String montantTtcMin;
    private String montantTtcMax;
    private String montantTva;
    private String montantTvaMin;
    private String montantTvaMax;

    private SocieteCriteria societe ;
    private List<SocieteCriteria> societes ;
    private DeclarationIsCriteria declarationIs ;
    private List<DeclarationIsCriteria> declarationIss ;


    public FactureProduitCriteria(){}

    public LocalDateTime getDateFacuture(){
        return this.dateFacuture;
    }
    public void setDateFacuture(LocalDateTime dateFacuture){
        this.dateFacuture = dateFacuture;
    }
    public LocalDateTime getDateFacutureFrom(){
        return this.dateFacutureFrom;
    }
    public void setDateFacutureFrom(LocalDateTime dateFacutureFrom){
        this.dateFacutureFrom = dateFacutureFrom;
    }
    public LocalDateTime getDateFacutureTo(){
        return this.dateFacutureTo;
    }
    public void setDateFacutureTo(LocalDateTime dateFacutureTo){
        this.dateFacutureTo = dateFacutureTo;
    }
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getIceLike(){
        return this.iceLike;
    }
    public void setIceLike(String iceLike){
        this.iceLike = iceLike;
    }

    public String getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(String montantHt){
        this.montantHt = montantHt;
    }   
    public String getMontantHtMin(){
        return this.montantHtMin;
    }
    public void setMontantHtMin(String montantHtMin){
        this.montantHtMin = montantHtMin;
    }
    public String getMontantHtMax(){
        return this.montantHtMax;
    }
    public void setMontantHtMax(String montantHtMax){
        this.montantHtMax = montantHtMax;
    }
      
    public String getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(String montantTtc){
        this.montantTtc = montantTtc;
    }   
    public String getMontantTtcMin(){
        return this.montantTtcMin;
    }
    public void setMontantTtcMin(String montantTtcMin){
        this.montantTtcMin = montantTtcMin;
    }
    public String getMontantTtcMax(){
        return this.montantTtcMax;
    }
    public void setMontantTtcMax(String montantTtcMax){
        this.montantTtcMax = montantTtcMax;
    }
      
    public String getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(String montantTva){
        this.montantTva = montantTva;
    }   
    public String getMontantTvaMin(){
        return this.montantTvaMin;
    }
    public void setMontantTvaMin(String montantTvaMin){
        this.montantTvaMin = montantTvaMin;
    }
    public String getMontantTvaMax(){
        return this.montantTvaMax;
    }
    public void setMontantTvaMax(String montantTvaMax){
        this.montantTvaMax = montantTvaMax;
    }
      

    public SocieteCriteria getSociete(){
        return this.societe;
    }

    public void setSociete(SocieteCriteria societe){
        this.societe = societe;
    }
    public List<SocieteCriteria> getSocietes(){
        return this.societes;
    }

    public void setSocietes(List<SocieteCriteria> societes){
        this.societes = societes;
    }
    public DeclarationIsCriteria getDeclarationIs(){
        return this.declarationIs;
    }

    public void setDeclarationIs(DeclarationIsCriteria declarationIs){
        this.declarationIs = declarationIs;
    }
    public List<DeclarationIsCriteria> getDeclarationIss(){
        return this.declarationIss;
    }

    public void setDeclarationIss(List<DeclarationIsCriteria> declarationIss){
        this.declarationIss = declarationIss;
    }
}

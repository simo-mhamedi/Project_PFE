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
public class OperationComptableDto  extends AuditBaseDto {

    private String libelle  ;
    private Integer annee  = 0 ;
    private Integer mois  = 0 ;
    private String dateOperationComptable ;
    private BigDecimal montant  ;

    private SocieteDto societe ;
    private CompteComptableDto compteComptable ;
    private TypeOperationComptableDto typeOperationComptable ;
    private EtatOperationComptableDto etatOperationComptable ;



    public OperationComptableDto(){
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
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }

    @Log
    public Integer getMois(){
        return this.mois;
    }
    public void setMois(Integer mois){
        this.mois = mois;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateOperationComptable(){
        return this.dateOperationComptable;
    }
    public void setDateOperationComptable(String dateOperationComptable){
        this.dateOperationComptable = dateOperationComptable;
    }

    @Log
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }


    public SocieteDto getSociete(){
        return this.societe;
    }

    public void setSociete(SocieteDto societe){
        this.societe = societe;
    }
    public CompteComptableDto getCompteComptable(){
        return this.compteComptable;
    }

    public void setCompteComptable(CompteComptableDto compteComptable){
        this.compteComptable = compteComptable;
    }
    public TypeOperationComptableDto getTypeOperationComptable(){
        return this.typeOperationComptable;
    }

    public void setTypeOperationComptable(TypeOperationComptableDto typeOperationComptable){
        this.typeOperationComptable = typeOperationComptable;
    }
    public EtatOperationComptableDto getEtatOperationComptable(){
        return this.etatOperationComptable;
    }

    public void setEtatOperationComptable(EtatOperationComptableDto etatOperationComptable){
        this.etatOperationComptable = etatOperationComptable;
    }




}

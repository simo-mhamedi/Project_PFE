package  ma.sir.dgi.dao.criteria.core;


import ma.sir.dgi.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class OperationComptableCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String annee;
    private String anneeMin;
    private String anneeMax;
    private String mois;
    private String moisMin;
    private String moisMax;
    private LocalDateTime dateOperationComptable;
    private LocalDateTime dateOperationComptableFrom;
    private LocalDateTime dateOperationComptableTo;
    private String montant;
    private String montantMin;
    private String montantMax;

    private SocieteCriteria societe ;
    private List<SocieteCriteria> societes ;
    private CompteComptableCriteria compteComptable ;
    private List<CompteComptableCriteria> compteComptables ;
    private TypeOperationComptableCriteria typeOperationComptable ;
    private List<TypeOperationComptableCriteria> typeOperationComptables ;
    private EtatOperationComptableCriteria etatOperationComptable ;
    private List<EtatOperationComptableCriteria> etatOperationComptables ;


    public OperationComptableCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getAnnee(){
        return this.annee;
    }
    public void setAnnee(String annee){
        this.annee = annee;
    }   
    public String getAnneeMin(){
        return this.anneeMin;
    }
    public void setAnneeMin(String anneeMin){
        this.anneeMin = anneeMin;
    }
    public String getAnneeMax(){
        return this.anneeMax;
    }
    public void setAnneeMax(String anneeMax){
        this.anneeMax = anneeMax;
    }
      
    public String getMois(){
        return this.mois;
    }
    public void setMois(String mois){
        this.mois = mois;
    }   
    public String getMoisMin(){
        return this.moisMin;
    }
    public void setMoisMin(String moisMin){
        this.moisMin = moisMin;
    }
    public String getMoisMax(){
        return this.moisMax;
    }
    public void setMoisMax(String moisMax){
        this.moisMax = moisMax;
    }
      
    public LocalDateTime getDateOperationComptable(){
        return this.dateOperationComptable;
    }
    public void setDateOperationComptable(LocalDateTime dateOperationComptable){
        this.dateOperationComptable = dateOperationComptable;
    }
    public LocalDateTime getDateOperationComptableFrom(){
        return this.dateOperationComptableFrom;
    }
    public void setDateOperationComptableFrom(LocalDateTime dateOperationComptableFrom){
        this.dateOperationComptableFrom = dateOperationComptableFrom;
    }
    public LocalDateTime getDateOperationComptableTo(){
        return this.dateOperationComptableTo;
    }
    public void setDateOperationComptableTo(LocalDateTime dateOperationComptableTo){
        this.dateOperationComptableTo = dateOperationComptableTo;
    }
    public String getMontant(){
        return this.montant;
    }
    public void setMontant(String montant){
        this.montant = montant;
    }   
    public String getMontantMin(){
        return this.montantMin;
    }
    public void setMontantMin(String montantMin){
        this.montantMin = montantMin;
    }
    public String getMontantMax(){
        return this.montantMax;
    }
    public void setMontantMax(String montantMax){
        this.montantMax = montantMax;
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
    public CompteComptableCriteria getCompteComptable(){
        return this.compteComptable;
    }

    public void setCompteComptable(CompteComptableCriteria compteComptable){
        this.compteComptable = compteComptable;
    }
    public List<CompteComptableCriteria> getCompteComptables(){
        return this.compteComptables;
    }

    public void setCompteComptables(List<CompteComptableCriteria> compteComptables){
        this.compteComptables = compteComptables;
    }
    public TypeOperationComptableCriteria getTypeOperationComptable(){
        return this.typeOperationComptable;
    }

    public void setTypeOperationComptable(TypeOperationComptableCriteria typeOperationComptable){
        this.typeOperationComptable = typeOperationComptable;
    }
    public List<TypeOperationComptableCriteria> getTypeOperationComptables(){
        return this.typeOperationComptables;
    }

    public void setTypeOperationComptables(List<TypeOperationComptableCriteria> typeOperationComptables){
        this.typeOperationComptables = typeOperationComptables;
    }
    public EtatOperationComptableCriteria getEtatOperationComptable(){
        return this.etatOperationComptable;
    }

    public void setEtatOperationComptable(EtatOperationComptableCriteria etatOperationComptable){
        this.etatOperationComptable = etatOperationComptable;
    }
    public List<EtatOperationComptableCriteria> getEtatOperationComptables(){
        return this.etatOperationComptables;
    }

    public void setEtatOperationComptables(List<EtatOperationComptableCriteria> etatOperationComptables){
        this.etatOperationComptables = etatOperationComptables;
    }
}

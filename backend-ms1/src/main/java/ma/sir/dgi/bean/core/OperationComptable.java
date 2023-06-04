package ma.sir.dgi.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.dgi.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "operation_comptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="operation_comptable_seq",sequenceName="operation_comptable_seq",allocationSize=1, initialValue = 1)
public class OperationComptable   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    private Integer annee = 0;
    private Integer mois = 0;
    private LocalDateTime dateOperationComptable ;
    private BigDecimal montant = BigDecimal.ZERO;

    private Societe societe ;
    
    private CompteComptable compteComptable ;
    
    private TypeOperationComptable typeOperationComptable ;
    
    private EtatOperationComptable etatOperationComptable ;
    


    public OperationComptable(){
        super();
    }

    public OperationComptable(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="operation_comptable_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }
    public Integer getMois(){
        return this.mois;
    }
    public void setMois(Integer mois){
        this.mois = mois;
    }
    public LocalDateTime getDateOperationComptable(){
        return this.dateOperationComptable;
    }
    public void setDateOperationComptable(LocalDateTime dateOperationComptable){
        this.dateOperationComptable = dateOperationComptable;
    }
    public BigDecimal getMontant(){
        return this.montant;
    }
    public void setMontant(BigDecimal montant){
        this.montant = montant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Societe getSociete(){
        return this.societe;
    }
    public void setSociete(Societe societe){
        this.societe = societe;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public CompteComptable getCompteComptable(){
        return this.compteComptable;
    }
    public void setCompteComptable(CompteComptable compteComptable){
        this.compteComptable = compteComptable;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TypeOperationComptable getTypeOperationComptable(){
        return this.typeOperationComptable;
    }
    public void setTypeOperationComptable(TypeOperationComptable typeOperationComptable){
        this.typeOperationComptable = typeOperationComptable;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public EtatOperationComptable getEtatOperationComptable(){
        return this.etatOperationComptable;
    }
    public void setEtatOperationComptable(EtatOperationComptable etatOperationComptable){
        this.etatOperationComptable = etatOperationComptable;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationComptable operationComptable = (OperationComptable) o;
        return id != null && id.equals(operationComptable.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


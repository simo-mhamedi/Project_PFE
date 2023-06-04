package ma.sir.dgi.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.dgi.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "facture_produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="facture_produit_seq",sequenceName="facture_produit_seq",allocationSize=1, initialValue = 1)
public class FactureProduitHistory extends HistBusinessObject  {


    public FactureProduitHistory() {
    super();
    }

    public FactureProduitHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="facture_produit_seq")
    public Long getId() {
    return id;
    }
}


package ma.sir.dgi.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.dgi.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "facture_charge")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="facture_charge_seq",sequenceName="facture_charge_seq",allocationSize=1, initialValue = 1)
public class FactureChargeHistory extends HistBusinessObject  {


    public FactureChargeHistory() {
    super();
    }

    public FactureChargeHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="facture_charge_seq")
    public Long getId() {
    return id;
    }
}


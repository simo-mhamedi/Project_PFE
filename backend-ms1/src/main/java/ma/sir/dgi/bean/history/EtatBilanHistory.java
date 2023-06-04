package ma.sir.dgi.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.dgi.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "etat_bilan")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="etat_bilan_seq",sequenceName="etat_bilan_seq",allocationSize=1, initialValue = 1)
public class EtatBilanHistory extends HistBusinessObject  {


    public EtatBilanHistory() {
    super();
    }

    public EtatBilanHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="etat_bilan_seq")
    public Long getId() {
    return id;
    }
}


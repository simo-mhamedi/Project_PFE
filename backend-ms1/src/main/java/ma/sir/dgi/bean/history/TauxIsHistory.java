package ma.sir.dgi.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.dgi.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "taux_is")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="taux_is_seq",sequenceName="taux_is_seq",allocationSize=1, initialValue = 1)
public class TauxIsHistory extends HistBusinessObject  {


    public TauxIsHistory() {
    super();
    }

    public TauxIsHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="taux_is_seq")
    public Long getId() {
    return id;
    }
}


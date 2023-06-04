package ma.sir.dgi.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.dgi.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "type_operation_comptable")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_operation_comptable_seq",sequenceName="type_operation_comptable_seq",allocationSize=1, initialValue = 1)
public class TypeOperationComptableHistory extends HistBusinessObject  {


    public TypeOperationComptableHistory() {
    super();
    }

    public TypeOperationComptableHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="type_operation_comptable_seq")
    public Long getId() {
    return id;
    }
}


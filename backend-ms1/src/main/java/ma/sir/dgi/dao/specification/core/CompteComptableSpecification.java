package  ma.sir.dgi.dao.specification.core;

import ma.sir.dgi.zynerator.specification.AbstractSpecification;
import ma.sir.dgi.dao.criteria.core.CompteComptableCriteria;
import ma.sir.dgi.bean.core.CompteComptable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CompteComptableSpecification extends  AbstractSpecification<CompteComptableCriteria, CompteComptable>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateFk("sousClassComptable","id", criteria.getSousClassComptable()==null?null:criteria.getSousClassComptable().getId());
        addPredicateFk("sousClassComptable","id", criteria.getSousClassComptables());
    }

    public CompteComptableSpecification(CompteComptableCriteria criteria) {
        super(criteria);
    }

    public CompteComptableSpecification(CompteComptableCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

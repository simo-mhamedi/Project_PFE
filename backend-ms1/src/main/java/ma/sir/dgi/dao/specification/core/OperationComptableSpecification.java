package  ma.sir.dgi.dao.specification.core;

import ma.sir.dgi.zynerator.specification.AbstractSpecification;
import ma.sir.dgi.dao.criteria.core.OperationComptableCriteria;
import ma.sir.dgi.bean.core.OperationComptable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OperationComptableSpecification extends  AbstractSpecification<OperationComptableCriteria, OperationComptable>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateInt("annee", criteria.getAnnee(), criteria.getAnneeMin(), criteria.getAnneeMax());
        addPredicateInt("mois", criteria.getMois(), criteria.getMoisMin(), criteria.getMoisMax());
        addPredicate("dateOperationComptable", criteria.getDateOperationComptable(), criteria.getDateOperationComptableFrom(), criteria.getDateOperationComptableTo());
        addPredicateBigDecimal("montant", criteria.getMontant(), criteria.getMontantMin(), criteria.getMontantMax());
        addPredicateFk("societe","id", criteria.getSociete()==null?null:criteria.getSociete().getId());
        addPredicateFk("societe","id", criteria.getSocietes());
        addPredicateFk("societe","ice", criteria.getSociete()==null?null:criteria.getSociete().getIce());
        addPredicateFk("compteComptable","id", criteria.getCompteComptable()==null?null:criteria.getCompteComptable().getId());
        addPredicateFk("compteComptable","id", criteria.getCompteComptables());
        addPredicateFk("typeOperationComptable","id", criteria.getTypeOperationComptable()==null?null:criteria.getTypeOperationComptable().getId());
        addPredicateFk("typeOperationComptable","id", criteria.getTypeOperationComptables());
        addPredicateFk("etatOperationComptable","id", criteria.getEtatOperationComptable()==null?null:criteria.getEtatOperationComptable().getId());
        addPredicateFk("etatOperationComptable","id", criteria.getEtatOperationComptables());
    }

    public OperationComptableSpecification(OperationComptableCriteria criteria) {
        super(criteria);
    }

    public OperationComptableSpecification(OperationComptableCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

import {SocieteCriteria} from './SocieteCriteria.model';
import {CompteComptableCriteria} from './CompteComptableCriteria.model';
import {TypeOperationComptableCriteria} from './TypeOperationComptableCriteria.model';
import {EtatOperationComptableCriteria} from './EtatOperationComptableCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class OperationComptableCriteria  extends   BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
     public annee: number;
     public anneeMin: number;
     public anneeMax: number;
     public mois: number;
     public moisMin: number;
     public moisMax: number;
    public dateOperationComptable: Date;
    public dateOperationComptableFrom: Date;
    public dateOperationComptableTo: Date;
     public montant: number;
     public montantMin: number;
     public montantMax: number;
  public societe: SocieteCriteria ;
  public societes: Array<SocieteCriteria> ;
  public compteComptable: CompteComptableCriteria ;
  public compteComptables: Array<CompteComptableCriteria> ;
  public typeOperationComptable: TypeOperationComptableCriteria ;
  public typeOperationComptables: Array<TypeOperationComptableCriteria> ;
  public etatOperationComptable: EtatOperationComptableCriteria ;
  public etatOperationComptables: Array<EtatOperationComptableCriteria> ;

}

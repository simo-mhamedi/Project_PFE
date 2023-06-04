import {SocieteDto} from './Societe.model';
import {CompteComptableDto} from './CompteComptable.model';
import {TypeOperationComptableDto} from './TypeOperationComptable.model';
import {EtatOperationComptableDto} from './EtatOperationComptable.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class OperationComptableDto  extends BaseDto{

    public id: number;
    public libelle: string;
   public annee: number;
   public mois: number;
   public dateOperationComptable: Date;
    public montant: number;
    public anneeMax: string ;
    public anneeMin: string ;
    public moisMax: string ;
    public moisMin: string ;
    public dateOperationComptableMax: string ;
    public dateOperationComptableMin: string ;
    public montantMax: string ;
    public montantMin: string ;
    public societe: SocieteDto ;
    public compteComptable: CompteComptableDto ;
    public typeOperationComptable: TypeOperationComptableDto ;
    public etatOperationComptable: EtatOperationComptableDto ;

}

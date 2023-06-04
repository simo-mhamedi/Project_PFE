import {SocieteDto} from './Societe.model';
import {DeclarationIsDto} from './DeclarationIs.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class FactureProduitDto  extends BaseDto{

    public id: number;
   public dateFacuture: Date;
    public ice: string;
    public montantHt: number;
    public montantTtc: number;
    public montantTva: number;
    public dateFacutureMax: string ;
    public dateFacutureMin: string ;
    public montantHtMax: string ;
    public montantHtMin: string ;
    public montantTtcMax: string ;
    public montantTtcMin: string ;
    public montantTvaMax: string ;
    public montantTvaMin: string ;
    public societe: SocieteDto ;
    public declarationIs: DeclarationIsDto ;

}

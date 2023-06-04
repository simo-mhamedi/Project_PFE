import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {EtatOperationComptableService} from 'src/app/controller/service/EtatOperationComptable.service';
import {EtatOperationComptableDto} from 'src/app/controller/model/EtatOperationComptable.model';
import {EtatOperationComptableCriteria} from 'src/app/controller/criteria/EtatOperationComptableCriteria.model';
@Component({
  selector: 'app-etat-operation-comptable-create-admin',
  templateUrl: './etat-operation-comptable-create-admin.component.html'
})
export class EtatOperationComptableCreateAdminComponent extends AbstractCreateController<EtatOperationComptableDto, EtatOperationComptableCriteria, EtatOperationComptableService>  implements OnInit {



   private _validEtatOperationComptableLibelle = true;
   private _validEtatOperationComptableCode = true;

    constructor( private etatOperationComptableService: EtatOperationComptableService ) {
        super(etatOperationComptableService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validEtatOperationComptableLibelle = value;
        this.validEtatOperationComptableCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatOperationComptableLibelle();
        this.validateEtatOperationComptableCode();
    }

    public validateEtatOperationComptableLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validEtatOperationComptableLibelle = false;
        } else {
            this.validEtatOperationComptableLibelle = true;
        }
    }
    public validateEtatOperationComptableCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validEtatOperationComptableCode = false;
        } else {
            this.validEtatOperationComptableCode = true;
        }
    }






    get validEtatOperationComptableLibelle(): boolean {
        return this._validEtatOperationComptableLibelle;
    }

    set validEtatOperationComptableLibelle(value: boolean) {
         this._validEtatOperationComptableLibelle = value;
    }
    get validEtatOperationComptableCode(): boolean {
        return this._validEtatOperationComptableCode;
    }

    set validEtatOperationComptableCode(value: boolean) {
         this._validEtatOperationComptableCode = value;
    }



}

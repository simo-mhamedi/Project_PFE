import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {TypeOperationComptableService} from 'src/app/controller/service/TypeOperationComptable.service';
import {TypeOperationComptableDto} from 'src/app/controller/model/TypeOperationComptable.model';
import {TypeOperationComptableCriteria} from 'src/app/controller/criteria/TypeOperationComptableCriteria.model';
@Component({
  selector: 'app-type-operation-comptable-create-admin',
  templateUrl: './type-operation-comptable-create-admin.component.html'
})
export class TypeOperationComptableCreateAdminComponent extends AbstractCreateController<TypeOperationComptableDto, TypeOperationComptableCriteria, TypeOperationComptableService>  implements OnInit {



   private _validTypeOperationComptableLibelle = true;
   private _validTypeOperationComptableCode = true;

    constructor( private typeOperationComptableService: TypeOperationComptableService ) {
        super(typeOperationComptableService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
        this.validTypeOperationComptableLibelle = value;
        this.validTypeOperationComptableCode = value;
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateTypeOperationComptableLibelle();
        this.validateTypeOperationComptableCode();
    }

    public validateTypeOperationComptableLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
        this.errorMessages.push('Libelle non valide');
        this.validTypeOperationComptableLibelle = false;
        } else {
            this.validTypeOperationComptableLibelle = true;
        }
    }
    public validateTypeOperationComptableCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
        this.errorMessages.push('Code non valide');
        this.validTypeOperationComptableCode = false;
        } else {
            this.validTypeOperationComptableCode = true;
        }
    }






    get validTypeOperationComptableLibelle(): boolean {
        return this._validTypeOperationComptableLibelle;
    }

    set validTypeOperationComptableLibelle(value: boolean) {
         this._validTypeOperationComptableLibelle = value;
    }
    get validTypeOperationComptableCode(): boolean {
        return this._validTypeOperationComptableCode;
    }

    set validTypeOperationComptableCode(value: boolean) {
         this._validTypeOperationComptableCode = value;
    }



}

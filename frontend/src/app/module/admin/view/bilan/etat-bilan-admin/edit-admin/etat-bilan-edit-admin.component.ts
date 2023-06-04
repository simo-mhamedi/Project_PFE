import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {EtatBilanService} from 'src/app/controller/service/EtatBilan.service';
import {EtatBilanDto} from 'src/app/controller/model/EtatBilan.model';
import {EtatBilanCriteria} from 'src/app/controller/criteria/EtatBilanCriteria.model';



@Component({
  selector: 'app-etat-bilan-edit-admin',
  templateUrl: './etat-bilan-edit-admin.component.html'
})
export class EtatBilanEditAdminComponent extends AbstractEditController<EtatBilanDto, EtatBilanCriteria, EtatBilanService>   implements OnInit {


    private _validEtatBilanLibelle = true;
    private _validEtatBilanCode = true;




    constructor( private etatBilanService: EtatBilanService ) {
        super(etatBilanService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validEtatBilanLibelle = value;
        this.validEtatBilanCode = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateEtatBilanLibelle();
        this.validateEtatBilanCode();
    }
    public validateEtatBilanLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validEtatBilanLibelle = false;
        } else {
            this.validEtatBilanLibelle = true;
        }
    }
    public validateEtatBilanCode(){
        if (this.stringUtilService.isEmpty(this.item.code)) {
            this.errorMessages.push('Code non valide');
            this.validEtatBilanCode = false;
        } else {
            this.validEtatBilanCode = true;
        }
    }






    get validEtatBilanLibelle(): boolean {
        return this._validEtatBilanLibelle;
    }
    set validEtatBilanLibelle(value: boolean) {
        this._validEtatBilanLibelle = value;
    }
    get validEtatBilanCode(): boolean {
        return this._validEtatBilanCode;
    }
    set validEtatBilanCode(value: boolean) {
        this._validEtatBilanCode = value;
    }

}

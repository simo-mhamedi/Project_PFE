import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {SocieteService} from 'src/app/controller/service/Societe.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteCriteria} from 'src/app/controller/criteria/SocieteCriteria.model';



@Component({
  selector: 'app-societe-edit-admin',
  templateUrl: './societe-edit-admin.component.html'
})
export class SocieteEditAdminComponent extends AbstractEditController<SocieteDto, SocieteCriteria, SocieteService>   implements OnInit {


    private _validSocieteIce = true;




    constructor( private societeService: SocieteService ) {
        super(societeService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        this.validSocieteIce = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateSocieteIce();
    }
    public validateSocieteIce(){
        if (this.stringUtilService.isEmpty(this.item.ice)) {
            this.errorMessages.push('Ice non valide');
            this.validSocieteIce = false;
        } else {
            this.validSocieteIce = true;
        }
    }






    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
    }

}

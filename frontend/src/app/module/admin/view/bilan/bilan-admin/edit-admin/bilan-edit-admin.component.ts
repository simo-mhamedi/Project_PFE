import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {BilanService} from 'src/app/controller/service/Bilan.service';
import {BilanDto} from 'src/app/controller/model/Bilan.model';
import {BilanCriteria} from 'src/app/controller/criteria/BilanCriteria.model';


import {EtatBilanDto} from 'src/app/controller/model/EtatBilan.model';
import {EtatBilanService} from 'src/app/controller/service/EtatBilan.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';

@Component({
  selector: 'app-bilan-edit-admin',
  templateUrl: './bilan-edit-admin.component.html'
})
export class BilanEditAdminComponent extends AbstractEditController<BilanDto, BilanCriteria, BilanService>   implements OnInit {


    private _validBilanRef = true;

    private _validSocieteIce = true;
    private _validEtatBilanLibelle = true;
    private _validEtatBilanCode = true;



    constructor( private bilanService: BilanService , private etatBilanService: EtatBilanService, private societeService: SocieteService) {
        super(bilanService);
    }

    ngOnInit(): void {
    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
    this.etatBilan = new EtatBilanDto();
    this.etatBilanService.findAll().subscribe((data) => this.etatBilans = data);
}


    public setValidation(value : boolean){
        this.validBilanRef = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateBilanRef();
    }
    public validateBilanRef(){
        if (this.stringUtilService.isEmpty(this.item.ref)) {
            this.errorMessages.push('Ref non valide');
            this.validBilanRef = false;
        } else {
            this.validBilanRef = true;
        }
    }



   public async openCreateEtatBilan(etatBilan: string) {
        const isPermistted = await this.roleService.isPermitted('EtatBilan', 'edit');
        if(isPermistted) {
             this.etatBilan = new EtatBilanDto();
             this.createEtatBilanDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get societe(): SocieteDto {
       return this.societeService.item;
   }
  set societe(value: SocieteDto) {
        this.societeService.item = value;
   }
   get societes(): Array<SocieteDto> {
        return this.societeService.items;
   }
   set societes(value: Array<SocieteDto>) {
        this.societeService.items = value;
   }
   get createSocieteDialog(): boolean {
       return this.societeService.createDialog;
   }
  set createSocieteDialog(value: boolean) {
       this.societeService.createDialog= value;
   }
   get etatBilan(): EtatBilanDto {
       return this.etatBilanService.item;
   }
  set etatBilan(value: EtatBilanDto) {
        this.etatBilanService.item = value;
   }
   get etatBilans(): Array<EtatBilanDto> {
        return this.etatBilanService.items;
   }
   set etatBilans(value: Array<EtatBilanDto>) {
        this.etatBilanService.items = value;
   }
   get createEtatBilanDialog(): boolean {
       return this.etatBilanService.createDialog;
   }
  set createEtatBilanDialog(value: boolean) {
       this.etatBilanService.createDialog= value;
   }


    get validBilanRef(): boolean {
        return this._validBilanRef;
    }
    set validBilanRef(value: boolean) {
        this._validBilanRef = value;
    }

    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
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

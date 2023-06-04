import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {OperationComptableService} from 'src/app/controller/service/OperationComptable.service';
import {OperationComptableDto} from 'src/app/controller/model/OperationComptable.model';
import {OperationComptableCriteria} from 'src/app/controller/criteria/OperationComptableCriteria.model';


import {EtatOperationComptableDto} from 'src/app/controller/model/EtatOperationComptable.model';
import {EtatOperationComptableService} from 'src/app/controller/service/EtatOperationComptable.service';
import {CompteComptableDto} from 'src/app/controller/model/CompteComptable.model';
import {CompteComptableService} from 'src/app/controller/service/CompteComptable.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
import {TypeOperationComptableDto} from 'src/app/controller/model/TypeOperationComptable.model';
import {TypeOperationComptableService} from 'src/app/controller/service/TypeOperationComptable.service';

@Component({
  selector: 'app-operation-comptable-edit-admin',
  templateUrl: './operation-comptable-edit-admin.component.html'
})
export class OperationComptableEditAdminComponent extends AbstractEditController<OperationComptableDto, OperationComptableCriteria, OperationComptableService>   implements OnInit {


    private _validOperationComptableLibelle = true;

    private _validSocieteIce = true;
    private _validCompteComptableLibelle = true;
    private _validCompteComptableCode = true;
    private _validTypeOperationComptableLibelle = true;
    private _validTypeOperationComptableCode = true;
    private _validEtatOperationComptableLibelle = true;
    private _validEtatOperationComptableCode = true;



    constructor( private operationComptableService: OperationComptableService , private etatOperationComptableService: EtatOperationComptableService, private compteComptableService: CompteComptableService, private societeService: SocieteService, private typeOperationComptableService: TypeOperationComptableService) {
        super(operationComptableService);
    }

    ngOnInit(): void {
    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
    this.compteComptable = new CompteComptableDto();
    this.compteComptableService.findAll().subscribe((data) => this.compteComptables = data);
    this.typeOperationComptable = new TypeOperationComptableDto();
    this.typeOperationComptableService.findAll().subscribe((data) => this.typeOperationComptables = data);
    this.etatOperationComptable = new EtatOperationComptableDto();
    this.etatOperationComptableService.findAll().subscribe((data) => this.etatOperationComptables = data);
}
    public prepareEdit() {
        this.item.dateOperationComptable = this.operationComptableService.format(this.item.dateOperationComptable);
    }



    public setValidation(value : boolean){
        this.validOperationComptableLibelle = value;
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
        this.validateOperationComptableLibelle();
    }
    public validateOperationComptableLibelle(){
        if (this.stringUtilService.isEmpty(this.item.libelle)) {
            this.errorMessages.push('Libelle non valide');
            this.validOperationComptableLibelle = false;
        } else {
            this.validOperationComptableLibelle = true;
        }
    }



   public async openCreateTypeOperationComptable(typeOperationComptable: string) {
        const isPermistted = await this.roleService.isPermitted('TypeOperationComptable', 'edit');
        if(isPermistted) {
             this.typeOperationComptable = new TypeOperationComptableDto();
             this.createTypeOperationComptableDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateCompteComptable(compteComptable: string) {
        const isPermistted = await this.roleService.isPermitted('CompteComptable', 'edit');
        if(isPermistted) {
             this.compteComptable = new CompteComptableDto();
             this.createCompteComptableDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }
   public async openCreateEtatOperationComptable(etatOperationComptable: string) {
        const isPermistted = await this.roleService.isPermitted('EtatOperationComptable', 'edit');
        if(isPermistted) {
             this.etatOperationComptable = new EtatOperationComptableDto();
             this.createEtatOperationComptableDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get typeOperationComptable(): TypeOperationComptableDto {
       return this.typeOperationComptableService.item;
   }
  set typeOperationComptable(value: TypeOperationComptableDto) {
        this.typeOperationComptableService.item = value;
   }
   get typeOperationComptables(): Array<TypeOperationComptableDto> {
        return this.typeOperationComptableService.items;
   }
   set typeOperationComptables(value: Array<TypeOperationComptableDto>) {
        this.typeOperationComptableService.items = value;
   }
   get createTypeOperationComptableDialog(): boolean {
       return this.typeOperationComptableService.createDialog;
   }
  set createTypeOperationComptableDialog(value: boolean) {
       this.typeOperationComptableService.createDialog= value;
   }
   get compteComptable(): CompteComptableDto {
       return this.compteComptableService.item;
   }
  set compteComptable(value: CompteComptableDto) {
        this.compteComptableService.item = value;
   }
   get compteComptables(): Array<CompteComptableDto> {
        return this.compteComptableService.items;
   }
   set compteComptables(value: Array<CompteComptableDto>) {
        this.compteComptableService.items = value;
   }
   get createCompteComptableDialog(): boolean {
       return this.compteComptableService.createDialog;
   }
  set createCompteComptableDialog(value: boolean) {
       this.compteComptableService.createDialog= value;
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
   get etatOperationComptable(): EtatOperationComptableDto {
       return this.etatOperationComptableService.item;
   }
  set etatOperationComptable(value: EtatOperationComptableDto) {
        this.etatOperationComptableService.item = value;
   }
   get etatOperationComptables(): Array<EtatOperationComptableDto> {
        return this.etatOperationComptableService.items;
   }
   set etatOperationComptables(value: Array<EtatOperationComptableDto>) {
        this.etatOperationComptableService.items = value;
   }
   get createEtatOperationComptableDialog(): boolean {
       return this.etatOperationComptableService.createDialog;
   }
  set createEtatOperationComptableDialog(value: boolean) {
       this.etatOperationComptableService.createDialog= value;
   }


    get validOperationComptableLibelle(): boolean {
        return this._validOperationComptableLibelle;
    }
    set validOperationComptableLibelle(value: boolean) {
        this._validOperationComptableLibelle = value;
    }

    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
    }
    get validCompteComptableLibelle(): boolean {
        return this._validCompteComptableLibelle;
    }
    set validCompteComptableLibelle(value: boolean) {
        this._validCompteComptableLibelle = value;
    }
    get validCompteComptableCode(): boolean {
        return this._validCompteComptableCode;
    }
    set validCompteComptableCode(value: boolean) {
        this._validCompteComptableCode = value;
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

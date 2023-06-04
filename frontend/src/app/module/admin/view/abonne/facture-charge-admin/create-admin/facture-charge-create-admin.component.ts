import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {FactureChargeService} from 'src/app/controller/service/FactureCharge.service';
import {FactureChargeDto} from 'src/app/controller/model/FactureCharge.model';
import {FactureChargeCriteria} from 'src/app/controller/criteria/FactureChargeCriteria.model';
import {DeclarationIsDto} from 'src/app/controller/model/DeclarationIs.model';
import {DeclarationIsService} from 'src/app/controller/service/DeclarationIs.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
@Component({
  selector: 'app-facture-charge-create-admin',
  templateUrl: './facture-charge-create-admin.component.html'
})
export class FactureChargeCreateAdminComponent extends AbstractCreateController<FactureChargeDto, FactureChargeCriteria, FactureChargeService>  implements OnInit {



    private _validSocieteIce = true;

    constructor( private factureChargeService: FactureChargeService , private declarationIsService: DeclarationIsService, private societeService: SocieteService) {
        super(factureChargeService);
    }

    ngOnInit(): void {
    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
    this.declarationIs = new DeclarationIsDto();
    this.declarationIsService.findAll().subscribe((data) => this.declarationIss = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateSociete(societe: string) {
    const isPermistted = await this.roleService.isPermitted('Societe', 'add');
    if(isPermistted) {
         this.societe = new SocieteDto();
         this.createSocieteDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get declarationIs(): DeclarationIsDto {
        return this.declarationIsService.item;
    }
    set declarationIs(value: DeclarationIsDto) {
        this.declarationIsService.item = value;
    }
    get declarationIss(): Array<DeclarationIsDto> {
        return this.declarationIsService.items;
    }
    set declarationIss(value: Array<DeclarationIsDto>) {
        this.declarationIsService.items = value;
    }
    get createDeclarationIsDialog(): boolean {
       return this.declarationIsService.createDialog;
    }
    set createDeclarationIsDialog(value: boolean) {
        this.declarationIsService.createDialog= value;
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




    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
    }


}

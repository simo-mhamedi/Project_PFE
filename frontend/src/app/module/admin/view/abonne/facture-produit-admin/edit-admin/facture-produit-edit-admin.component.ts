import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {FactureProduitService} from 'src/app/controller/service/FactureProduit.service';
import {FactureProduitDto} from 'src/app/controller/model/FactureProduit.model';
import {FactureProduitCriteria} from 'src/app/controller/criteria/FactureProduitCriteria.model';


import {DeclarationIsDto} from 'src/app/controller/model/DeclarationIs.model';
import {DeclarationIsService} from 'src/app/controller/service/DeclarationIs.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';

@Component({
  selector: 'app-facture-produit-edit-admin',
  templateUrl: './facture-produit-edit-admin.component.html'
})
export class FactureProduitEditAdminComponent extends AbstractEditController<FactureProduitDto, FactureProduitCriteria, FactureProduitService>   implements OnInit {



    private _validSocieteIce = true;



    constructor( private factureProduitService: FactureProduitService , private declarationIsService: DeclarationIsService, private societeService: SocieteService) {
        super(factureProduitService);
    }

    ngOnInit(): void {
    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
    this.declarationIs = new DeclarationIsDto();
    this.declarationIsService.findAll().subscribe((data) => this.declarationIss = data);
}
    public prepareEdit() {
        this.item.dateFacuture = this.factureProduitService.format(this.item.dateFacuture);
    }



    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateSociete(societe: string) {
        const isPermistted = await this.roleService.isPermitted('Societe', 'edit');
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

import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {DeclarationIsService} from 'src/app/controller/service/DeclarationIs.service';
import {DeclarationIsDto} from 'src/app/controller/model/DeclarationIs.model';
import {DeclarationIsCriteria} from 'src/app/controller/criteria/DeclarationIsCriteria.model';


import {FactureProduitDto} from 'src/app/controller/model/FactureProduit.model';
import {FactureProduitService} from 'src/app/controller/service/FactureProduit.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
import {TauxIsDto} from 'src/app/controller/model/TauxIs.model';
import {TauxIsService} from 'src/app/controller/service/TauxIs.service';
import {FactureChargeDto} from 'src/app/controller/model/FactureCharge.model';
import {FactureChargeService} from 'src/app/controller/service/FactureCharge.service';

@Component({
  selector: 'app-declaration-is-edit-admin',
  templateUrl: './declaration-is-edit-admin.component.html'
})
export class DeclarationIsEditAdminComponent extends AbstractEditController<DeclarationIsDto, DeclarationIsCriteria, DeclarationIsService>   implements OnInit {

    private _factureChargesElement = new FactureChargeDto();
    private _factureProduitsElement = new FactureProduitDto();


    private _validSocieteIce = true;



    constructor( private declarationIsService: DeclarationIsService , private factureChargeService: FactureChargeService, private factureProduitService: FactureProduitService, private societeService: SocieteService, private tauxIsService: TauxIsService) {
        super(declarationIsService);
    }

    ngOnInit(): void {
        this.factureChargesElement.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);

        this.factureProduitsElement.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);

    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
    this.tauxIs = new TauxIsDto();
    this.tauxIsService.findAll().subscribe((data) => this.tauxIss = data);
}
    public prepareEdit() {
        this.item.dateDeclaration = this.declarationIsService.format(this.item.dateDeclaration);
    }

    calculate() {    
        this.service.calculate(this.item).subscribe((s) => {
          this.item.montantImpot=s.montantImpot;
          this.item.resultatApresImpot=s.resultatApresImpot;
          this.item.resultatAvantImpot=s.resultatAvantImpot;
          this.item.totalCharge=s.totalCharge;
          this.item.totalProduit=s.totalProduit;
          this.item.tauxIs=s.tauxIs;      
        });
      }
    

    public validateFactureCharges(){
        this.errorMessages = new Array();
    }
    public validateFactureProduits(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        }
   public addFactureCharges() {
        if( this.item.factureCharges == null )
            this.item.factureCharges = new Array<FactureChargeDto>();
       this.validateFactureCharges();
       if (this.errorMessages.length === 0) {
            if(this.factureChargesElement.id == null){
                this.item.factureCharges.push(this.factureChargesElement);
            }else{
                const index = this.item.factureCharges.findIndex(e => e.id == this.factureChargesElement.id);
                this.item.factureCharges[index] = this.factureChargesElement;
            }
          this.factureChargesElement = new FactureChargeDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteFactureCharge(p: FactureChargeDto) {
        this.item.factureCharges.forEach((element, index) => {
            if (element === p) { this.item.factureCharges.splice(index, 1); }
        });
    }

    public editFactureCharge(p: FactureChargeDto) {
        this.factureChargesElement = {... p};
        this.activeTab = 0;
    }
   public addFactureProduits() {
        if( this.item.factureProduits == null )
            this.item.factureProduits = new Array<FactureProduitDto>();
       this.validateFactureProduits();
       if (this.errorMessages.length === 0) {
            if(this.factureProduitsElement.id == null){
                this.item.factureProduits.push(this.factureProduitsElement);
            }else{
                const index = this.item.factureProduits.findIndex(e => e.id == this.factureProduitsElement.id);
                this.item.factureProduits[index] = this.factureProduitsElement;
            }
          this.factureProduitsElement = new FactureProduitDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteFactureProduit(p: FactureProduitDto) {
        this.item.factureProduits.forEach((element, index) => {
            if (element === p) { this.item.factureProduits.splice(index, 1); }
        });
    }

    public editFactureProduit(p: FactureProduitDto) {
        this.factureProduitsElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateTauxIs(tauxIs: string) {
        const isPermistted = await this.roleService.isPermitted('TauxIs', 'edit');
        if(isPermistted) {
             this.tauxIs = new TauxIsDto();
             this.createTauxIsDialog = true;
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
   get tauxIs(): TauxIsDto {
       return this.tauxIsService.item;
   }
  set tauxIs(value: TauxIsDto) {
        this.tauxIsService.item = value;
   }
   get tauxIss(): Array<TauxIsDto> {
        return this.tauxIsService.items;
   }
   set tauxIss(value: Array<TauxIsDto>) {
        this.tauxIsService.items = value;
   }
   get createTauxIsDialog(): boolean {
       return this.tauxIsService.createDialog;
   }
  set createTauxIsDialog(value: boolean) {
       this.tauxIsService.createDialog= value;
   }

    get factureChargesElement(): FactureChargeDto {
        if( this._factureChargesElement == null )
            this._factureChargesElement = new FactureChargeDto();
         return this._factureChargesElement;
    }

    set factureChargesElement(value: FactureChargeDto) {
        this._factureChargesElement = value;
    }
    get factureProduitsElement(): FactureProduitDto {
        if( this._factureProduitsElement == null )
            this._factureProduitsElement = new FactureProduitDto();
         return this._factureProduitsElement;
    }

    set factureProduitsElement(value: FactureProduitDto) {
        this._factureProduitsElement = value;
    }


    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
    }
}

import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-declaration-is-view-admin',
  templateUrl: './declaration-is-view-admin.component.html'
})
export class DeclarationIsViewAdminComponent extends AbstractViewController<DeclarationIsDto, DeclarationIsCriteria, DeclarationIsService> implements OnInit {

    factureCharges = new FactureChargeDto();
    factureChargess: Array<FactureChargeDto> = [];
    factureProduits = new FactureProduitDto();
    factureProduitss: Array<FactureProduitDto> = [];

    constructor(private declarationIsService: DeclarationIsService, private factureChargeService: FactureChargeService, private factureProduitService: FactureProduitService, private societeService: SocieteService, private tauxIsService: TauxIsService){
        super(declarationIsService);
    }

    ngOnInit(): void {
        this.factureCharges.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);
        this.factureProduits.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);
        this.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);
        this.tauxIs = new TauxIsDto();
        this.tauxIsService.findAll().subscribe((data) => this.tauxIss = data);
    }


    get societe(): SocieteDto {
       return this.societeService.item;
    }
    set societe(value: SocieteDto) {
        this.societeService.item = value;
    }
    get societes():Array<SocieteDto> {
       return this.societeService.items;
    }
    set societes(value: Array<SocieteDto>) {
        this.societeService.items = value;
    }
    get tauxIs(): TauxIsDto {
       return this.tauxIsService.item;
    }
    set tauxIs(value: TauxIsDto) {
        this.tauxIsService.item = value;
    }
    get tauxIss():Array<TauxIsDto> {
       return this.tauxIsService.items;
    }
    set tauxIss(value: Array<TauxIsDto>) {
        this.tauxIsService.items = value;
    }


}

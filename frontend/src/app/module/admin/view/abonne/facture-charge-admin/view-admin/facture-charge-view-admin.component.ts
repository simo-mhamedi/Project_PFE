import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {FactureChargeService} from 'src/app/controller/service/FactureCharge.service';
import {FactureChargeDto} from 'src/app/controller/model/FactureCharge.model';
import {FactureChargeCriteria} from 'src/app/controller/criteria/FactureChargeCriteria.model';

import {DeclarationIsDto} from 'src/app/controller/model/DeclarationIs.model';
import {DeclarationIsService} from 'src/app/controller/service/DeclarationIs.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
@Component({
  selector: 'app-facture-charge-view-admin',
  templateUrl: './facture-charge-view-admin.component.html'
})
export class FactureChargeViewAdminComponent extends AbstractViewController<FactureChargeDto, FactureChargeCriteria, FactureChargeService> implements OnInit {


    constructor(private factureChargeService: FactureChargeService, private declarationIsService: DeclarationIsService, private societeService: SocieteService){
        super(factureChargeService);
    }

    ngOnInit(): void {
        this.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);
        this.declarationIs = new DeclarationIsDto();
        this.declarationIsService.findAll().subscribe((data) => this.declarationIss = data);
    }


    get declarationIs(): DeclarationIsDto {
       return this.declarationIsService.item;
    }
    set declarationIs(value: DeclarationIsDto) {
        this.declarationIsService.item = value;
    }
    get declarationIss():Array<DeclarationIsDto> {
       return this.declarationIsService.items;
    }
    set declarationIss(value: Array<DeclarationIsDto>) {
        this.declarationIsService.items = value;
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


}

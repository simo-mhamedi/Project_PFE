import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

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
  selector: 'app-operation-comptable-view-admin',
  templateUrl: './operation-comptable-view-admin.component.html'
})
export class OperationComptableViewAdminComponent extends AbstractViewController<OperationComptableDto, OperationComptableCriteria, OperationComptableService> implements OnInit {


    constructor(private operationComptableService: OperationComptableService, private etatOperationComptableService: EtatOperationComptableService, private compteComptableService: CompteComptableService, private societeService: SocieteService, private typeOperationComptableService: TypeOperationComptableService){
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


    get typeOperationComptable(): TypeOperationComptableDto {
       return this.typeOperationComptableService.item;
    }
    set typeOperationComptable(value: TypeOperationComptableDto) {
        this.typeOperationComptableService.item = value;
    }
    get typeOperationComptables():Array<TypeOperationComptableDto> {
       return this.typeOperationComptableService.items;
    }
    set typeOperationComptables(value: Array<TypeOperationComptableDto>) {
        this.typeOperationComptableService.items = value;
    }
    get compteComptable(): CompteComptableDto {
       return this.compteComptableService.item;
    }
    set compteComptable(value: CompteComptableDto) {
        this.compteComptableService.item = value;
    }
    get compteComptables():Array<CompteComptableDto> {
       return this.compteComptableService.items;
    }
    set compteComptables(value: Array<CompteComptableDto>) {
        this.compteComptableService.items = value;
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
    get etatOperationComptable(): EtatOperationComptableDto {
       return this.etatOperationComptableService.item;
    }
    set etatOperationComptable(value: EtatOperationComptableDto) {
        this.etatOperationComptableService.item = value;
    }
    get etatOperationComptables():Array<EtatOperationComptableDto> {
       return this.etatOperationComptableService.items;
    }
    set etatOperationComptables(value: Array<EtatOperationComptableDto>) {
        this.etatOperationComptableService.items = value;
    }


}

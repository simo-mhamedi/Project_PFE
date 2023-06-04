import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DeclarationTvaService} from 'src/app/controller/service/DeclarationTva.service';
import {DeclarationTvaDto} from 'src/app/controller/model/DeclarationTva.model';
import {DeclarationTvaCriteria} from 'src/app/controller/criteria/DeclarationTvaCriteria.model';

import {TauxRetardTvaDto} from 'src/app/controller/model/TauxRetardTva.model';
import {TauxRetardTvaService} from 'src/app/controller/service/TauxRetardTva.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
@Component({
  selector: 'app-declaration-tva-view-admin',
  templateUrl: './declaration-tva-view-admin.component.html'
})
export class DeclarationTvaViewAdminComponent extends AbstractViewController<DeclarationTvaDto, DeclarationTvaCriteria, DeclarationTvaService> implements OnInit {


    constructor(private declarationTvaService: DeclarationTvaService, private tauxRetardTvaService: TauxRetardTvaService, private societeService: SocieteService){
        super(declarationTvaService);
    }

    ngOnInit(): void {
        this.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);
        this.tauxRetardTva = new TauxRetardTvaDto();
        this.tauxRetardTvaService.findAll().subscribe((data) => this.tauxRetardTvas = data);
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
    get tauxRetardTva(): TauxRetardTvaDto {
       return this.tauxRetardTvaService.item;
    }
    set tauxRetardTva(value: TauxRetardTvaDto) {
        this.tauxRetardTvaService.item = value;
    }
    get tauxRetardTvas():Array<TauxRetardTvaDto> {
       return this.tauxRetardTvaService.items;
    }
    set tauxRetardTvas(value: Array<TauxRetardTvaDto>) {
        this.tauxRetardTvaService.items = value;
    }


}

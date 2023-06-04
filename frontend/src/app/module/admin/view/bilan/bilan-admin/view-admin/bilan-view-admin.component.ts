import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BilanService} from 'src/app/controller/service/Bilan.service';
import {BilanDto} from 'src/app/controller/model/Bilan.model';
import {BilanCriteria} from 'src/app/controller/criteria/BilanCriteria.model';

import {EtatBilanDto} from 'src/app/controller/model/EtatBilan.model';
import {EtatBilanService} from 'src/app/controller/service/EtatBilan.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
@Component({
  selector: 'app-bilan-view-admin',
  templateUrl: './bilan-view-admin.component.html'
})
export class BilanViewAdminComponent extends AbstractViewController<BilanDto, BilanCriteria, BilanService> implements OnInit {


    constructor(private bilanService: BilanService, private etatBilanService: EtatBilanService, private societeService: SocieteService){
        super(bilanService);
    }

    ngOnInit(): void {
        this.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);
        this.etatBilan = new EtatBilanDto();
        this.etatBilanService.findAll().subscribe((data) => this.etatBilans = data);
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
    get etatBilan(): EtatBilanDto {
       return this.etatBilanService.item;
    }
    set etatBilan(value: EtatBilanDto) {
        this.etatBilanService.item = value;
    }
    get etatBilans():Array<EtatBilanDto> {
       return this.etatBilanService.items;
    }
    set etatBilans(value: Array<EtatBilanDto>) {
        this.etatBilanService.items = value;
    }


}

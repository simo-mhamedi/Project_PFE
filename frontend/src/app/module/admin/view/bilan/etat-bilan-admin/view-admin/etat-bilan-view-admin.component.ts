import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatBilanService} from 'src/app/controller/service/EtatBilan.service';
import {EtatBilanDto} from 'src/app/controller/model/EtatBilan.model';
import {EtatBilanCriteria} from 'src/app/controller/criteria/EtatBilanCriteria.model';

@Component({
  selector: 'app-etat-bilan-view-admin',
  templateUrl: './etat-bilan-view-admin.component.html'
})
export class EtatBilanViewAdminComponent extends AbstractViewController<EtatBilanDto, EtatBilanCriteria, EtatBilanService> implements OnInit {


    constructor(private etatBilanService: EtatBilanService){
        super(etatBilanService);
    }

    ngOnInit(): void {
    }




}

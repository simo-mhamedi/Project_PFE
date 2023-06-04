import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {EtatOperationComptableService} from 'src/app/controller/service/EtatOperationComptable.service';
import {EtatOperationComptableDto} from 'src/app/controller/model/EtatOperationComptable.model';
import {EtatOperationComptableCriteria} from 'src/app/controller/criteria/EtatOperationComptableCriteria.model';

@Component({
  selector: 'app-etat-operation-comptable-view-admin',
  templateUrl: './etat-operation-comptable-view-admin.component.html'
})
export class EtatOperationComptableViewAdminComponent extends AbstractViewController<EtatOperationComptableDto, EtatOperationComptableCriteria, EtatOperationComptableService> implements OnInit {


    constructor(private etatOperationComptableService: EtatOperationComptableService){
        super(etatOperationComptableService);
    }

    ngOnInit(): void {
    }




}

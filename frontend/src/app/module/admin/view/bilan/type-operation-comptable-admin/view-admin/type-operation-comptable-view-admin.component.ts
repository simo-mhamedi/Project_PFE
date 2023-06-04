import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {TypeOperationComptableService} from 'src/app/controller/service/TypeOperationComptable.service';
import {TypeOperationComptableDto} from 'src/app/controller/model/TypeOperationComptable.model';
import {TypeOperationComptableCriteria} from 'src/app/controller/criteria/TypeOperationComptableCriteria.model';

@Component({
  selector: 'app-type-operation-comptable-view-admin',
  templateUrl: './type-operation-comptable-view-admin.component.html'
})
export class TypeOperationComptableViewAdminComponent extends AbstractViewController<TypeOperationComptableDto, TypeOperationComptableCriteria, TypeOperationComptableService> implements OnInit {


    constructor(private typeOperationComptableService: TypeOperationComptableService){
        super(typeOperationComptableService);
    }

    ngOnInit(): void {
    }




}

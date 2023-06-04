import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {TypeOperationComptableDto} from '../model/TypeOperationComptable.model';
import {TypeOperationComptableCriteria} from '../criteria/TypeOperationComptableCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TypeOperationComptableService extends AbstractService<TypeOperationComptableDto, TypeOperationComptableCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/typeOperationComptable/');
    }

    public constrcutDto(): TypeOperationComptableDto {
        return new TypeOperationComptableDto();
    }

    public constrcutCriteria(): TypeOperationComptableCriteria {
        return new TypeOperationComptableCriteria();
    }
}

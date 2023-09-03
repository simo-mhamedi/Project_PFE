import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DeclarationIsDto} from '../model/DeclarationIs.model';
import {DeclarationIsCriteria} from '../criteria/DeclarationIsCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SocieteDto} from '../model/Societe.model';
import {FactureChargeDto} from '../model/FactureCharge.model';
import {FactureProduitDto} from '../model/FactureProduit.model';
import {TauxIsDto} from '../model/TauxIs.model';

@Injectable({
  providedIn: 'root'
})
export class DeclarationIsService extends AbstractService<DeclarationIsDto, DeclarationIsCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/declarationIs/');
    }
    private baseUrl="http://localhost:8036/api/admin/";

    public constrcutDto(): DeclarationIsDto {
        return new DeclarationIsDto();
    }

    public constrcutCriteria(): DeclarationIsCriteria {
        return new DeclarationIsCriteria();
    }

    calculate(declarationIsDto: DeclarationIsDto) {
        // Send the declarationIsDto object in the request body
        return this.http.post<any>(this.baseUrl + 'declarationIs/calculate/', declarationIsDto);
    }
}

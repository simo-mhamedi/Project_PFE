import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {FactureProduitDto} from '../model/FactureProduit.model';
import {FactureProduitCriteria} from '../criteria/FactureProduitCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SocieteDto} from '../model/Societe.model';
import {DeclarationIsDto} from '../model/DeclarationIs.model';

@Injectable({
  providedIn: 'root'
})
export class FactureProduitService extends AbstractService<FactureProduitDto, FactureProduitCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/factureProduit/');
    }

    public constrcutDto(): FactureProduitDto {
        return new FactureProduitDto();
    }

    public constrcutCriteria(): FactureProduitCriteria {
        return new FactureProduitCriteria();
    }
}

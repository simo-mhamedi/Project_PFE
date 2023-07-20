import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import * as moment from 'moment';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';
import {PaginatedList} from 'src/app/zynerator/dto/PaginatedList.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {DeclarationTvaDto} from '../model/DeclarationTva.model';
import {DeclarationTvaCriteria} from '../criteria/DeclarationTvaCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';

import {SocieteDto} from '../model/Societe.model';
import {TauxRetardTvaDto} from '../model/TauxRetardTva.model';

@Injectable({
  providedIn: 'root'
})
export class DeclarationTvaService extends AbstractService<DeclarationTvaDto, DeclarationTvaCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/declarationTva/');
    }
    private baseUrl="http://localhost:8036/api/";
    private _declarationTvaDto:DeclarationTvaDto;
    private _declarationTvaDtos: Array<DeclarationTvaDto>
    public constrcutDto(): DeclarationTvaDto {
        return new DeclarationTvaDto();
    }

    public constrcutCriteria(): DeclarationTvaCriteria {
        return new DeclarationTvaCriteria();
    }

    public declarationTva(declarationTvaDto:DeclarationTvaDto)
    {
        return this.http.post<number>(this.baseUrl+"tva/",declarationTvaDto);
    }

    get declarationTvaDto(): DeclarationTvaDto {
        if (this._declarationTvaDto == null) {
          this._declarationTvaDto = new DeclarationTvaDto();
        }
        return this._declarationTvaDto;
      }
    
      set declarationTvaDto(value: DeclarationTvaDto) {
        this._declarationTvaDto = value;
      }
      get declarationTvaDtos(): Array<DeclarationTvaDto> {
        if (this._declarationTvaDtos == null) {
          this._declarationTvaDtos = new Array<DeclarationTvaDto>();
        }
        return this._declarationTvaDtos;
      }
    
      set declarationTvaDtos(value: Array<DeclarationTvaDto>) {
        this._declarationTvaDtos = value;
      }

    
}

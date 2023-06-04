import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SocieteService} from 'src/app/controller/service/Societe.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteCriteria} from 'src/app/controller/criteria/SocieteCriteria.model';

@Component({
  selector: 'app-societe-view-admin',
  templateUrl: './societe-view-admin.component.html'
})
export class SocieteViewAdminComponent extends AbstractViewController<SocieteDto, SocieteCriteria, SocieteService> implements OnInit {


    constructor(private societeService: SocieteService){
        super(societeService);
    }

    ngOnInit(): void {
    }




}

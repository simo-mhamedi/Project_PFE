import {Component, OnInit} from '@angular/core';
import {OperationComptableService} from 'src/app/controller/service/OperationComptable.service';
import {OperationComptableDto} from 'src/app/controller/model/OperationComptable.model';
import {OperationComptableCriteria} from 'src/app/controller/criteria/OperationComptableCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SocieteService } from 'src/app/controller/service/Societe.service';
import { CompteComptableService } from 'src/app/controller/service/CompteComptable.service';
import { TypeOperationComptableService } from 'src/app/controller/service/TypeOperationComptable.service';
import { EtatOperationComptableService } from 'src/app/controller/service/EtatOperationComptable.service';

import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {CompteComptableDto} from 'src/app/controller/model/CompteComptable.model';
import {TypeOperationComptableDto} from 'src/app/controller/model/TypeOperationComptable.model';
import {EtatOperationComptableDto} from 'src/app/controller/model/EtatOperationComptable.model';


@Component({
  selector: 'app-operation-comptable-list-admin',
  templateUrl: './operation-comptable-list-admin.component.html'
})
export class OperationComptableListAdminComponent extends AbstractListController<OperationComptableDto, OperationComptableCriteria, OperationComptableService>  implements OnInit {

    fileName = 'OperationComptable';

    societes :Array<SocieteDto>;
    compteComptables :Array<CompteComptableDto>;
    typeOperationComptables :Array<TypeOperationComptableDto>;
    etatOperationComptables :Array<EtatOperationComptableDto>;
  
    constructor(operationComptableService: OperationComptableService, private societeService: SocieteService, private compteComptableService: CompteComptableService, private typeOperationComptableService: TypeOperationComptableService, private etatOperationComptableService: EtatOperationComptableService) {
        super(operationComptableService);
        this.pdfName='OperationComptable.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSociete();
      this.loadCompteComptable();
      this.loadTypeOperationComptable();
      this.loadEtatOperationComptable();
    }

    public async loadOperationComptables(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OperationComptable', 'list');
        isPermistted ? this.service.findAll().subscribe(operationComptables => this.items = operationComptables,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'annee', header: 'Annee'},
            {field: 'mois', header: 'Mois'},
            {field: 'dateOperationComptable', header: 'Date operation comptable'},
            {field: 'montant', header: 'Montant'},
            {field: 'societe?.ice', header: 'Societe'},
            {field: 'compteComptable?.libelle', header: 'Compte comptable'},
            {field: 'typeOperationComptable?.libelle', header: 'Type operation comptable'},
            {field: 'etatOperationComptable?.libelle', header: 'Etat operation comptable'},
        ];
    }


    public async loadSociete(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OperationComptable', 'list');
        isPermistted ? this.societeService.findAllOptimized().subscribe(societes => this.societes = societes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadCompteComptable(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OperationComptable', 'list');
        isPermistted ? this.compteComptableService.findAllOptimized().subscribe(compteComptables => this.compteComptables = compteComptables,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadTypeOperationComptable(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OperationComptable', 'list');
        isPermistted ? this.typeOperationComptableService.findAllOptimized().subscribe(typeOperationComptables => this.typeOperationComptables = typeOperationComptables,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadEtatOperationComptable(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OperationComptable', 'list');
        isPermistted ? this.etatOperationComptableService.findAllOptimized().subscribe(etatOperationComptables => this.etatOperationComptables = etatOperationComptables,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: OperationComptableDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Annee': e.annee ,
                 'Mois': e.mois ,
                'Date operation comptable': this.datePipe.transform(e.dateOperationComptable , 'dd/MM/yyyy hh:mm'),
                 'Montant': e.montant ,
                'Societe': e.societe?.ice ,
                'Compte comptable': e.compteComptable?.libelle ,
                'Type operation comptable': e.typeOperationComptable?.libelle ,
                'Etat operation comptable': e.etatOperationComptable?.libelle ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Annee Min': this.criteria.anneeMin ? this.criteria.anneeMin : environment.emptyForExport ,
            'Annee Max': this.criteria.anneeMax ? this.criteria.anneeMax : environment.emptyForExport ,
            'Mois Min': this.criteria.moisMin ? this.criteria.moisMin : environment.emptyForExport ,
            'Mois Max': this.criteria.moisMax ? this.criteria.moisMax : environment.emptyForExport ,
            'Date operation comptable Min': this.criteria.dateOperationComptableFrom ? this.datePipe.transform(this.criteria.dateOperationComptableFrom , this.dateFormat) : environment.emptyForExport ,
            'Date operation comptable Max': this.criteria.dateOperationComptableTo ? this.datePipe.transform(this.criteria.dateOperationComptableTo , this.dateFormat) : environment.emptyForExport ,
            'Montant Min': this.criteria.montantMin ? this.criteria.montantMin : environment.emptyForExport ,
            'Montant Max': this.criteria.montantMax ? this.criteria.montantMax : environment.emptyForExport ,
        //'Societe': this.criteria.societe?.ice ? this.criteria.societe?.ice : environment.emptyForExport ,
        //'Compte comptable': this.criteria.compteComptable?.libelle ? this.criteria.compteComptable?.libelle : environment.emptyForExport ,
        //'Type operation comptable': this.criteria.typeOperationComptable?.libelle ? this.criteria.typeOperationComptable?.libelle : environment.emptyForExport ,
        //'Etat operation comptable': this.criteria.etatOperationComptable?.libelle ? this.criteria.etatOperationComptable?.libelle : environment.emptyForExport ,
        }];
      }
}

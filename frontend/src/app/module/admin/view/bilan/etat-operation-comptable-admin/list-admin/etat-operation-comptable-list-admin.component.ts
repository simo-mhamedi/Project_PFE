import {Component, OnInit} from '@angular/core';
import {EtatOperationComptableService} from 'src/app/controller/service/EtatOperationComptable.service';
import {EtatOperationComptableDto} from 'src/app/controller/model/EtatOperationComptable.model';
import {EtatOperationComptableCriteria} from 'src/app/controller/criteria/EtatOperationComptableCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-operation-comptable-list-admin',
  templateUrl: './etat-operation-comptable-list-admin.component.html'
})
export class EtatOperationComptableListAdminComponent extends AbstractListController<EtatOperationComptableDto, EtatOperationComptableCriteria, EtatOperationComptableService>  implements OnInit {

    fileName = 'EtatOperationComptable';

  
    constructor(etatOperationComptableService: EtatOperationComptableService) {
        super(etatOperationComptableService);
        this.pdfName='EtatOperationComptable.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatOperationComptables(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatOperationComptable', 'list');
        isPermistted ? this.service.findAll().subscribe(etatOperationComptables => this.items = etatOperationComptables,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: EtatOperationComptableDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}

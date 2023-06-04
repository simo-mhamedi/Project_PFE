import {Component, OnInit} from '@angular/core';
import {TypeOperationComptableService} from 'src/app/controller/service/TypeOperationComptable.service';
import {TypeOperationComptableDto} from 'src/app/controller/model/TypeOperationComptable.model';
import {TypeOperationComptableCriteria} from 'src/app/controller/criteria/TypeOperationComptableCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-type-operation-comptable-list-admin',
  templateUrl: './type-operation-comptable-list-admin.component.html'
})
export class TypeOperationComptableListAdminComponent extends AbstractListController<TypeOperationComptableDto, TypeOperationComptableCriteria, TypeOperationComptableService>  implements OnInit {

    fileName = 'TypeOperationComptable';

  
    constructor(typeOperationComptableService: TypeOperationComptableService) {
        super(typeOperationComptableService);
        this.pdfName='TypeOperationComptable.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadTypeOperationComptables(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('TypeOperationComptable', 'list');
        isPermistted ? this.service.findAll().subscribe(typeOperationComptables => this.items = typeOperationComptables,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: TypeOperationComptableDto) {
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

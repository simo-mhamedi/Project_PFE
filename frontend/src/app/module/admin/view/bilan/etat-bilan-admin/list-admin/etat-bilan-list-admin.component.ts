import {Component, OnInit} from '@angular/core';
import {EtatBilanService} from 'src/app/controller/service/EtatBilan.service';
import {EtatBilanDto} from 'src/app/controller/model/EtatBilan.model';
import {EtatBilanCriteria} from 'src/app/controller/criteria/EtatBilanCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-etat-bilan-list-admin',
  templateUrl: './etat-bilan-list-admin.component.html'
})
export class EtatBilanListAdminComponent extends AbstractListController<EtatBilanDto, EtatBilanCriteria, EtatBilanService>  implements OnInit {

    fileName = 'EtatBilan';

  
    constructor(etatBilanService: EtatBilanService) {
        super(etatBilanService);
        this.pdfName='EtatBilan.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadEtatBilans(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('EtatBilan', 'list');
        isPermistted ? this.service.findAll().subscribe(etatBilans => this.items = etatBilans,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: EtatBilanDto) {
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

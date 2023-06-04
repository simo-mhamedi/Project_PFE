import {Component, OnInit} from '@angular/core';
import {FactureChargeService} from 'src/app/controller/service/FactureCharge.service';
import {FactureChargeDto} from 'src/app/controller/model/FactureCharge.model';
import {FactureChargeCriteria} from 'src/app/controller/criteria/FactureChargeCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SocieteService } from 'src/app/controller/service/Societe.service';
import { DeclarationIsService } from 'src/app/controller/service/DeclarationIs.service';

import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {DeclarationIsDto} from 'src/app/controller/model/DeclarationIs.model';


@Component({
  selector: 'app-facture-charge-list-admin',
  templateUrl: './facture-charge-list-admin.component.html'
})
export class FactureChargeListAdminComponent extends AbstractListController<FactureChargeDto, FactureChargeCriteria, FactureChargeService>  implements OnInit {

    fileName = 'FactureCharge';

    societes :Array<SocieteDto>;
    declarationIss :Array<DeclarationIsDto>;
  
    constructor(factureChargeService: FactureChargeService, private societeService: SocieteService, private declarationIsService: DeclarationIsService) {
        super(factureChargeService);
        this.pdfName='FactureCharge.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSociete();
      this.loadDeclarationIs();
    }

    public async loadFactureCharges(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('FactureCharge', 'list');
        isPermistted ? this.service.findAll().subscribe(factureCharges => this.items = factureCharges,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'dateFacuture', header: 'Date facuture'},
            {field: 'societe?.ice', header: 'Societe'},
            {field: 'ice', header: 'Ice'},
            {field: 'montantHt', header: 'Montant ht'},
            {field: 'montantTtc', header: 'Montant ttc'},
            {field: 'montantTva', header: 'Montant tva'},
            {field: 'declarationIs?.id', header: 'Declaration is'},
        ];
    }


    public async loadSociete(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('FactureCharge', 'list');
        isPermistted ? this.societeService.findAllOptimized().subscribe(societes => this.societes = societes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadDeclarationIs(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('FactureCharge', 'list');
        isPermistted ? this.declarationIsService.findAll().subscribe(declarationIss => this.declarationIss = declarationIss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: FactureChargeDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Date facuture': this.datePipe.transform(e.dateFacuture , 'dd/MM/yyyy hh:mm'),
                'Societe': e.societe?.ice ,
                 'Ice': e.ice ,
                 'Montant ht': e.montantHt ,
                 'Montant ttc': e.montantTtc ,
                 'Montant tva': e.montantTva ,
                'Declaration is': e.declarationIs?.id ,
            }
        });

        this.criteriaData = [{
            'Date facuture Min': this.criteria.dateFacutureFrom ? this.datePipe.transform(this.criteria.dateFacutureFrom , this.dateFormat) : environment.emptyForExport ,
            'Date facuture Max': this.criteria.dateFacutureTo ? this.datePipe.transform(this.criteria.dateFacutureTo , this.dateFormat) : environment.emptyForExport ,
        //'Societe': this.criteria.societe?.ice ? this.criteria.societe?.ice : environment.emptyForExport ,
            'Ice': this.criteria.ice ? this.criteria.ice : environment.emptyForExport ,
            'Montant ht Min': this.criteria.montantHtMin ? this.criteria.montantHtMin : environment.emptyForExport ,
            'Montant ht Max': this.criteria.montantHtMax ? this.criteria.montantHtMax : environment.emptyForExport ,
            'Montant ttc Min': this.criteria.montantTtcMin ? this.criteria.montantTtcMin : environment.emptyForExport ,
            'Montant ttc Max': this.criteria.montantTtcMax ? this.criteria.montantTtcMax : environment.emptyForExport ,
            'Montant tva Min': this.criteria.montantTvaMin ? this.criteria.montantTvaMin : environment.emptyForExport ,
            'Montant tva Max': this.criteria.montantTvaMax ? this.criteria.montantTvaMax : environment.emptyForExport ,
        //'Declaration is': this.criteria.declarationIs?.id ? this.criteria.declarationIs?.id : environment.emptyForExport ,
        }];
      }
}

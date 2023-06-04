import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {DeclarationTvaService} from 'src/app/controller/service/DeclarationTva.service';
import {DeclarationTvaDto} from 'src/app/controller/model/DeclarationTva.model';
import {DeclarationTvaCriteria} from 'src/app/controller/criteria/DeclarationTvaCriteria.model';
import {TauxRetardTvaDto} from 'src/app/controller/model/TauxRetardTva.model';
import {TauxRetardTvaService} from 'src/app/controller/service/TauxRetardTva.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
@Component({
  selector: 'app-declaration-tva-create-admin',
  templateUrl: './declaration-tva-create-admin.component.html'
})
export class DeclarationTvaCreateAdminComponent extends AbstractCreateController<DeclarationTvaDto, DeclarationTvaCriteria, DeclarationTvaService>  implements OnInit {



    private _validSocieteIce = true;

    constructor( private declarationTvaService: DeclarationTvaService , private tauxRetardTvaService: TauxRetardTvaService, private societeService: SocieteService) {
        super(declarationTvaService);
    }

    ngOnInit(): void {
    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
    this.tauxRetardTva = new TauxRetardTvaDto();
    this.tauxRetardTvaService.findAll().subscribe((data) => this.tauxRetardTvas = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateTauxRetardTva(tauxRetardTva: string) {
    const isPermistted = await this.roleService.isPermitted('TauxRetardTva', 'add');
    if(isPermistted) {
         this.tauxRetardTva = new TauxRetardTvaDto();
         this.createTauxRetardTvaDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get societe(): SocieteDto {
        return this.societeService.item;
    }
    set societe(value: SocieteDto) {
        this.societeService.item = value;
    }
    get societes(): Array<SocieteDto> {
        return this.societeService.items;
    }
    set societes(value: Array<SocieteDto>) {
        this.societeService.items = value;
    }
    get createSocieteDialog(): boolean {
       return this.societeService.createDialog;
    }
    set createSocieteDialog(value: boolean) {
        this.societeService.createDialog= value;
    }
    get tauxRetardTva(): TauxRetardTvaDto {
        return this.tauxRetardTvaService.item;
    }
    set tauxRetardTva(value: TauxRetardTvaDto) {
        this.tauxRetardTvaService.item = value;
    }
    get tauxRetardTvas(): Array<TauxRetardTvaDto> {
        return this.tauxRetardTvaService.items;
    }
    set tauxRetardTvas(value: Array<TauxRetardTvaDto>) {
        this.tauxRetardTvaService.items = value;
    }
    get createTauxRetardTvaDialog(): boolean {
       return this.tauxRetardTvaService.createDialog;
    }
    set createTauxRetardTvaDialog(value: boolean) {
        this.tauxRetardTvaService.createDialog= value;
    }




    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
    }


}

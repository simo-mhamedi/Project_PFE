import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {
  trigger,
  state,
  style,
  transition,
  animate,
} from '@angular/animations';
import { AppComponent } from './app.component';
import { AppMainComponent } from './app.main.component';

import { AuthService } from 'src/app/zynerator/security/Auth.service';
import { RoleService } from 'src/app/zynerator/security/Role.service';

@Component({
  selector: 'app-menu',
  templateUrl: './app.menu.component.html',
  animations: [
    trigger('inline', [
      state(
        'hidden',
        style({
          height: '0px',
          overflow: 'hidden',
        })
      ),
      state(
        'visible',
        style({
          height: '*',
        })
      ),
      state(
        'hiddenAnimated',
        style({
          height: '0px',
          overflow: 'hidden',
        })
      ),
      state(
        'visibleAnimated',
        style({
          height: '*',
        })
      ),
      transition(
        'visibleAnimated => hiddenAnimated',
        animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')
      ),
      transition(
        'hiddenAnimated => visibleAnimated',
        animate('400ms cubic-bezier(0.86, 0, 0.07, 1)')
      ),
    ]),
  ],
})
export class AppMenuComponent implements OnInit {
  model: any[];
  modelsuperadmin:any[];
  modelanonymous: any[];
    modeladmin : any[];
  constructor(public app: AppComponent,
   public appMain: AppMainComponent,
   private roleService: RoleService,
   private authService:AuthService,
  private router: Router) {}

  ngOnInit() {


    this.modeladmin =
      [
              {
                label: 'Referentiel Bilan',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste etat operation comptable',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/bilan/etat-operation-comptable/list']
                    },
                    {
                      label: 'Liste compte comptable',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/bilan/compte-comptable/list']
                    },
                    {
                      label: 'Liste type operation comptable',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/bilan/type-operation-comptable/list']
                    },
                    {
                      label: 'Liste class comptable',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/bilan/class-comptable/list']
                    },
                    {
                      label: 'Liste sous class comptable',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/bilan/sous-class-comptable/list']
                    },
                    {
                      label: 'Liste etat bilan',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/bilan/etat-bilan/list']
                    },
                ]
              },
              {
                label: 'Gestion IS',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste facture produit',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/abonne/facture-produit/list']
                    },
                    {
                      label: 'Liste declaration is',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/is/declaration-is/list']
                    },
                    {
                      label: 'Liste facture charge',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/abonne/facture-charge/list']
                    },
                    {
                      label: 'Liste societe',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/abonne/societe/list']
                    },
                    {
                      label: 'Liste taux is',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/is/taux-is/list']
                    },
                ]
              },
              {
                label: 'Gestion Bilan',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste bilan',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/bilan/bilan/list']
                    },
                    {
                      label: 'Liste operation comptable',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/bilan/operation-comptable/list']
                    },
                ]
              },
              {
                label: 'Gestion TVA',
                icon: 'pi pi-wallet',
                items:[
                    {
                      label: 'Liste taux retard tva',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/tva/taux-retard-tva/list']
                    },
                    {
                      label: 'Liste declaration tva',
                      icon: 'pi pi-fw pi-plus-circle',
                      routerLink: ['/app/admin/tva/declaration-tva/list']
                    },
                ]
              },
    ]
        if (this.authService.authenticated) {
      if (this.authService.authenticatedUser.roles) {

        this.authService.authenticatedUser.roles.forEach(role => {
          const roleName: string = this.getRole(role);
          this.roleService._role.next(roleName.toUpperCase());
          eval('this.model = this.model' + this.getRole(role));
        })
      }

    }
  }
  getRole(text){
  const [role, ...rest] = text.split('_');
  return rest.join('').toLowerCase();
}
  onMenuClick(event) {
    this.appMain.onMenuClick(event);
  }
}

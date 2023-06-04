
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { FactureProduitListAdminComponent } from './facture-produit-admin/list-admin/facture-produit-list-admin.component';
import { FactureChargeListAdminComponent } from './facture-charge-admin/list-admin/facture-charge-list-admin.component';
import { SocieteListAdminComponent } from './societe-admin/list-admin/societe-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'facture-produit',
                            children: [
                                {
                                    path: 'list',
                                    component: FactureProduitListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'facture-charge',
                            children: [
                                {
                                    path: 'list',
                                    component: FactureChargeListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'societe',
                            children: [
                                {
                                    path: 'list',
                                    component: SocieteListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class AbonneAdminRoutingModule { }

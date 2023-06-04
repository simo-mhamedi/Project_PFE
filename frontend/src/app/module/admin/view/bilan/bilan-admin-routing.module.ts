
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';



import { EtatOperationComptableListAdminComponent } from './etat-operation-comptable-admin/list-admin/etat-operation-comptable-list-admin.component';
import { CompteComptableListAdminComponent } from './compte-comptable-admin/list-admin/compte-comptable-list-admin.component';
import { TypeOperationComptableListAdminComponent } from './type-operation-comptable-admin/list-admin/type-operation-comptable-list-admin.component';
import { ClassComptableListAdminComponent } from './class-comptable-admin/list-admin/class-comptable-list-admin.component';
import { BilanListAdminComponent } from './bilan-admin/list-admin/bilan-list-admin.component';
import { SousClassComptableListAdminComponent } from './sous-class-comptable-admin/list-admin/sous-class-comptable-list-admin.component';
import { EtatBilanListAdminComponent } from './etat-bilan-admin/list-admin/etat-bilan-list-admin.component';
import { OperationComptableListAdminComponent } from './operation-comptable-admin/list-admin/operation-comptable-list-admin.component';
@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [


                        {

                            path: 'etat-operation-comptable',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatOperationComptableListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'compte-comptable',
                            children: [
                                {
                                    path: 'list',
                                    component: CompteComptableListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'type-operation-comptable',
                            children: [
                                {
                                    path: 'list',
                                    component: TypeOperationComptableListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'class-comptable',
                            children: [
                                {
                                    path: 'list',
                                    component: ClassComptableListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'bilan',
                            children: [
                                {
                                    path: 'list',
                                    component: BilanListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'sous-class-comptable',
                            children: [
                                {
                                    path: 'list',
                                    component: SousClassComptableListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'etat-bilan',
                            children: [
                                {
                                    path: 'list',
                                    component: EtatBilanListAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                            ]
                        },

                        {

                            path: 'operation-comptable',
                            children: [
                                {
                                    path: 'list',
                                    component: OperationComptableListAdminComponent ,
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
export class BilanAdminRoutingModule { }

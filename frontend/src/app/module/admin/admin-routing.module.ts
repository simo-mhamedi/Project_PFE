
// const root = environment.rootAppUrl;

import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthGuard } from 'src/app/controller/guards/auth.guard';

import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';

@NgModule({
    imports: [
        RouterModule.forChild(
            [
                {
                    path: '',
                    children: [
                        {
                            path: 'login',
                            children: [
                                {
                                    path: '',
                                    component: LoginAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {
                            path: 'register',
                            children: [
                                {
                                    path: '',
                                    component: RegisterAdminComponent ,
                                    canActivate: [AuthGuard]
                                }
                              ]
                        },
                        {

                            path: 'bilan',
                            loadChildren: () => import('./view/bilan/bilan-admin-routing.module').then(x=>x.BilanAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'abonne',
                            loadChildren: () => import('./view/abonne/abonne-admin-routing.module').then(x=>x.AbonneAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'is',
                            loadChildren: () => import('./view/is/is-admin-routing.module').then(x=>x.IsAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                        {

                            path: 'tva',
                            loadChildren: () => import('./view/tva/tva-admin-routing.module').then(x=>x.TvaAdminRoutingModule),
                            canActivate: [AuthGuard],
                        },
                    ]
                },
            ]
        ),
    ],
    exports: [RouterModule],
})
export class AdminRoutingModule { }

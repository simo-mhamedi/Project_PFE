import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from "primeng/fileupload";

import { EtatOperationComptableCreateAdminComponent } from './etat-operation-comptable-admin/create-admin/etat-operation-comptable-create-admin.component';
import { EtatOperationComptableEditAdminComponent } from './etat-operation-comptable-admin/edit-admin/etat-operation-comptable-edit-admin.component';
import { EtatOperationComptableViewAdminComponent } from './etat-operation-comptable-admin/view-admin/etat-operation-comptable-view-admin.component';
import { EtatOperationComptableListAdminComponent } from './etat-operation-comptable-admin/list-admin/etat-operation-comptable-list-admin.component';
import { CompteComptableCreateAdminComponent } from './compte-comptable-admin/create-admin/compte-comptable-create-admin.component';
import { CompteComptableEditAdminComponent } from './compte-comptable-admin/edit-admin/compte-comptable-edit-admin.component';
import { CompteComptableViewAdminComponent } from './compte-comptable-admin/view-admin/compte-comptable-view-admin.component';
import { CompteComptableListAdminComponent } from './compte-comptable-admin/list-admin/compte-comptable-list-admin.component';
import { TypeOperationComptableCreateAdminComponent } from './type-operation-comptable-admin/create-admin/type-operation-comptable-create-admin.component';
import { TypeOperationComptableEditAdminComponent } from './type-operation-comptable-admin/edit-admin/type-operation-comptable-edit-admin.component';
import { TypeOperationComptableViewAdminComponent } from './type-operation-comptable-admin/view-admin/type-operation-comptable-view-admin.component';
import { TypeOperationComptableListAdminComponent } from './type-operation-comptable-admin/list-admin/type-operation-comptable-list-admin.component';
import { ClassComptableCreateAdminComponent } from './class-comptable-admin/create-admin/class-comptable-create-admin.component';
import { ClassComptableEditAdminComponent } from './class-comptable-admin/edit-admin/class-comptable-edit-admin.component';
import { ClassComptableViewAdminComponent } from './class-comptable-admin/view-admin/class-comptable-view-admin.component';
import { ClassComptableListAdminComponent } from './class-comptable-admin/list-admin/class-comptable-list-admin.component';
import { BilanCreateAdminComponent } from './bilan-admin/create-admin/bilan-create-admin.component';
import { BilanEditAdminComponent } from './bilan-admin/edit-admin/bilan-edit-admin.component';
import { BilanViewAdminComponent } from './bilan-admin/view-admin/bilan-view-admin.component';
import { BilanListAdminComponent } from './bilan-admin/list-admin/bilan-list-admin.component';
import { SousClassComptableCreateAdminComponent } from './sous-class-comptable-admin/create-admin/sous-class-comptable-create-admin.component';
import { SousClassComptableEditAdminComponent } from './sous-class-comptable-admin/edit-admin/sous-class-comptable-edit-admin.component';
import { SousClassComptableViewAdminComponent } from './sous-class-comptable-admin/view-admin/sous-class-comptable-view-admin.component';
import { SousClassComptableListAdminComponent } from './sous-class-comptable-admin/list-admin/sous-class-comptable-list-admin.component';
import { EtatBilanCreateAdminComponent } from './etat-bilan-admin/create-admin/etat-bilan-create-admin.component';
import { EtatBilanEditAdminComponent } from './etat-bilan-admin/edit-admin/etat-bilan-edit-admin.component';
import { EtatBilanViewAdminComponent } from './etat-bilan-admin/view-admin/etat-bilan-view-admin.component';
import { EtatBilanListAdminComponent } from './etat-bilan-admin/list-admin/etat-bilan-list-admin.component';
import { OperationComptableCreateAdminComponent } from './operation-comptable-admin/create-admin/operation-comptable-create-admin.component';
import { OperationComptableEditAdminComponent } from './operation-comptable-admin/edit-admin/operation-comptable-edit-admin.component';
import { OperationComptableViewAdminComponent } from './operation-comptable-admin/view-admin/operation-comptable-view-admin.component';
import { OperationComptableListAdminComponent } from './operation-comptable-admin/list-admin/operation-comptable-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    EtatOperationComptableCreateAdminComponent,
    EtatOperationComptableListAdminComponent,
    EtatOperationComptableViewAdminComponent,
    EtatOperationComptableEditAdminComponent,
    CompteComptableCreateAdminComponent,
    CompteComptableListAdminComponent,
    CompteComptableViewAdminComponent,
    CompteComptableEditAdminComponent,
    TypeOperationComptableCreateAdminComponent,
    TypeOperationComptableListAdminComponent,
    TypeOperationComptableViewAdminComponent,
    TypeOperationComptableEditAdminComponent,
    ClassComptableCreateAdminComponent,
    ClassComptableListAdminComponent,
    ClassComptableViewAdminComponent,
    ClassComptableEditAdminComponent,
    BilanCreateAdminComponent,
    BilanListAdminComponent,
    BilanViewAdminComponent,
    BilanEditAdminComponent,
    SousClassComptableCreateAdminComponent,
    SousClassComptableListAdminComponent,
    SousClassComptableViewAdminComponent,
    SousClassComptableEditAdminComponent,
    EtatBilanCreateAdminComponent,
    EtatBilanListAdminComponent,
    EtatBilanViewAdminComponent,
    EtatBilanEditAdminComponent,
    OperationComptableCreateAdminComponent,
    OperationComptableListAdminComponent,
    OperationComptableViewAdminComponent,
    OperationComptableEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
  ],
  exports: [
  EtatOperationComptableCreateAdminComponent,
  EtatOperationComptableListAdminComponent,
  EtatOperationComptableViewAdminComponent,
  EtatOperationComptableEditAdminComponent,
  CompteComptableCreateAdminComponent,
  CompteComptableListAdminComponent,
  CompteComptableViewAdminComponent,
  CompteComptableEditAdminComponent,
  TypeOperationComptableCreateAdminComponent,
  TypeOperationComptableListAdminComponent,
  TypeOperationComptableViewAdminComponent,
  TypeOperationComptableEditAdminComponent,
  ClassComptableCreateAdminComponent,
  ClassComptableListAdminComponent,
  ClassComptableViewAdminComponent,
  ClassComptableEditAdminComponent,
  BilanCreateAdminComponent,
  BilanListAdminComponent,
  BilanViewAdminComponent,
  BilanEditAdminComponent,
  SousClassComptableCreateAdminComponent,
  SousClassComptableListAdminComponent,
  SousClassComptableViewAdminComponent,
  SousClassComptableEditAdminComponent,
  EtatBilanCreateAdminComponent,
  EtatBilanListAdminComponent,
  EtatBilanViewAdminComponent,
  EtatBilanEditAdminComponent,
  OperationComptableCreateAdminComponent,
  OperationComptableListAdminComponent,
  OperationComptableViewAdminComponent,
  OperationComptableEditAdminComponent,
  ],
  entryComponents: [],
})
export class BilanAdminModule { }
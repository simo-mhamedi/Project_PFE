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

import { FactureProduitCreateAdminComponent } from './facture-produit-admin/create-admin/facture-produit-create-admin.component';
import { FactureProduitEditAdminComponent } from './facture-produit-admin/edit-admin/facture-produit-edit-admin.component';
import { FactureProduitViewAdminComponent } from './facture-produit-admin/view-admin/facture-produit-view-admin.component';
import { FactureProduitListAdminComponent } from './facture-produit-admin/list-admin/facture-produit-list-admin.component';
import { FactureChargeCreateAdminComponent } from './facture-charge-admin/create-admin/facture-charge-create-admin.component';
import { FactureChargeEditAdminComponent } from './facture-charge-admin/edit-admin/facture-charge-edit-admin.component';
import { FactureChargeViewAdminComponent } from './facture-charge-admin/view-admin/facture-charge-view-admin.component';
import { FactureChargeListAdminComponent } from './facture-charge-admin/list-admin/facture-charge-list-admin.component';
import { SocieteCreateAdminComponent } from './societe-admin/create-admin/societe-create-admin.component';
import { SocieteEditAdminComponent } from './societe-admin/edit-admin/societe-edit-admin.component';
import { SocieteViewAdminComponent } from './societe-admin/view-admin/societe-view-admin.component';
import { SocieteListAdminComponent } from './societe-admin/list-admin/societe-list-admin.component';

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

    FactureProduitCreateAdminComponent,
    FactureProduitListAdminComponent,
    FactureProduitViewAdminComponent,
    FactureProduitEditAdminComponent,
    FactureChargeCreateAdminComponent,
    FactureChargeListAdminComponent,
    FactureChargeViewAdminComponent,
    FactureChargeEditAdminComponent,
    SocieteCreateAdminComponent,
    SocieteListAdminComponent,
    SocieteViewAdminComponent,
    SocieteEditAdminComponent,
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
  FactureProduitCreateAdminComponent,
  FactureProduitListAdminComponent,
  FactureProduitViewAdminComponent,
  FactureProduitEditAdminComponent,
  FactureChargeCreateAdminComponent,
  FactureChargeListAdminComponent,
  FactureChargeViewAdminComponent,
  FactureChargeEditAdminComponent,
  SocieteCreateAdminComponent,
  SocieteListAdminComponent,
  SocieteViewAdminComponent,
  SocieteEditAdminComponent,
  ],
  entryComponents: [],
})
export class AbonneAdminModule { }
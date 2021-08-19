import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MedicoListComponent } from './medico-list/medico-list.component';
import { CreateMedicoComponent } from './create-medico/create-medico.component';
import { UpdateMedicoComponent } from './update-medico/update-medico.component';
import { MedicoDetailsComponent } from './medico-details/medico-details.component';

import { PessoaListComponent } from './pessoa-list/pessoa-list.component';
import { CreatePessoaComponent } from './create-pessoa/create-pessoa.component';
import { UpdatePessoaComponent } from './update-pessoa/update-pessoa.component';
import { PessoaDetailsComponent } from './pessoa-details/pessoa-details.component';


const routes: Routes = [
  {path: 'medicos', component: MedicoListComponent},
  {path: 'create-medico', component: CreateMedicoComponent},
  {path: '', redirectTo: 'medicos', pathMatch: 'full'},
  {path: 'update-medico/:id', component: UpdateMedicoComponent},
  {path: 'medico-details/:id', component: MedicoDetailsComponent},
  {path: 'pessoas', component: PessoaListComponent},
  {path: 'create-pessoa', component: CreatePessoaComponent},
  {path: '', redirectTo: 'pessoas', pathMatch: 'full'},
  {path: 'update-pessoa/:id', component: UpdatePessoaComponent},
  {path: 'pessoa-details/:id', component: PessoaDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }
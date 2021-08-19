import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateMedicoComponent } from './medico/create-medico/create-medico.component';
import { MedicoListComponent } from './medico/medico-list/medico-list.component';
import { FormsModule} from '@angular/forms';
import { UpdateMedicoComponent } from './medico/update-medico/update-medico.component';
import { MedicoDetailsComponent } from './medico/medico-details/medico-details.component';
import { CreatePessoaComponent } from './pessoa/create-pessoa/create-pessoa.component';
import { UpdatePessoaComponent } from './pessoa/update-pessoa/update-pessoa.component';
import { PessoaDetailsComponent } from './pessoa/pessoa-details/pessoa-details.component';
import { PessoaListComponent } from './pessoa/pessoa-list/pessoa-list.component'

@NgModule({
  declarations: [
    AppComponent,
    MedicoListComponent,
    CreateMedicoComponent,
    UpdateMedicoComponent,
    MedicoDetailsComponent,
    CreatePessoaComponent,
    UpdatePessoaComponent,
    PessoaDetailsComponent,
    PessoaListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }


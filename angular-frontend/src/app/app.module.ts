import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateMedicoComponent } from './create-medico/create-medico.component';
import { MedicoListComponent } from './medico-list/medico-list.component';
import { FormsModule} from '@angular/forms';
import { UpdateMedicoComponent } from './update-medico/update-medico.component';
import { MedicoDetailsComponent } from './medico-details/medico-details.component';
import { CreatePessoaComponent } from './create-pessoa/create-pessoa.component';
import { UpdatePessoaComponent } from './update-pessoa/update-pessoa.component';
import { PessoaDetailsComponent } from './pessoa-details/pessoa-details.component';
import { PessoaListComponent } from './pessoa-list/pessoa-list.component'

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


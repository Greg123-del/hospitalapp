import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule  } from '@angular/http';
import {FormsModule} from '@angular/forms'


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './Menu/menu.component';
import { HomeComponent } from './Home/home.component';
import { MedicoComponent } from './Medico/medico.component';
import {PacienteComponent} from './Paciente/paciente.component'
import { HttpClientModule } from '@angular/common/http';
import { AddMedicoComponent } from './cadastrarMedico/cadastrar.component';
import {AddPacienteComponent} from './cadastrarPaciente/cadastrar.component';
import {LiberarComponent} from './liberarMedico/liberar.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';





import {routing} from './app.routes';




@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    MedicoComponent,
    PacienteComponent,
    AddMedicoComponent,
    AddPacienteComponent,
    LiberarComponent,
    HeaderComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule,
    routing,
    HttpClientModule,
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule  } from '@angular/http';
import {FormsModule} from '@angular/forms'


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './Menu/menu.component';
import { HomeComponent } from './Home/home.component';
import { MedicoComponent } from './Medico/medico.component';
import { HttpClientModule } from '@angular/common/http';

import {routing} from './app.routes';




@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    MedicoComponent
    
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule,
    routing,
    HttpClientModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

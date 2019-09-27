import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
 

import { HomeComponent } from './Home/home.component';
import { MedicoComponent } from './Medico/medico.component';
 
const appRoutes: Routes = [
    { path: 'home',                    component: HomeComponent },
    { path: '',                        component: HomeComponent },
    { path: 'Medico',                component: MedicoComponent },

 
];
 
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
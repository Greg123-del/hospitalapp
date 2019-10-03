import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
 

import { HomeComponent } from './Home/home.component';
import { MedicoComponent } from './Medico/medico.component';
import { PacienteComponent } from './Paciente/paciente.component';
import {AddMedicoComponent} from './cadastrarMedico/cadastrar.component';
import {AddPacienteComponent} from './cadastrarPaciente/cadastrar.component';
import {LiberarComponent} from './liberarMedico/liberar.component';

 
const appRoutes: Routes = [
    { path: 'home',                              component: HomeComponent },
    { path: 'Paciente',                        component: PacienteComponent },
    { path: 'Medico',                       component: MedicoComponent },
    { path: 'Adicionar',                component: AddMedicoComponent },
    { path: 'AdicionarPac',                component: AddPacienteComponent },
    { path: 'liberar',                component: LiberarComponent },


 
];
 
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
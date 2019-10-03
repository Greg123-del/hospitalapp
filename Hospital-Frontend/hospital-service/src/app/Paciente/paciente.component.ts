import { Component, OnInit } from '@angular/core';
import { HttpClientService, Paciente } from '../services/http-client.service';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.css']
})
export class PacienteComponent implements OnInit {

  pacientes: Paciente[];
   
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
    this.httpClientService.getPaciente().subscribe(
     response =>{this.pacientes = response;}
    ); 
  }

}
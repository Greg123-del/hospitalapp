import { Component, OnInit } from '@angular/core';
import { HttpClientService, Medico } from '../services/http-client.service';

@Component({
  selector: 'app-medico',
  templateUrl: './medico.component.html',
  styleUrls: ['./medico.component.css']
})
export class MedicoComponent implements OnInit {

  medicos: Medico[];
   
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
    this.httpClientService.getMedicos().subscribe(
     response =>{this.medicos = response;}
    ); 
    console.log(this.medicos);    
  }

  deleteMedico(medicos: Medico): void {
    this.httpClientService.deleteMedico(medicos)
      .subscribe( data => {
        this.medicos = this.medicos.filter(u => u !== medicos);
      })
  };
}
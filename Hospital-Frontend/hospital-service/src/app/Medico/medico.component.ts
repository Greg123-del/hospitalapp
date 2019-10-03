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
  }

  deleteMedico(userID: number): void {
    this.httpClientService.deleteMedico(userID)
      .subscribe( response => {
        this.httpClientService.getMedicos().subscribe(
          response =>{this.medicos = response;}
         );   
      })
  };

  Atender(num_regi: number): void{
    this.httpClientService.updateAtender(num_regi)
    .subscribe( response => {
      this.httpClientService.getMedicos().subscribe(
        response =>{this.medicos = response;}
       );   
    })
};

}
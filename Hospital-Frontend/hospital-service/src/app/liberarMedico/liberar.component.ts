import { Component, OnInit } from '@angular/core';
import { HttpClientService, Medico } from '../services/http-client.service';

@Component({
  selector: 'app-liberar',
  templateUrl: './liberar.component.html',
  styleUrls: ['./liberar.component.css']
})
export class LiberarComponent implements OnInit {

  medicos: Medico[];
   
  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
    this.httpClientService.getMedicos2().subscribe(
     response =>{this.medicos = response;}
    );   
  }

  liberar(num_regi: number): void {
    this.httpClientService.liberar(num_regi)
      .subscribe( response => {
        this.httpClientService.getMedicos2().subscribe(
          response =>{this.medicos = response;}
         );   
      })
  };
}
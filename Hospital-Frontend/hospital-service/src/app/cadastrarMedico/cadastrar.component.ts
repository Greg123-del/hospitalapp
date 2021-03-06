import { Component, OnInit } from '@angular/core';
import { HttpClientService, Medico } from '../services/http-client.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-medico',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class AddMedicoComponent implements OnInit {
    public g:number;
    public h:number;
    public t:number;

  medico: Medico = new Medico(this.g,"",this.h,this.t);

  constructor(private router: Router,
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {

  }

  createMedico(medico): void {
    this.httpClientService.createMedico(this.medico)
        .subscribe( data => {
          if(medico!=null){
          alert("Error , doctor exists");
          }else{
            alert("Error , doctor exists");

      }});
    } 
  }
import { Component, OnInit } from '@angular/core';
import { HttpClientService, Paciente } from '../services/http-client.service';

@Component({
  selector: 'app-add-paciente',
  templateUrl: './cadastrar.component.html',
  styleUrls: ['./cadastrar.component.css']
})
export class AddPacienteComponent implements OnInit {
    public g:number;
    public h:number;
    public t:number;
    public a:number;
    public o:number = null;

  paciente: Paciente = new Paciente(this.g,"",this.h,this.t,this.a,this.o);

  constructor(
    private httpClientService: HttpClientService
  ) { }

  ngOnInit() {
  }

  createPaciente(): void {
    this.httpClientService.createPaciente(this.paciente)
        .subscribe( data => {
          alert("Successfully created patient");
        });

  };

}
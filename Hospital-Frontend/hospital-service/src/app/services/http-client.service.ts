import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Medico{
  constructor(
    public ID_medico:number,
    public name:string,
    public num_regi:number,
    public qtdAtend:number,
  ) {}
  
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient:HttpClient
  ) { 
     }

     getMedicos()
  {
    console.log("test call");
    return this.httpClient.get<Medico[]>('http://localhost:8080/listarMedico');
  }

  public deleteMedico(medico) {
    return this.httpClient.delete<Medico>("http://localhost:8080/listarMedico" + "/"+ medico.ID_medico);
  }

  public createEmployee(medico) {
    return this.httpClient.post<Medico>("http://localhost:8080/medicos", medico);
  }
}
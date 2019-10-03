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

export class Paciente{
  constructor(
    public id_paciente:number,
    public name:string,
    public age:number,
    public temperature:number,
    public glicose:number,
    public ID_medico:number,
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
//Methods \/\/\/; 
     getMedicos()
  {
    return this.httpClient.get<Medico[]>('http://localhost:8080/medicos/listarMedico');
  }

  getMedicos2()
  {
    return this.httpClient.get<Medico[]>('http://localhost:8080/medicos/listarMedicoAtendimento');
  }

  public liberar(num_regi:number)
  {
    return this.httpClient.put<Medico>('http://localhost:8080/medicos/liberarMedico', num_regi);
  }

  public deleteMedico(userID: number){
    return this.httpClient.delete<Medico>("http://localhost:8080/medicos" + "/"+ userID);
  }

  public createMedico(medico) {
    return this.httpClient.post<Medico>("http://localhost:8080/medicos/cadastrarMedico", medico);
  }

  getPaciente()
  {
    return this.httpClient.get<Paciente[]>('http://localhost:8080/pacientes/listarPaciente');
  }

  public createPaciente(paciente) {
    return this.httpClient.post<Paciente>("http://localhost:8080/pacientes/cadastrarPaciente", paciente);
  }

  public updateAtender(num_regi:number){
      return this.httpClient.put<Medico>("http://localhost:8080/pacientes/atenderPaciente", num_regi);
    }
  }
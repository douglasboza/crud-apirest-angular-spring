import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Medico } from './medico';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  private baseURL = "http://localhost:8080/api/v1/medicos";

  constructor(private httpClient: HttpClient) { }
  
  getMedicosList(): Observable<Medico[]>{
    return this.httpClient.get<Medico[]>(`${this.baseURL}`);
  }

  createMedico(medico: Medico): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, medico);
  }

  getMedicoById(id: number): Observable<Medico>{
    return this.httpClient.get<Medico>(`${this.baseURL}/${id}`);
  }

  updateMedico(id: number, medico: Medico): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, Medico);
  }

  deleteMedico(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
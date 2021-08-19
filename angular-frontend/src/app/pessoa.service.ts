import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Pessoa } from './pessoa';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  private baseURL = "http://localhost:8080/api/v1/pessoas";

  constructor(private httpClient: HttpClient) { }
  
  getPessoasList(): Observable<Pessoa[]>{
    return this.httpClient.get<Pessoa[]>(`${this.baseURL}`);
  }

  createPessoa(pessoa: Pessoa): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, pessoa);
  }

  getPessoaById(id: number): Observable<Pessoa>{
    return this.httpClient.get<Pessoa>(`${this.baseURL}/${id}`);
  }

  updatePessoa(id: number, pessoa: Pessoa): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, Pessoa);
  }

  deletePessoa(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
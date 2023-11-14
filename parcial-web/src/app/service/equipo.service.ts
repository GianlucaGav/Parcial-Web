import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, Subject, tap, throwError } from 'rxjs';
import { EquipoRequest } from '../model/EquipoRequest';

@Injectable({
  providedIn: 'root'
})
export class EquipoService {

  constructor(private _httpClient : HttpClient) { }

  getEquipos(): Observable<EquipoRequest []> {
    return this._httpClient.get<EquipoRequest []>('http://localhost:8080/api/get/equipos');
  }

  addEquipo(equipo: EquipoRequest): Observable<EquipoRequest> {
    return this._httpClient.post<EquipoRequest>('http://localhost:8080/api/add/equipo', equipo);
  }
}

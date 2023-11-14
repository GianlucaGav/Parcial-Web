import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JugadorRequest } from '../model/JugadorRequest';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JugadorService {

  constructor(private _httpClient : HttpClient) { }

  addJugador(jugador: JugadorRequest): any {
    return this._httpClient.post<JugadorRequest>('http://localhost:8080/api/add/jugador', jugador);
  }

  getJugadores(): Observable<JugadorRequest []> {
    return this._httpClient.get<JugadorRequest []>('http://localhost:8080/api/get/jugadores');
  }
}

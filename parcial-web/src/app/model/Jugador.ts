import { EquipoRequest } from "./EquipoRequest";

export interface Jugador {
    id: number;
    nombres: string;
    apellidos: string;
    numero: number;
    equipo: EquipoRequest;
  }
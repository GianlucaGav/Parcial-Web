import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JugadorRequest } from '../../model/JugadorRequest';
import { JugadorService } from '../../service/jugador.service';

@Component({
  selector: 'app-jugador',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './jugador.component.html',
  styleUrl: './jugador.component.css'
})
export class JugadorComponent {

  constructor(private jugadorService: JugadorService) { }
  jugador: JugadorRequest = {
    nombres: '',
    apellidos: '',
    numero: 0,
    equipoId: 0
  };

  insertarJugador(): void {
    this.jugadorService.addJugador(this.jugador).subscribe(() => {
      alert('Jugador agregado correctamente');
      // Puedes redirigir o realizar otras acciones después de la inserción
    });
  }
}

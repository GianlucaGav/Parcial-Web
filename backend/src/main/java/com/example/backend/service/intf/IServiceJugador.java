package com.example.backend.service.intf;

import com.example.backend.model.Jugador;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceJugador {
    Jugador guardarJugador(Jugador jugador);
    Jugador actualizarJugador(Jugador jugador);
    void eliminarJugador(Long id);
    Jugador buscarJugador(Long id);
    List <Jugador> buscarJugadores();
}

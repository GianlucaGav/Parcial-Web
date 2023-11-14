package com.example.backend.service.imp;

import com.example.backend.model.Jugador;
import com.example.backend.repository.IJugadorRepository;
import com.example.backend.service.intf.IServiceJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceJugador implements IServiceJugador {
    @Autowired
    private IJugadorRepository jugadorRepository;

    @Override
    public Jugador guardarJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public Jugador actualizarJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public void eliminarJugador(Long id) {
        jugadorRepository.deleteById(id);
    }

    @Override
    public Jugador buscarJugador(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Jugador> buscarJugadores() {
        return jugadorRepository.findAll();
    }
}

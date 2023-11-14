package com.example.backend.controller;

import com.example.backend.dto.EquipoRequest;
import com.example.backend.dto.JugadorRequest;
import com.example.backend.model.Equipo;
import com.example.backend.model.Jugador;
import com.example.backend.service.intf.IServiceEquipo;
import com.example.backend.service.intf.IServiceJugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class MainController {

    @Autowired
    private IServiceEquipo serviceEquipo;
    @Autowired
    private IServiceJugador serviceJugador;

    @GetMapping("/get/jugadores")
    public ResponseEntity <?> getJugadores(){
        return ResponseEntity.ok(serviceJugador.buscarJugadores());
    }

    @GetMapping("/get/equipos")
    public ResponseEntity <?> getEquipos(){
        return ResponseEntity.ok(serviceEquipo.buscarEquipos());
    }

    @GetMapping("/get/jugador/{idJugador}")
    public ResponseEntity <?> getJugadorById(@PathVariable Long idJugador){
        return ResponseEntity.ok(serviceJugador.buscarJugador(idJugador));
    }

    @GetMapping("/get/equipo/{idEquipo}")
    public ResponseEntity<?> getEquipoById(@PathVariable Long idEquipo){
        return ResponseEntity.ok(serviceEquipo.buscarEquipo(idEquipo));
    }

    @PostMapping("/add/jugador")
    public ResponseEntity <?> addJugador(@RequestBody JugadorRequest jugadorRequest){
        Equipo equipo = serviceEquipo.buscarEquipo(jugadorRequest.getEquipoId());
        if (equipo == null){
            return ResponseEntity.badRequest().body("No existe el equipo");
        }
        Jugador jug = Jugador.builder()
                .numero(jugadorRequest.getNumero())
                .nombres(jugadorRequest.getNombres())
                .apellidos(jugadorRequest.getApellidos())
                .equipo(equipo)
                .build();
        return ResponseEntity.ok(serviceJugador.guardarJugador(jug));
    }

    @PostMapping("/add/equipo")
    public ResponseEntity <?> addEquipo(@RequestBody EquipoRequest equipoRequest){
        Equipo equipo = Equipo.builder()
                .ciudad(equipoRequest.getCiudad())
                .nombre(equipoRequest.getNombre())
                .cantidadCopasInternacionales(equipoRequest.getCantidadCopasInternacionales())
                .build();
        return ResponseEntity.ok(serviceEquipo.guardarEquipo(equipo));
    }

    @DeleteMapping("/delete/jugador/{idJugador}")
    public ResponseEntity <?> deleteJugador(@PathVariable Long idJugador){
        serviceJugador.eliminarJugador(idJugador);
        return ResponseEntity.ok("Jugador eliminado");
    }

    @DeleteMapping("/delete/equipo/{idEquipo}")
    public ResponseEntity <?> deleteEquipo(@PathVariable Long idEquipo){
        serviceEquipo.eliminarEquipo(idEquipo);
        return ResponseEntity.ok("Equipo eliminado");
    }


    @PutMapping("/update/jugador/{idJugador}")
    public ResponseEntity <?> updateJugador (@RequestBody JugadorRequest jugadorRequest, @PathVariable Long idJugador){
        Jugador jugador = serviceJugador.buscarJugador(idJugador);
        if (jugador == null){
            return ResponseEntity.badRequest().body("No existe el jugador");
        }
        Equipo equipo = serviceEquipo.buscarEquipo(jugadorRequest.getEquipoId());
        if (equipo == null){
            return ResponseEntity.badRequest().body("No existe el equipo");
        }
        jugador.setNumero(jugadorRequest.getNumero());
        jugador.setNombres(jugadorRequest.getNombres());
        jugador.setApellidos(jugadorRequest.getApellidos());
        jugador.setEquipo(equipo);

        return ResponseEntity.ok(serviceJugador.actualizarJugador(jugador));
    }

    @PutMapping("/update/equipo/{idEquipo}")
    public ResponseEntity <?> updateEquipo (@RequestBody EquipoRequest equipoRequest, @PathVariable Long idEquipo){
        Equipo equipo = serviceEquipo.buscarEquipo(idEquipo);
        if (equipo == null){
            return ResponseEntity.badRequest().body("No existe el equipo");
        }
        equipo.setCiudad(equipoRequest.getCiudad());
        equipo.setNombre(equipoRequest.getNombre());
        equipo.setCantidadCopasInternacionales(equipoRequest.getCantidadCopasInternacionales());

        return ResponseEntity.ok(serviceEquipo.actualizarEquipo(equipo));
    }


}

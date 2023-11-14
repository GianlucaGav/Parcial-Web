package com.example.backend.service.intf;

import com.example.backend.model.Equipo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceEquipo {
    Equipo guardarEquipo(Equipo equipo);
    Equipo actualizarEquipo(Equipo equipo);
    void eliminarEquipo(Long id);
    Equipo buscarEquipo(Long id);
    List <Equipo> buscarEquipos();
}

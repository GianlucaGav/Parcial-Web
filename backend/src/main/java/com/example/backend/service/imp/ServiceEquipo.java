package com.example.backend.service.imp;

import com.example.backend.model.Equipo;
import com.example.backend.repository.IEquipoRepository;
import com.example.backend.service.intf.IServiceEquipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEquipo implements IServiceEquipo {

    @Autowired
    private IEquipoRepository equipoRepository;

    @Override
    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public Equipo actualizarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public void eliminarEquipo(Long id) {
        equipoRepository.deleteById(id);
    }

    @Override
    public Equipo buscarEquipo(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipo> buscarEquipos() {
        return equipoRepository.findAll();
    }
}

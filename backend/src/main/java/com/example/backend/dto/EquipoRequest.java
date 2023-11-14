package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class EquipoRequest {
    private String nombre;
    private String ciudad;
    private int cantidadCopasInternacionales;
}

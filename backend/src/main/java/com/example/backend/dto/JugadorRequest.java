package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class JugadorRequest {
    private String nombres;
    private String apellidos;
    private int numero;
    private Long equipoId;
}

package com.ceiba.usuario.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;
}

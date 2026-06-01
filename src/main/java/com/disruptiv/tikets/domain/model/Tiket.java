package com.disruptiv.tikets.domain.model;

import java.time.LocalDate;

import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.domain.enums.EnumPrioridad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tiket {

    private Long id;

    private String titulo;

    private String descripcion;

    private EnumEstado estado;

    private EnumPrioridad prioridad;

    private LocalDate fechaCreacion;

    private Usuario usuarioAsig;
}

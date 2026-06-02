package com.disruptiv.tikets.infra.input.dto.resp;

import java.time.LocalDateTime;

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
public class TiketResponse {

    private Long id;

    private String titulo;

    private String descripcion;

    private EnumEstado estado;

    private EnumPrioridad prioridad;

    private LocalDateTime fechaCreacion;

    private Long usuarioId;

    private String nombreResponsable;

    private String emailResponsable;
}

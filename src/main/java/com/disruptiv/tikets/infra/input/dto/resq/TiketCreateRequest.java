package com.disruptiv.tikets.infra.input.dto.resq;

import com.disruptiv.tikets.domain.enums.EnumPrioridad;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TiketCreateRequest {

    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotNull(message = "La prioridad es obligatoria")
    private EnumPrioridad prioridad;
}
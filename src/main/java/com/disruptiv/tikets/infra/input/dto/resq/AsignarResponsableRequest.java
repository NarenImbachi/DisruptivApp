package com.disruptiv.tikets.infra.input.dto.resq;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsignarResponsableRequest {

    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;
}

package com.disruptiv.tikets.app.input;

import java.util.List;

import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.infra.input.dto.resp.TiketResponse;
import com.disruptiv.tikets.infra.input.dto.resq.TiketCreateRequest;

public interface ITiketInputPort {
    TiketResponse crearTiket(TiketCreateRequest request);
    List<TiketResponse> listarTikets();
    List<TiketResponse> filtrarPorEstado(EnumEstado estado);
    TiketResponse cambiarEstado(Long id, EnumEstado nuevoEstado);
    TiketResponse asignarTiket(Long id, Long usuarioId);

}

/**
 * 
 * 1. Crear una solicitud.
2. Listar solicitudes.
3. Filtrar por estado.
4. Cambiar el estado de una solicitud.
5. Asignar una solicitud a una persona
6. Visualizar un pequeño dashboard con:
o Total, de solicitudes.
o Cantidad por estado.
o Cantidad por prioridad.
 */

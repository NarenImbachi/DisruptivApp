package com.disruptiv.tikets.app.input;

import java.util.List;

import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.infra.input.dto.resp.DashboardResponse;
import com.disruptiv.tikets.infra.input.dto.resp.TiketResponse;
import com.disruptiv.tikets.infra.input.dto.resq.TiketCreateRequest;

public interface ITiketInputPort {
    TiketResponse crear(TiketCreateRequest request);

    List<TiketResponse> listar();

    List<TiketResponse> listarPorEstado(EnumEstado estado);

    TiketResponse asignarResponsable(Long ticketId, Long usuarioId);

    TiketResponse iniciarTrabajo(Long ticketId);

    TiketResponse resolver(Long ticketId);

    DashboardResponse obtenerDashboard();
}

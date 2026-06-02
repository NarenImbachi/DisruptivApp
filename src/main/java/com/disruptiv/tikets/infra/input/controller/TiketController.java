package com.disruptiv.tikets.infra.input.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disruptiv.tikets.app.input.ITiketInputPort;
import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.infra.input.dto.resp.ApiResponse;
import com.disruptiv.tikets.infra.input.dto.resp.DashboardResponse;
import com.disruptiv.tikets.infra.input.dto.resp.TiketResponse;
import com.disruptiv.tikets.infra.input.dto.resq.AsignarResponsableRequest;
import com.disruptiv.tikets.infra.input.dto.resq.TiketCreateRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TiketController {

    private final ITiketInputPort tiketInputPort;

    @PostMapping
    public ResponseEntity<ApiResponse<TiketResponse>> crear(@Valid @RequestBody TiketCreateRequest request) {

        return ResponseEntity.ok(ApiResponse.success(tiketInputPort.crear(request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TiketResponse>>> listar(@RequestParam(required = false) EnumEstado estado) {
        if (estado != null)
            return ResponseEntity.ok(ApiResponse.success(tiketInputPort.listarPorEstado(estado)));

        return ResponseEntity.ok(ApiResponse.success(tiketInputPort.listar()));
    }

    @PatchMapping("/{ticketId}/asignar")
    public ResponseEntity<ApiResponse<TiketResponse>> asignarResponsable(
            @PathVariable Long ticketId,
            @Valid @RequestBody AsignarResponsableRequest request) {

        return ResponseEntity.ok(ApiResponse.success(tiketInputPort.asignarResponsable(ticketId, request.getUsuarioId())));
    }

    @PatchMapping("/{ticketId}/iniciar")
    public ResponseEntity<ApiResponse<TiketResponse>> iniciarTrabajo(@PathVariable Long ticketId) {
        return ResponseEntity.ok(ApiResponse.success(tiketInputPort.iniciarTrabajo(ticketId)));
    }

    @PatchMapping("/{ticketId}/resolver")
    public ResponseEntity<ApiResponse<TiketResponse>> resolver(@PathVariable Long ticketId) {
        return ResponseEntity.ok(ApiResponse.success(tiketInputPort.resolver(ticketId)));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<ApiResponse<DashboardResponse>> dashboard() {
        return ResponseEntity.ok(ApiResponse.success(tiketInputPort.obtenerDashboard()));
    }
}

package com.disruptiv.tikets.infra.input.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disruptiv.tikets.app.input.IUsuarioInputPort;
import com.disruptiv.tikets.infra.input.dto.resp.ApiResponse;
import com.disruptiv.tikets.infra.input.dto.resp.UsuarioResponse;
import com.disruptiv.tikets.infra.input.dto.resq.UsuarioCreateRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioCController {

    private final IUsuarioInputPort usuarioInputPort;
    
    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioResponse>> crear(@Valid @RequestBody UsuarioCreateRequest request) {
        return ResponseEntity.ok(ApiResponse.success(usuarioInputPort.crear(request)));
    }
    
}

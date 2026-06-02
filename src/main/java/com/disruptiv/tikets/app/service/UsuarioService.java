package com.disruptiv.tikets.app.service;

import org.springframework.stereotype.Service;

import com.disruptiv.tikets.app.input.IUsuarioInputPort;
import com.disruptiv.tikets.app.out.IUsuarioOutputPort;
import com.disruptiv.tikets.domain.model.Usuario;
import com.disruptiv.tikets.infra.input.dto.resp.UsuarioResponse;
import com.disruptiv.tikets.infra.input.dto.resq.UsuarioCreateRequest;
import com.disruptiv.tikets.infra.input.mapper.UsuarioRestMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService implements IUsuarioInputPort{
    
    private final IUsuarioOutputPort usuarioOutputPort;
    private final UsuarioRestMapper usuarioRestMapper;
    
    @Override
    public UsuarioResponse crear(UsuarioCreateRequest request) {
        Usuario usuario = Usuario.crear(
            request.getNombre(),
            request.getEmail()
        );
        Usuario savedUsuario = usuarioOutputPort.guardar(usuario);
        return usuarioRestMapper.toResponse(savedUsuario);
    }
    
}

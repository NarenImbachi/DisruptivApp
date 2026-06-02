package com.disruptiv.tikets.infra.input.mapper;

import org.mapstruct.Mapper;

import com.disruptiv.tikets.domain.model.Usuario;
import com.disruptiv.tikets.infra.input.dto.resp.UsuarioResponse;
import com.disruptiv.tikets.infra.input.dto.resq.UsuarioCreateRequest;

@Mapper(componentModel = "spring")
public interface UsuarioRestMapper {
    
    UsuarioResponse toResponse(Usuario usuario);

    UsuarioCreateRequest toDomain(Usuario request);

}

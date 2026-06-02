package com.disruptiv.tikets.infra.out.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.disruptiv.tikets.domain.model.Usuario;
import com.disruptiv.tikets.infra.out.entidades.UsuarioEntity;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUsuarioEntityMapper {
    
    UsuarioEntity toEntity(Usuario usuario);
    Usuario toDomain(UsuarioEntity usuarioEntity);
    

}

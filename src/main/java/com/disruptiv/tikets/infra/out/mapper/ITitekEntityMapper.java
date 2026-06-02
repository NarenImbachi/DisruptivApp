package com.disruptiv.tikets.infra.out.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.disruptiv.tikets.domain.model.Tiket;
import com.disruptiv.tikets.infra.out.entidades.TiktekEntity;

@Mapper(componentModel = "spring")
public interface ITitekEntityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioAsig", source = "usuarioAsig")
    TiktekEntity toEntity(Tiket tiket);

    Tiket toDomain(TiktekEntity tiktekEntity);
}

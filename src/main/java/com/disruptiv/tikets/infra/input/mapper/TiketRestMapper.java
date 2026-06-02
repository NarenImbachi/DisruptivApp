package com.disruptiv.tikets.infra.input.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.disruptiv.tikets.domain.model.Tiket;
import com.disruptiv.tikets.infra.input.dto.resp.TiketResponse;

@Mapper(componentModel = "spring")
public interface TiketRestMapper {
    
    @Mapping(target = "usuarioId", source = "usuarioAsig.id")
    @Mapping(target = "nombreResponsable", source = "usuarioAsig.nombre")
    @Mapping(target = "emailResponsable", source = "usuarioAsig.email")
    TiketResponse toResponse(Tiket tiket);

    List<TiketResponse> toResponseList(List<Tiket> tikets);

}

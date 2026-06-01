package com.disruptiv.tikets.infra.out.mapper;

import org.mapstruct.Mapper;

import com.disruptiv.tikets.domain.model.Tiket;
import com.disruptiv.tikets.infra.out.entidades.TiktekEntity;

@Mapper(componentModel = "spring")
public interface TiktekEntityMapper {
    TiktekEntity toTiktekEntity(Tiket tiket);
    Tiket toTiktek(TiktekEntity tiktekEntity);
}

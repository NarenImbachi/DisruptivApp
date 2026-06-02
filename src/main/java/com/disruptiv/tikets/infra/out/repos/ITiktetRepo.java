package com.disruptiv.tikets.infra.out.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.infra.out.entidades.TiktekEntity;

public interface ITiktetRepo extends JpaRepository<TiktekEntity, Long> {
    List<TiktekEntity> findByEstado(EnumEstado estado);
}

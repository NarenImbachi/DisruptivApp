package com.disruptiv.tikets.infra.out.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disruptiv.tikets.infra.out.entidades.TiktekEntity;

public interface ITiktetRepo extends JpaRepository<TiktekEntity, Long> {
    
}

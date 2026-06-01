package com.disruptiv.tikets.infra.out.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.disruptiv.tikets.infra.out.entidades.UsuarioEntity;

public interface IUsuarioRepo extends JpaRepository<UsuarioEntity, Long> {
    
}

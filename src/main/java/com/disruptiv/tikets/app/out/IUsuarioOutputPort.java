package com.disruptiv.tikets.app.out;

import java.util.Optional;

import com.disruptiv.tikets.domain.model.Usuario;

public interface IUsuarioOutputPort {

    Optional<Usuario> buscarPorId(Long id);
}

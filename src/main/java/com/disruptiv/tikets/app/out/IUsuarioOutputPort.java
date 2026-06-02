package com.disruptiv.tikets.app.out;

import java.util.Optional;

import com.disruptiv.tikets.domain.model.Usuario;

public interface IUsuarioOutputPort {

    Usuario guardar(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);
}

package com.disruptiv.tikets.infra.out.apdater;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.disruptiv.tikets.app.out.IUsuarioOutputPort;
import com.disruptiv.tikets.domain.model.Usuario;
import com.disruptiv.tikets.infra.out.mapper.IUsuarioEntityMapper;
import com.disruptiv.tikets.infra.out.repos.IUsuarioRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuarioAdapter implements IUsuarioOutputPort {

    private final IUsuarioRepo usuarioRepo;
    private final IUsuarioEntityMapper mapper;

    @Override
    public Usuario guardar(Usuario usuario) {
        var entity = mapper.toEntity(usuario);
        var savedEntity = usuarioRepo.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepo.findById(id).map(mapper::toDomain);
    }
}

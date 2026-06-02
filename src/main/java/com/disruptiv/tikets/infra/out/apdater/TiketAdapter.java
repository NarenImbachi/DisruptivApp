package com.disruptiv.tikets.infra.out.apdater;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.disruptiv.tikets.app.out.ITiketOutputPort;
import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.domain.model.Tiket;
import com.disruptiv.tikets.infra.out.mapper.ITitekEntityMapper;
import com.disruptiv.tikets.infra.out.repos.ITiktetRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TiketAdapter implements ITiketOutputPort{

    private final ITiktetRepo tiketRepo;
    private final ITitekEntityMapper mapper;

    @Override
    public Tiket guardar(Tiket tiket) {
        return mapper.toDomain(tiketRepo.save(mapper.toEntity(tiket)));
    }

    @Override
    public Optional<Tiket> buscarPorId(Long id) {
        return tiketRepo.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Tiket> listar() {
        return tiketRepo.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<Tiket> listarPorEstado(EnumEstado estado) {
        return tiketRepo.findByEstado(estado).stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    
}

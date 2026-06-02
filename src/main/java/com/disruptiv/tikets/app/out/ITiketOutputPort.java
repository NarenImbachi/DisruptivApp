package com.disruptiv.tikets.app.out;

import java.util.List;
import java.util.Optional;

import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.domain.model.Tiket;

public interface ITiketOutputPort {

    Tiket guardar(Tiket tiket);
    
    Optional<Tiket> buscarPorId(Long id);

    List<Tiket> listar();

    List<Tiket> listarPorEstado(EnumEstado estado);
}

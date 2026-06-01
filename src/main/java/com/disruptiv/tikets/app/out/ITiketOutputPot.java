package com.disruptiv.tikets.app.out;

import java.util.List;

import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.domain.model.Tiket;
import com.disruptiv.tikets.infra.input.dto.resp.TiketResponse;

public interface ITiketOutputPot {
    TiketResponse save(Tiket tiket);
    TiketResponse findById(Long id);
    List<TiketResponse> findAll();
    List<TiketResponse> findByEstado(EnumEstado estado);
    TiketResponse update(Tiket tiket);
    TiketResponse assignTiket(Long id, Long usuarioId);
}

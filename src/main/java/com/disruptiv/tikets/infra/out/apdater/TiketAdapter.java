package com.disruptiv.tikets.infra.out.apdater;

import java.util.List;

import org.springframework.stereotype.Component;

import com.disruptiv.tikets.app.out.ITiketOutputPot;
import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.domain.model.Tiket;
import com.disruptiv.tikets.infra.input.dto.resp.TiketResponse;
import com.disruptiv.tikets.infra.out.repos.ITiktetRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TiketAdapter implements ITiketOutputPot{

    private final ITiktetRepo tiketRepo;

    @Override
    public TiketResponse save(Tiket tiket) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public TiketResponse findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<TiketResponse> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<TiketResponse> findByEstado(EnumEstado estado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEstado'");
    }

    @Override
    public TiketResponse update(Tiket tiket) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public TiketResponse assignTiket(Long id, Long usuarioId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assignTiket'");
    }
    
}

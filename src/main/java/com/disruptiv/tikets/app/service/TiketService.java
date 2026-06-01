package com.disruptiv.tikets.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disruptiv.tikets.app.input.ITiketInputPort;
import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.infra.input.dto.resp.TiketResponse;
import com.disruptiv.tikets.infra.input.dto.resq.TiketCreateRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TiketService implements ITiketInputPort {
    
    
    
    @Override
    public TiketResponse crearTiket(TiketCreateRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearTiket'");
    }

    @Override
    public List<TiketResponse> listarTikets() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTikets'");
    }

    @Override
    public List<TiketResponse> filtrarPorEstado(EnumEstado estado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filtrarPorEstado'");
    }

    @Override
    public TiketResponse cambiarEstado(Long id, EnumEstado nuevoEstado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarEstado'");
    }

    @Override
    public TiketResponse asignarTiket(Long id, Long usuarioId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarTiket'");
    }
    
}

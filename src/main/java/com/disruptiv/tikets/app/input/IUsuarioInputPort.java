package com.disruptiv.tikets.app.input;

import com.disruptiv.tikets.infra.input.dto.resp.UsuarioResponse;
import com.disruptiv.tikets.infra.input.dto.resq.UsuarioCreateRequest;

public interface IUsuarioInputPort {
    UsuarioResponse crear(UsuarioCreateRequest request);
}

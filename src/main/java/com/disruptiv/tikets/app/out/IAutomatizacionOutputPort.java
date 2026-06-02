package com.disruptiv.tikets.app.out;

import com.disruptiv.tikets.domain.model.Tiket;

public interface IAutomatizacionOutputPort {
    void ticketAsignado(Tiket tiket);
}

package com.disruptiv.tikets.infra.out.apdater;

import org.springframework.stereotype.Component;

import com.disruptiv.tikets.app.out.IAutomatizacionOutputPort;
import com.disruptiv.tikets.domain.model.Tiket;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AutomatizacionAdapter implements IAutomatizacionOutputPort {

    @Override
    public void ticketAsignado(Tiket tiket) {
        // Aquí podría implementar la lógica para enviar una notificación, pero hare un
        // log simple por ahora
        log.info("""
                ===== CORREO SIMULADO =====
                Ticket: {}
                Responsable: {}
                Correo: {}
                ==========================
                """,
                tiket.getTitulo(),
                tiket.getUsuarioAsig().getNombre(),
                tiket.getUsuarioAsig().getEmail());
    }

}

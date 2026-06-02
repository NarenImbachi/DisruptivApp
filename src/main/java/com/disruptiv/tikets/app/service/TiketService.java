package com.disruptiv.tikets.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disruptiv.tikets.app.input.ITiketInputPort;
import com.disruptiv.tikets.app.out.IAutomatizacionOutputPort;
import com.disruptiv.tikets.app.out.ITiketOutputPort;
import com.disruptiv.tikets.app.out.IUsuarioOutputPort;
import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.domain.enums.EnumPrioridad;
import com.disruptiv.tikets.domain.exception.ResourceNotFoundException;
import com.disruptiv.tikets.domain.model.Tiket;
import com.disruptiv.tikets.domain.model.Usuario;
import com.disruptiv.tikets.infra.input.dto.resp.DashboardResponse;
import com.disruptiv.tikets.infra.input.dto.resp.TiketResponse;
import com.disruptiv.tikets.infra.input.dto.resq.TiketCreateRequest;
import com.disruptiv.tikets.infra.input.mapper.TiketRestMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TiketService implements ITiketInputPort {

        private final ITiketOutputPort tiketOutputPort;
        private final IUsuarioOutputPort usuarioOutputPort;
        private final IAutomatizacionOutputPort automatizacionOutputPort;
        private final TiketRestMapper tiketRestMapper;

        @Override
        public TiketResponse crear(TiketCreateRequest request) {
                Tiket tiket = Tiket.crear(
                                request.getTitulo(),
                                request.getDescripcion(),
                                request.getPrioridad());

                tiket = tiketOutputPort.guardar(tiket);

                return tiketRestMapper.toResponse(tiket);
        }

        @Override
        public List<TiketResponse> listar() {
                List<Tiket> tikets = tiketOutputPort.listar();
                return tiketRestMapper.toResponseList(tikets);
        }

        @Override
        public List<TiketResponse> listarPorEstado(EnumEstado estado) {
                List<Tiket> tikets = tiketOutputPort.listarPorEstado(estado);
                return tiketRestMapper.toResponseList(tikets);
        }

        @Override
        public TiketResponse asignarResponsable(Long ticketId, Long usuarioId) {

                Tiket tiket = tiketOutputPort.buscarPorId(ticketId)
                                .orElseThrow(() -> new ResourceNotFoundException("Ticket no encontrado"));

                Usuario usuario = usuarioOutputPort.buscarPorId(usuarioId)
                                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

                tiket.asignarResponsable(usuario);

                tiket = tiketOutputPort.guardar(tiket);

                automatizacionOutputPort.ticketAsignado(tiket);

                return tiketRestMapper.toResponse(tiket);
        }

        @Override
        public TiketResponse iniciarTrabajo(Long ticketId) {

                Tiket tiket = tiketOutputPort.buscarPorId(ticketId)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "No existe el ticket con id: " + ticketId));

                tiket.iniciarTrabajo();

                tiket = tiketOutputPort.guardar(tiket);

                return tiketRestMapper.toResponse(tiket);
        }

        @Override
        public TiketResponse resolver(Long ticketId) {
                Tiket tiket = tiketOutputPort.buscarPorId(ticketId)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                                "No existe el ticket con id: " + ticketId));

                tiket.resolver();

                tiket = tiketOutputPort.guardar(tiket);

                return tiketRestMapper.toResponse(tiket);
        }

        @Override
        public DashboardResponse obtenerDashboard() {

                List<Tiket> tickets = tiketOutputPort.listar();

                long pendientes = tickets.stream()
                                .filter(Tiket::estaPendiente)
                                .count();

                long enProceso = tickets.stream()
                                .filter(Tiket::estaEnProceso)
                                .count();

                long resueltos = tickets.stream()
                                .filter(Tiket::estaResuelto)
                                .count();

                long prioridadBaja = tickets.stream()
                                .filter(t -> t.getPrioridad() == EnumPrioridad.LOW)
                                .count();

                long prioridadMedia = tickets.stream()
                                .filter(t -> t.getPrioridad() == EnumPrioridad.MEDIUM)
                                .count();

                long prioridadAlta = tickets.stream()
                                .filter(t -> t.getPrioridad() == EnumPrioridad.HIGH)
                                .count();

                return new DashboardResponse(
                                (long) tickets.size(),
                                pendientes,
                                enProceso,
                                resueltos,
                                prioridadBaja,
                                prioridadMedia,
                                prioridadAlta);
        }

}

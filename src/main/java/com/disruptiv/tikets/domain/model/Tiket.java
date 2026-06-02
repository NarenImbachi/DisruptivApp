package com.disruptiv.tikets.domain.model;

import java.time.LocalDateTime;

import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.domain.enums.EnumPrioridad;
import com.disruptiv.tikets.domain.exception.BusinessException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Tiket {

    private Long id;
    private String titulo;
    private String descripcion;
    private EnumEstado estado;
    private EnumPrioridad prioridad;
    private LocalDateTime fechaCreacion;
    private Usuario usuarioAsig;

    public static Tiket crear(
            String titulo,
            String descripcion,
            EnumPrioridad prioridad) {

        return new Tiket(null, titulo, descripcion, EnumEstado.PENDING, prioridad, LocalDateTime.now(), null);
    }

    public void asignarResponsable(Usuario usuario) {

        if (estaResuelto()) {
            throw new BusinessException(
                    "No es posible asignar responsables a tickets resueltos");
        }

        if (usuario == null)
            throw new BusinessException("Debe indicar un responsable");

        this.usuarioAsig = usuario;
    }

    public void iniciarTrabajo() {

        if (estado != EnumEstado.PENDING)
            throw new BusinessException("Solo los tickets pendientes pueden iniciar atención");

        if (usuarioAsig == null)
            throw new BusinessException("Debe existir un responsable asignado");

        this.estado = EnumEstado.IN_PROGRESS;
    }

    public void resolver() {

        if (estado != EnumEstado.IN_PROGRESS)
            throw new BusinessException("Solo los tickets en progreso pueden resolverse");

        this.estado = EnumEstado.RESOLVED;
    }

    public boolean estaPendiente() {
        return estado == EnumEstado.PENDING;
    }

    public boolean estaEnProceso() {
        return estado == EnumEstado.IN_PROGRESS;
    }

    public boolean estaResuelto() {
        return estado == EnumEstado.RESOLVED;
    }

    public boolean tieneResponsable() {
        return usuarioAsig != null;
    }
}

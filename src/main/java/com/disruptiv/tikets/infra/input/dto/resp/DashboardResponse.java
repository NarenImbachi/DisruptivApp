package com.disruptiv.tikets.infra.input.dto.resp;

/**
 * DashboardResponse es un record que encapsula las métricas 
 * clave para el dashboard de tickets, incluyendo el total de tickets, 
 * su estado (pendientes, en proceso, resueltos) y su prioridad (baja, media, alta). 
 * Este DTO se utiliza para transferir esta información de manera eficiente desde la capa de servicio a la capa de presentación.
 */
public record DashboardResponse(
        Long totalTickets,
        Long pendientes,
        Long enProceso,
        Long resueltos,
        Long prioridadBaja,
        Long prioridadMedia,
        Long prioridadAlta
) {
}

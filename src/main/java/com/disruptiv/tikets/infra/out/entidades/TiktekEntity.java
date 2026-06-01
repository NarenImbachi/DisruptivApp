package com.disruptiv.tikets.infra.out.entidades;

import java.time.LocalDate;

import com.disruptiv.tikets.domain.enums.EnumEstado;
import com.disruptiv.tikets.domain.enums.EnumPrioridad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tikteks")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TiktekEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumEstado estado;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumPrioridad prioridad;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuarioAsig;
}

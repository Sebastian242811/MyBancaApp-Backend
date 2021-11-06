package com.finanzas.tf.backend.MybancaApp.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "carteras")
public class Cartera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCartera;

    @NotNull
    private Date dCartera;

    //TODO: Esto no viene con la tabla Valor??
    //@NotNull
    //private String tipoCambio;

    @ManyToOne
    @JoinColumn(name = "idValor")
    private Valor valor;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idMovimiento")
    private Movimiento movimiento;

    @ManyToOne
    @JoinColumn(name = "idCalendario")
    private TipoCalendario tipoCalendario;

    @ManyToOne
    @JoinColumn(name = "idDescuento")
    private Descuento descuento;
}

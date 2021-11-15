package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.*;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CarteraPostDTO {

    @NotNull
    private Date dCartera;

    //TODO: Esto no viene con la tabla Valor??
    //@NotNull
    //private String tipoCambio;

    //private Valor valor;

    //private Usuario usuario;

    //private Movimiento movimiento;

    //private TipoCalendario tipoCalendario;

    //private Descuento descuento;

}

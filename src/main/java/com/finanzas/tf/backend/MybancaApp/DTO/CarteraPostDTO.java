package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Component
public class CarteraPostDTO {

    @NotNull
    private Date dCartera;

    //TODO: Esto no viene con la tabla Valor??
    //@NotNull
    //private String tipoCambio;

    private Integer idValor;

    private Integer idUsuario;

    private Integer idMovimiento;

    private Integer idCalendario;

    private Integer idDescuento;

    public Cartera toEntity(){
        Cartera cartera = new Cartera();
        cartera.setDCartera(this.getDCartera());
        return cartera;
    }

}

package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CarteraDTO {

    private Integer idCartera;

    private Date dCartera;

    //TODO: Esto no viene con la tabla Valor??
    //@NotNull
    //private String tipoCambio;

    public CarteraDTO(Cartera cartera){
        this.idCartera=cartera.getIdCartera();
        this.dCartera=cartera.getDCartera();
    }
}

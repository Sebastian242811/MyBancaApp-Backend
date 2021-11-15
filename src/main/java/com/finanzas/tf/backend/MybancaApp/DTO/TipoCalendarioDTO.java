package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.TipoCalendario;
import lombok.Data;

@Data
public class TipoCalendarioDTO {

    private Integer idCalendario;

    private String nombreCalendario;

    public TipoCalendarioDTO(TipoCalendario tipoCalendario){
        this.idCalendario=tipoCalendario.getIdCalendario();
        this.nombreCalendario=tipoCalendario.getNombreCalendario();
    }
}

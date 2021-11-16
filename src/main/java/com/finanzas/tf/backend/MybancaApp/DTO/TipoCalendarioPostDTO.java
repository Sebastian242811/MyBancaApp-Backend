package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.TipoCalendario;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Component
public class TipoCalendarioPostDTO {
    @NotNull
    private String nombreCalendario;

    public TipoCalendario toEntity(){
        TipoCalendario tipoCalendario = new TipoCalendario();
        tipoCalendario.setNombreCalendario(this.nombreCalendario);
        return tipoCalendario;
    }
}

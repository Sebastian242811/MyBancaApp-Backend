package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Moneda;
import lombok.Data;

@Data
public class MonedaDTO {
    private Integer idMoneda;

    private String tipoMoneda;

    public MonedaDTO(Moneda moneda){
        this.setIdMoneda(moneda.getIdMoneda());
        this.setTipoMoneda(moneda.getTipoMoneda());
    }
}

package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Descuento;
import lombok.Data;

@Data
public class DescuentoDTO {

    private Integer idDescuento;

    private Double MontoFinanciar;

    private String tipoDescuento;

    private TasaDTO tasa;

    public DescuentoDTO(Descuento descuento){
        this.setIdDescuento(descuento.getIdDescuento());
        this.setMontoFinanciar(descuento.getMontoFinanciar());
        this.setTipoDescuento(descuento.getTipoDescuento());
        this.setTasa(new TasaDTO(descuento.getTasa()));
    }
}

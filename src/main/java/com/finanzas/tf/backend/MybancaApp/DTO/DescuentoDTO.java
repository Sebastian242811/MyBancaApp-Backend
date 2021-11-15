package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Descuento;
import lombok.Data;

@Data
public class DescuentoDTO {

    private Integer idDescuento;

    private Double MontoFinanciar;

    private String tipoDescuento;

    private TasaDTO tasaDTO;

    public DescuentoDTO(Descuento descuento){
        TasaDTO tasaDTO= new TasaDTO(descuento.getTasa());
        this.setIdDescuento(descuento.getIdDescuento());
        this.setMontoFinanciar(descuento.getMontoFinanciar());
        this.setTipoDescuento(descuento.getTipoDescuento());
        this.setTasaDTO(tasaDTO);
    }
}

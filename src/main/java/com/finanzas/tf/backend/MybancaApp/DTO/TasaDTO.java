package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Tasa;
import lombok.Data;

@Data
public class TasaDTO {

    private Integer idTasa;

    private String nombreTasa;

    private String tipoTasa;

    private Double valorTasa;

    private Integer capitalizacionTasa;

    public TasaDTO(Tasa tasa){
        this.setIdTasa(tasa.getIdTasa());
        this.setNombreTasa(tasa.getNombreTasa());
        this.setTipoTasa(tasa.getTipoTasa());
        this.setValorTasa(tasa.getValorTasa());
        this.setCapitalizacionTasa(tasa.getCapitalizacionTasa());
    }
}

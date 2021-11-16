package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Tasa;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Component
public class TasaPostDTO {
    @Length(max = 30, message = "El nombre de la tasa debe tener maxiomo 30 caracteres")
    @NotNull
    private String nombreTasa;

    @Length(max = 30, message = "El tipo de la tasa debe tener maxiomo 30 caracteres")
    @NotNull
    private String tipoTasa;

    @NotNull
    private Double valorTasa;

    @NotNull
    private Integer capitalizacionTasa;

    public Tasa ToEntity(){
        Tasa tasa = new Tasa();
        tasa.setNombreTasa(this.nombreTasa);
        tasa.setTipoTasa(this.tipoTasa);
        tasa.setValorTasa(this.valorTasa);
        tasa.setCapitalizacionTasa(this.capitalizacionTasa);
        return tasa;
    }
}

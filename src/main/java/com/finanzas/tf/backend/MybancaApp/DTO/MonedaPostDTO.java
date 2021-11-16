package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Moneda;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Component
public class MonedaPostDTO {
    @Length(max = 10,message = "el tipo de moneda no debe tener mas de 10 caracteres")
    @NotNull
    private String tipoMoneda;

    public Moneda toEntity(){
        Moneda moneda = new Moneda();
        moneda.setTipoMoneda(this.tipoMoneda);
        return moneda;
    }
}

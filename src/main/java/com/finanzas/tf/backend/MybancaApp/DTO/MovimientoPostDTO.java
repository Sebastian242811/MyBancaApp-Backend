package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Movimiento;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Component
public class MovimientoPostDTO {
    @Length(max = 30,message = "el tipo de movimiento no debe tener mas de 30 caracteres")
    @NotNull
    private String tipoMovimiento;

    public Movimiento toEntity(){
        Movimiento movimiento = new Movimiento();
        movimiento.setTipoMovimiento(this.tipoMovimiento);
        return movimiento;
    }
}

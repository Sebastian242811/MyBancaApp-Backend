package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Movimiento;
import lombok.Data;

@Data
public class MovimientoDTO {
    private Integer idMovimiento;

    private String tipoMovimiento;

    public MovimientoDTO(Movimiento movimiento){
        this.setIdMovimiento(movimiento.getIdMovimiento());
        this.setTipoMovimiento(movimiento.getTipoMovimiento());
    }
}

package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CarteraDTO {

    private Integer idCartera;

    private Date dCartera;

    //TODO: Esto no viene con la tabla Valor??
    //@NotNull
    //private String tipoCambio;

    private ValorDTO valor;

    private UsuarioDTO usuario;

    private MovimientoDTO movimiento;

    private TipoCalendarioDTO calendario;

    private DescuentoDTO descuento;

    public CarteraDTO(Cartera cartera){
        this.idCartera=cartera.getIdCartera();
        this.dCartera=cartera.getDCartera();
        this.valor=new ValorDTO(cartera.getValor());
        this.usuario=new UsuarioDTO(cartera.getUsuario());
        this.movimiento=new MovimientoDTO(cartera.getMovimiento());
        this.calendario=new TipoCalendarioDTO(cartera.getTipoCalendario());
        this.descuento=new DescuentoDTO(cartera.getDescuento());
    }
}

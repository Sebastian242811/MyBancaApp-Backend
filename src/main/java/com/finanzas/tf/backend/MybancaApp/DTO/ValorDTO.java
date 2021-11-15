package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Valor;
import lombok.Data;
import java.util.Date;

@Data
public class ValorDTO {
    private Integer idValor;

    private String tipoValor;

    //TODO: Verificar rol de nombreEmisor??
    //private String nombreEmisor;

    private Date dEmision;

    private Date dVencimiento;

    private Double numeroImporte;

    private String tipoStatus;

    private ClienteDTO clienteDTO;

    private MonedaDTO monedaDTO;

    public ValorDTO(Valor valor){
        this.setIdValor(valor.getIdValor());
        this.setTipoValor(valor.getTipoValor());
        this.setDEmision(valor.getDEmision());
        this.setDVencimiento(valor.getDVencimiento());
        this.setNumeroImporte(valor.getNumeroImporte());
        this.setTipoStatus(valor.getTipoStatus());
        this.setClienteDTO(new ClienteDTO(valor.getCliente()));
        this.setMonedaDTO(new MonedaDTO(valor.getMoneda()));
    }
}

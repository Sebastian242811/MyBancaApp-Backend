package com.finanzas.tf.backend.MybancaApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finanzas.tf.backend.MybancaApp.models.Cliente;
import com.finanzas.tf.backend.MybancaApp.models.Moneda;
import com.finanzas.tf.backend.MybancaApp.models.Valor;
import com.finanzas.tf.backend.MybancaApp.repositories.ClienteRepository;
import com.finanzas.tf.backend.MybancaApp.repositories.MonedaRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@JsonIgnoreProperties(value = {"clienteRepository","monedaRepository"})
public class ValorPostDTO {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MonedaRepository monedaRepository;

    @Length(max = 30,message = "el tipo de valor no debe tener mas de 30 caracteres")
    @NotNull
    private String tipoValor;

    //TODO: Verificar rol de nombreEmisor??
    //private String nombreEmisor;

    @NotNull
    private Date dEmision;

    @NotNull
    private Date dVencimiento;

    @NotNull
    private Double numeroImporte;

    @Length(max = 25,message = "El tipo status no debe tener mas de 25 caracteres")
    @NotNull
    private String tipoStatus;

    private Integer idCliente;

    private Integer idMoneda;

    public Valor toEntity(){
        Valor valor = new Valor();
        valor.setTipoValor(this.tipoValor);
        valor.setDEmision(this.dEmision);
        valor.setDVencimiento(this.dVencimiento);
        valor.setNumeroImporte(this.numeroImporte);
        valor.setTipoStatus(this.tipoStatus);
        valor.setCliente(clienteRepository.getById(this.idCliente));
        valor.setMoneda(monedaRepository.getById(this.idMoneda));
        return valor;
    }
}

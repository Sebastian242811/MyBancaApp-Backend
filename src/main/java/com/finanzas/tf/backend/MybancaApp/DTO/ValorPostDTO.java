package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Valor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ValorPostDTO {

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
        return valor;
    }
}

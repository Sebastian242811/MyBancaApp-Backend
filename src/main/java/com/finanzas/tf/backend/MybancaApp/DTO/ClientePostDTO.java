package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Cliente;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class ClientePostDTO {

    @Length(max = 50, message = "el nombre del cliente no debe tener mas de 50 caracteres")
    @NotNull
    private String nCliente;

    public Cliente toEntity(){
        Cliente cliente = new Cliente();
        cliente.setNCliente(this.getNCliente());
        return cliente;
    }
}

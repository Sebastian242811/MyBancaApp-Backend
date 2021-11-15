package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Cliente;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ClienteDTO {

    private Integer idCliente;

    private String nCliente;

    public ClienteDTO(Cliente cliente){
        this.setIdCliente(cliente.getIdCliente());
        this.setNCliente(cliente.getNCliente());
    }
}

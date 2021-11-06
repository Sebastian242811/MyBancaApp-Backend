package com.finanzas.tf.backend.MybancaApp.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Length(max = 30, message = "el nombre del cliente no debe tener mas de 30 caracteres")
    private Integer nCliente;

    @OneToMany(mappedBy = "cliente")
    private List<Valor> valores;

    public Cliente(){
        this.valores = new ArrayList<>();
    }
}

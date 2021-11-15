package com.finanzas.tf.backend.MybancaApp.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Length(max = 50, message = "el nombre del cliente no debe tener mas de 50 caracteres")
    @NotNull
    private String nCliente;

    @OneToMany(mappedBy = "cliente")
    private List<Valor> valores;

    public Cliente(){
        this.valores = new ArrayList<>();
    }
}

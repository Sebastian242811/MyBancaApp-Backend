package com.finanzas.tf.backend.MybancaApp.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "monedas")
public class Moneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMoneda;

    @Length(max = 10,message = "el tipo de moneda no debe tener mas de 10 caracteres")
    @NotNull
    private String tipoMoneda;

    //TODO:En que se diferencia del de arriba?
    //private String nameMoneda;

    @OneToMany(mappedBy = "moneda")
    private List<Valor> valores;

    public Moneda(){
        this.valores=new ArrayList<>();
    }
}

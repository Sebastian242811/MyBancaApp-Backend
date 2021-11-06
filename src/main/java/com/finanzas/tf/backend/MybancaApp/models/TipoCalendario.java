package com.finanzas.tf.backend.MybancaApp.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tipos_calendarios")
public class TipoCalendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalendario;

    @Length(max = 30, message = "el nombre de calendario no debe tener mas de 30 caracteres")
    @NotNull
    private String nombreCalendario;

    @OneToMany(mappedBy = "tipoCalendario")
    private List<Cartera> carteras;

    public TipoCalendario(){
        this.carteras = new ArrayList<>();
    }
}

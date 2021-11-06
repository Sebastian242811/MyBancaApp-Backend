package com.finanzas.tf.backend.MybancaApp.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tasas")
public class Tasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTasa;

    @Length(max = 30, message = "El nombre de la tasa debe tener maxiomo 30 caracteres")
    @NotNull
    private String nombreTasa;

    @Length(max = 30, message = "El tipo de la tasa debe tener maxiomo 30 caracteres")
    @NotNull
    private String tipoTasa;

    @NotNull
    private Double valorTasa;

    @NotNull
    private Integer capitalizacionTasa;

    @OneToMany(mappedBy = "tasa")
    private List<Descuento> descuentos;

    public Tasa(){
        this.descuentos = new ArrayList<>();
    }
}

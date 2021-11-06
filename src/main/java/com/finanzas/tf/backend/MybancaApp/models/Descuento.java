package com.finanzas.tf.backend.MybancaApp.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "descuentos")
public class Descuento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDescuento;

    @NotNull
    private Double MontoFinanciar;

    @Length(max = 30, message = "el tipo de descuento no debe tener mas de 30 caracteres")
    @NotNull
    private String tipoDescuento;

    @OneToMany(mappedBy = "descuento")
    private List<Cartera> carteras;

    @ManyToOne
    @JoinColumn(name = "idTasa")
    private Tasa tasa;

    public Descuento(){
        this.carteras = new ArrayList<>();
    }
}

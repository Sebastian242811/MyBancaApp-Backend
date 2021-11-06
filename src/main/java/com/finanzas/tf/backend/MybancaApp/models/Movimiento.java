package com.finanzas.tf.backend.MybancaApp.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "movimientos")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimiento;

    @Length(max = 30,message = "el tipo de movimiento no debe tener mas de 30 caracteres")
    @NotNull
    private String tipoMovimiento;

    @OneToMany(mappedBy = "movimiento")
    private List<Cartera> carteras;

    public Movimiento(){
        this.carteras=new ArrayList<>();
    }
}

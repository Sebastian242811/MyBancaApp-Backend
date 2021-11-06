package com.finanzas.tf.backend.MybancaApp.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "valores")
public class Valor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idValor;

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

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idMoneda")
    private Moneda moneda;

    @OneToMany(mappedBy = "valor")
    private List<Cartera> carteras;

    public Valor(){
        this.carteras=new ArrayList<>();
    }
}

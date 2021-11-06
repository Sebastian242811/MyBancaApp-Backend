package com.finanzas.tf.backend.MybancaApp.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Max(value = 25,message = "El nombre completo no debe de pasar los 25 caractere")
    @NotNull
    private String nombreCompleto;

    @Email(message = "Ingrese un email valido")
    @NotNull
    private String email;

    @Length(max = 8,min = 8, message = "El dni debe tener 8 caracteres")
    @NotNull
    private String DNI;

    //TODO: Agregar password(Spring Security)

    @OneToMany(mappedBy = "usuario")
    private List<Cartera> carteras;

    public Usuario(){
        this.carteras=new ArrayList<>();
    }
}

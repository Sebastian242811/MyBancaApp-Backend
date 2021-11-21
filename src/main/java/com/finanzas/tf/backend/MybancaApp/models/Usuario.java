package com.finanzas.tf.backend.MybancaApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Length(max = 25,message = "El nombre completo no debe de pasar los 25 caractere")
    @NotNull
    private String nombreCompleto;

    @Email(message = "Ingrese un email valido")
    @NotNull
    private String email;

    @Length(max = 8,min = 8, message = "El dni debe tener 8 caracteres")
    @NotNull
    private String DNI;

    @Length(max = 20,message = "El nombre de usuario no debe tener mas de 20 caracteres")
    @NotNull
    private String usuario;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Cartera> carteras = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rol> roles = new ArrayList<>();

}

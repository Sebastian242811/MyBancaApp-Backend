package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UsuarioPostDTO {

    @Length(max = 25,message = "El nombre completo no debe de pasar los 25 caractere")
    @NotNull
    private String nombreCompleto;

    @Email(message = "Ingrese un email valido")
    @NotNull
    private String email;

    @Length(max = 8,min = 8, message = "El dni debe tener 8 caracteres")
    @NotNull
    private String DNI;

    public Usuario toEntity(){
        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(this.nombreCompleto);
        usuario.setEmail(this.email);
        usuario.setDNI(this.DNI);
        return usuario;
    }
}

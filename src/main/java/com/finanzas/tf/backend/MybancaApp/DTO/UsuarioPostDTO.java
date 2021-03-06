package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Component
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

    @Length(max = 20,message = "El nombre de usuario no debe tener mas de 20 caracteres")
    @NotNull
    private String usuario;

    @Length(max = 20,message = "La contraseña no puede tener mas de 20 caracteres")
    @NotNull
    private String password;

    public Usuario toEntity(){
        Usuario usuario = new Usuario();
        usuario.setNombreCompleto(this.nombreCompleto);
        usuario.setEmail(this.email);
        usuario.setDNI(this.DNI);
        usuario.setPassword(this.password);
        usuario.setUsuario(this.usuario);
        return usuario;
    }
}

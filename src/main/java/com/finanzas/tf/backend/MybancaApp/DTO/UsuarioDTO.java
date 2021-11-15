package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Integer idUsuario;

    private String nombreCompleto;

    private String email;

    private String DNI;

    public UsuarioDTO(Usuario usuario){
        this.setIdUsuario(usuario.getIdUsuario());
        this.setNombreCompleto(usuario.getNombreCompleto());
        this.setEmail(usuario.getEmail());
        this.setDNI(usuario.getDNI());
    }
}

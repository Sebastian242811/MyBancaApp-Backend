package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Rol;
import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioDTO {

    private Integer idUsuario;

    private String nombreCompleto;

    private String email;

    private String DNI;

    private String usuario;

    private List<Rol> roles;

    public UsuarioDTO(Usuario usuario){
        this.setIdUsuario(usuario.getIdUsuario());
        this.setNombreCompleto(usuario.getNombreCompleto());
        this.setEmail(usuario.getEmail());
        this.setDNI(usuario.getDNI());
        this.setUsuario(usuario.getUsuario());
        this.setRoles(usuario.getRoles());
    }
}

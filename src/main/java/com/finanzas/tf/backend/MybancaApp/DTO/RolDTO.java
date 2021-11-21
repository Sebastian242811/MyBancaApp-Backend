package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Rol;
import lombok.Data;

@Data
public class RolDTO {

    private Integer idRol;

    private String nombre;

    public RolDTO(Rol rol){
        this.setIdRol(rol.getIdRol());
        this.setNombre(rol.getNombre());
    }
}

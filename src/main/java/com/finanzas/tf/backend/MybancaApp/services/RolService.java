package com.finanzas.tf.backend.MybancaApp.services;

import com.finanzas.tf.backend.MybancaApp.DTO.RolDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.UsuarioDTO;
import com.finanzas.tf.backend.MybancaApp.models.Rol;

public interface RolService extends CRUDService<Rol,Integer>{

    public Rol findByNombre(String nombre);
    public UsuarioDTO addRolToUser(Integer idUsuario, Integer idRol);
}

package com.finanzas.tf.backend.MybancaApp.services;

import com.finanzas.tf.backend.MybancaApp.models.Usuario;

public interface UsuarioService extends CRUDService<Usuario,Integer>{
    Usuario findByUsuario(String usuario);
}

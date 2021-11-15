package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import com.finanzas.tf.backend.MybancaApp.repositories.UsuarioRepository;
import com.finanzas.tf.backend.MybancaApp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() throws Exception {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) throws Exception {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) throws Exception {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Integer idUsuario) throws Exception {
        usuarioRepository.deleteById(idUsuario);
    }

    @Override
    public Optional<Usuario> findById(Integer idUsuario) throws Exception {
        return usuarioRepository.findById(idUsuario);
    }
}

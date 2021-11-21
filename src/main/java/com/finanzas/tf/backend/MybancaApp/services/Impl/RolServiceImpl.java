package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.DTO.UsuarioDTO;
import com.finanzas.tf.backend.MybancaApp.models.Rol;
import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import com.finanzas.tf.backend.MybancaApp.repositories.RolRepository;
import com.finanzas.tf.backend.MybancaApp.repositories.UsuarioRepository;
import com.finanzas.tf.backend.MybancaApp.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Rol> findAll() throws Exception {
        return rolRepository.findAll();
    }

    @Override
    public Rol save(Rol rol) throws Exception {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Rol rol) throws Exception {
        return rolRepository.save(rol);
    }

    @Override
    public void deleteById(Integer idRol) throws Exception {
        rolRepository.deleteById(idRol);
    }

    @Override
    public Optional<Rol> findById(Integer idRol) throws Exception {
        return rolRepository.findById(idRol);
    }

    @Override
    public Rol findByNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }

    @Override
    public UsuarioDTO addRolToUser(Integer idUsuario, Integer idRol) {
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        Rol rol = rolRepository.findById(idRol).get();
        usuario.getRoles().add(rol);
        usuarioRepository.save(usuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
        return usuarioDTO;
    }
}

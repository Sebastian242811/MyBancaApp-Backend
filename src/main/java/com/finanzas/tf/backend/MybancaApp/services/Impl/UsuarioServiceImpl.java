package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import com.finanzas.tf.backend.MybancaApp.repositories.UsuarioRepository;
import com.finanzas.tf.backend.MybancaApp.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsuario(username);
        if (usuario == null){
            throw  new UsernameNotFoundException("Usuario no encontrado en la base de datos");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(rol -> {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        });
        return new org.springframework.security.core.userdetails.User(usuario.getUsuario(), usuario.getPassword(), authorities);
    }

    @Override
    public List<Usuario> findAll() throws Exception {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario usuario) throws Exception {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
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

    @Override
    public Usuario findByUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }
}

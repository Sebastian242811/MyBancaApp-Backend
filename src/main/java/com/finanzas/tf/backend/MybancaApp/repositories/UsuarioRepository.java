package com.finanzas.tf.backend.MybancaApp.repositories;

import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}

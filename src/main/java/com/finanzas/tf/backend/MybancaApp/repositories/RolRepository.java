package com.finanzas.tf.backend.MybancaApp.repositories;

import com.finanzas.tf.backend.MybancaApp.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {

    Rol findByNombre(String nombre);
}

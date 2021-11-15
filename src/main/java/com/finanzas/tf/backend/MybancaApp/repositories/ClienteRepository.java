package com.finanzas.tf.backend.MybancaApp.repositories;

import com.finanzas.tf.backend.MybancaApp.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}

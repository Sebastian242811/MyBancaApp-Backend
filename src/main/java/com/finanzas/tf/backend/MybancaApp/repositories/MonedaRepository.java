package com.finanzas.tf.backend.MybancaApp.repositories;

import com.finanzas.tf.backend.MybancaApp.models.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda,Integer> {
}

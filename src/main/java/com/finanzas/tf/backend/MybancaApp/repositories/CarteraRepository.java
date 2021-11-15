package com.finanzas.tf.backend.MybancaApp.repositories;

import com.finanzas.tf.backend.MybancaApp.models.Cartera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteraRepository extends JpaRepository<Cartera,Integer> {
}

package com.finanzas.tf.backend.MybancaApp.services;

import java.util.List;
import java.util.Optional;

public interface CRUDService<T, ID> {
    List<T> findAll() throws Exception;
    T save( T t ) throws Exception;
    T update( T t ) throws Exception;
    void deleteById( ID id ) throws Exception;
    Optional<T> findById(ID id) throws  Exception;
}

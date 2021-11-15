package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.models.Valor;
import com.finanzas.tf.backend.MybancaApp.repositories.ValorRepository;
import com.finanzas.tf.backend.MybancaApp.services.ValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValorServiceImpl implements ValorService {

    @Autowired
    private ValorRepository valorRepository;

    @Override
    public List<Valor> findAll() throws Exception {
        return valorRepository.findAll();
    }

    @Override
    public Valor save(Valor valor) throws Exception {
        return valorRepository.save(valor);
    }

    @Override
    public Valor update(Valor valor) throws Exception {
        return valorRepository.save(valor);
    }

    @Override
    public void deleteById(Integer idValor) throws Exception {
        valorRepository.deleteById(idValor);
    }

    @Override
    public Optional<Valor> findById(Integer idValor) throws Exception {
        return valorRepository.findById(idValor);
    }
}

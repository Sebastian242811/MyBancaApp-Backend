package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.models.Moneda;
import com.finanzas.tf.backend.MybancaApp.repositories.MonedaRepository;
import com.finanzas.tf.backend.MybancaApp.services.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaServiceImpl implements MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    public List<Moneda> findAll() throws Exception {
        return monedaRepository.findAll();
    }

    @Override
    public Moneda save(Moneda moneda) throws Exception {
        return monedaRepository.save(moneda);
    }

    @Override
    public Moneda update(Moneda moneda) throws Exception {
        return monedaRepository.save(moneda);
    }

    @Override
    public void deleteById(Integer idMoneda) throws Exception {
        monedaRepository.deleteById(idMoneda);
    }

    @Override
    public Optional<Moneda> findById(Integer idMoneda) throws Exception {
        return monedaRepository.findById(idMoneda);
    }
}

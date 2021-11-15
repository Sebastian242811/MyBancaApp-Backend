package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.models.Descuento;
import com.finanzas.tf.backend.MybancaApp.repositories.DescuentoRepository;
import com.finanzas.tf.backend.MybancaApp.services.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DescuentoServiceImpl implements DescuentoService {

    @Autowired
    private DescuentoRepository descuentoRepository;

    @Override
    public List<Descuento> findAll() throws Exception {
        return descuentoRepository.findAll();
    }

    @Override
    public Descuento save(Descuento descuento) throws Exception {
        return descuentoRepository.save(descuento);
    }

    @Override
    public Descuento update(Descuento descuento) throws Exception {
        return descuentoRepository.save(descuento);
    }

    @Override
    public void deleteById(Integer idDescuento) throws Exception {
        descuentoRepository.deleteById(idDescuento);
    }

    @Override
    public Optional<Descuento> findById(Integer idDescuento) throws Exception {
        return descuentoRepository.findById(idDescuento);
    }
}

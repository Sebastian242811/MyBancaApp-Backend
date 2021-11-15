package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.models.Movimiento;
import com.finanzas.tf.backend.MybancaApp.repositories.MovimientoRepository;
import com.finanzas.tf.backend.MybancaApp.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public List<Movimiento> findAll() throws Exception {
        return movimientoRepository.findAll();
    }

    @Override
    public Movimiento save(Movimiento movimiento) throws Exception {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public Movimiento update(Movimiento movimiento) throws Exception {
        return movimientoRepository.save(movimiento);
    }

    @Override
    public void deleteById(Integer idMovimiento) throws Exception {
        movimientoRepository.deleteById(idMovimiento);
    }

    @Override
    public Optional<Movimiento> findById(Integer idMovimiento) throws Exception {
        return movimientoRepository.findById(idMovimiento);
    }
}

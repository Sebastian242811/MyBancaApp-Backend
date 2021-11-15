package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.models.Cartera;
import com.finanzas.tf.backend.MybancaApp.repositories.CarteraRepository;
import com.finanzas.tf.backend.MybancaApp.services.CarteraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteraServiceImpl implements CarteraService {

    @Autowired
    private CarteraRepository carteraRepository;

    @Override
    public List<Cartera> findAll() throws Exception {
        return carteraRepository.findAll();
    }

    @Override
    public Cartera save(Cartera cartera) throws Exception {
        return carteraRepository.save(cartera);
    }

    @Override
    public Cartera update(Cartera cartera) throws Exception {
        return carteraRepository.save(cartera);
    }

    @Override
    public void deleteById(Integer idCartera) throws Exception {
        carteraRepository.deleteById(idCartera);
    }

    @Override
    public Optional<Cartera> findById(Integer idCartera) throws Exception {
        return carteraRepository.findById(idCartera);
    }
}

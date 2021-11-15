package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.models.Tasa;
import com.finanzas.tf.backend.MybancaApp.repositories.TasaRepository;
import com.finanzas.tf.backend.MybancaApp.services.TasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasaServiceImpl implements TasaService {

    @Autowired
    private TasaRepository tasaRepository;

    @Override
    public List<Tasa> findAll() throws Exception {
        return tasaRepository.findAll();
    }

    @Override
    public Tasa save(Tasa tasa) throws Exception {
        return tasaRepository.save(tasa);
    }

    @Override
    public Tasa update(Tasa tasa) throws Exception {
        return tasaRepository.save(tasa);
    }

    @Override
    public void deleteById(Integer idTasa) throws Exception {
        tasaRepository.deleteById(idTasa);
    }

    @Override
    public Optional<Tasa> findById(Integer idTasa) throws Exception {
        return tasaRepository.findById(idTasa);
    }
}

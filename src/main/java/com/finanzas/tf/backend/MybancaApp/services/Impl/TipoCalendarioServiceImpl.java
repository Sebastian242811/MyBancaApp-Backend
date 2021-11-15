package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.models.TipoCalendario;
import com.finanzas.tf.backend.MybancaApp.repositories.TipoCalendarioRepository;
import com.finanzas.tf.backend.MybancaApp.services.TipoCalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCalendarioServiceImpl implements TipoCalendarioService {

    @Autowired
    private TipoCalendarioRepository tipoCalendarioRepository;

    @Override
    public List<TipoCalendario> findAll() throws Exception {
        return tipoCalendarioRepository.findAll();
    }

    @Override
    public TipoCalendario save(TipoCalendario tipoCalendario) throws Exception {
        return tipoCalendarioRepository.save(tipoCalendario);
    }

    @Override
    public TipoCalendario update(TipoCalendario tipoCalendario) throws Exception {
        return tipoCalendarioRepository.save(tipoCalendario);
    }

    @Override
    public void deleteById(Integer idCalendario) throws Exception {
        tipoCalendarioRepository.deleteById(idCalendario);
    }

    @Override
    public Optional<TipoCalendario> findById(Integer idCalendario) throws Exception {
        return tipoCalendarioRepository.findById(idCalendario);
    }
}

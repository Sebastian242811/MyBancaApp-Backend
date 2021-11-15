package com.finanzas.tf.backend.MybancaApp.services.Impl;

import com.finanzas.tf.backend.MybancaApp.models.Cliente;
import com.finanzas.tf.backend.MybancaApp.repositories.ClienteRepository;
import com.finanzas.tf.backend.MybancaApp.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() throws Exception {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) throws Exception {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) throws Exception {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Integer idCliente) throws Exception {
        clienteRepository.deleteById(idCliente);
    }

    @Override
    public Optional<Cliente> findById(Integer idCliente) throws Exception {
        return clienteRepository.findById(idCliente);
    }
}

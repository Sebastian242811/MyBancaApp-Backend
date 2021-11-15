package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.ClienteDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.ClientePostDTO;
import com.finanzas.tf.backend.MybancaApp.models.Cliente;
import com.finanzas.tf.backend.MybancaApp.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> getAll() throws Exception{
        return clienteService.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public ClienteDTO createCliente(@RequestBody()ClientePostDTO clientePostDTO) throws Exception{
        Cliente cliente = clientePostDTO.toEntity();
        ClienteDTO clienteDTO = new ClienteDTO(clienteService.save(cliente));
        return clienteDTO;
    }

}

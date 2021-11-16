package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.ValorDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.ValorPostDTO;
import com.finanzas.tf.backend.MybancaApp.models.Valor;
import com.finanzas.tf.backend.MybancaApp.services.ClienteService;
import com.finanzas.tf.backend.MybancaApp.services.MonedaService;
import com.finanzas.tf.backend.MybancaApp.services.ValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/valor")
public class ValorController {

    @Autowired
    private ValorService valorService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MonedaService monedaService;

    @GetMapping
    public List<ValorDTO> getAll()throws Exception{
        return valorService.findAll().stream().map(ValorDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public ValorDTO createValor(@RequestBody()ValorPostDTO valorPostDTO)throws Exception{
        Valor valor = valorPostDTO.toEntity();
        valor.setCliente(clienteService.findById(valorPostDTO.getIdCliente()).get());
        valor.setMoneda(monedaService.findById(valorPostDTO.getIdMoneda()).get());
        ValorDTO valorDTO = new ValorDTO(valorService.save(valor));
        return valorDTO;
    }

    @DeleteMapping("{id}")
    public void deleteValor(@PathVariable() Integer id) throws Exception{
        valorService.deleteById(id);
    }
}

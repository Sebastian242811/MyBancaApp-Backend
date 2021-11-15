package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.MonedaDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.MonedaPostDTO;
import com.finanzas.tf.backend.MybancaApp.models.Moneda;
import com.finanzas.tf.backend.MybancaApp.services.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/moneda")
public class MonedaController {

    @Autowired
    private MonedaService monedaService;

    @GetMapping
    public List<MonedaDTO> getAll()throws Exception{
        return monedaService.findAll().stream().map(MonedaDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public MonedaDTO createMoneda(@RequestBody()MonedaPostDTO monedaPostDTO) throws  Exception{
        Moneda moneda = monedaPostDTO.toEntity();
        MonedaDTO monedaDTO = new MonedaDTO(monedaService.save(moneda));
        return monedaDTO;
    }
}

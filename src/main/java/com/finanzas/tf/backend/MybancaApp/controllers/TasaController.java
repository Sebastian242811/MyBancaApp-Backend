package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.TasaDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.TasaPostDTO;
import com.finanzas.tf.backend.MybancaApp.models.Tasa;
import com.finanzas.tf.backend.MybancaApp.services.TasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tasa")
public class TasaController {

    @Autowired
    public TasaService tasaService;

    @GetMapping
    public List<TasaDTO> getAll() throws Exception{
        return tasaService.findAll().stream().map(TasaDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public TasaDTO createTasa(@RequestBody()TasaPostDTO tasaPostDTO) throws Exception{
        Tasa tasa= tasaPostDTO.ToEntity();
        TasaDTO tasaDTO= new TasaDTO(tasaService.save(tasa));
        return tasaDTO;
    }
}

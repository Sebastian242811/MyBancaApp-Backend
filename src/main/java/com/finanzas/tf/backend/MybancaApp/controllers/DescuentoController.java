package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.DescuentoDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.DescuentoPostDTO;
import com.finanzas.tf.backend.MybancaApp.models.Descuento;
import com.finanzas.tf.backend.MybancaApp.services.DescuentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/descuento")
public class DescuentoController {

    @Autowired
    private DescuentoService descuentoService;

    @GetMapping
    public List<DescuentoDTO> getAll() throws Exception{
        return descuentoService.findAll().stream().map(DescuentoDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public DescuentoDTO createDescuento(@RequestBody()DescuentoPostDTO descuentoPostDTO)throws Exception{
        Descuento descuento = descuentoPostDTO.toEntity();
        DescuentoDTO descuentoDTO = new DescuentoDTO(descuentoService.save(descuento));
        return descuentoDTO;
    }
}

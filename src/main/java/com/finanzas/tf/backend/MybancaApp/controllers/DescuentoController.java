package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.DescuentoDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.DescuentoPostDTO;
import com.finanzas.tf.backend.MybancaApp.models.Descuento;
import com.finanzas.tf.backend.MybancaApp.services.DescuentoService;
import com.finanzas.tf.backend.MybancaApp.services.TasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/descuento")
public class DescuentoController {

    @Autowired
    private DescuentoService descuentoService;

    @Autowired
    private TasaService tasaService;

    @GetMapping
    public List<DescuentoDTO> getAll() throws Exception{
        return descuentoService.findAll().stream().map(DescuentoDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public DescuentoDTO createDescuento(@Autowired @RequestBody()DescuentoPostDTO descuentoPostDTO)throws Exception{
        Descuento descuento = descuentoPostDTO.toEntity();
        descuento.setTasa(tasaService.findById(descuentoPostDTO.getIdtasa()).get());
        DescuentoDTO descuentoDTO = new DescuentoDTO(descuentoService.save(descuento));
        return descuentoDTO;
    }

    @DeleteMapping("{id}")
    public void deleteDescuento(@PathVariable() Integer id)throws Exception{
        descuentoService.deleteById(id);
    }
}

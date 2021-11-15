package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.CarteraDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.CarteraPostDTO;
import com.finanzas.tf.backend.MybancaApp.models.Cartera;
import com.finanzas.tf.backend.MybancaApp.services.CarteraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cartera")
public class CarteraController {


    @Autowired
    private CarteraService carteraService;

    @GetMapping
    @ResponseBody
    public List<CarteraDTO> getAll() throws Exception{
        return carteraService.findAll().stream().map(CarteraDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public Cartera createCartera(@RequestBody() CarteraPostDTO carteraPostDTO)throws Exception {
        Cartera cartera = new Cartera();
        cartera.setDCartera(carteraPostDTO.getDCartera());
        return carteraService.save(cartera);
    }
}

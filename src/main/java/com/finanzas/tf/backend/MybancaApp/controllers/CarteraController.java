package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.CarteraDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.CarteraPostDTO;
import com.finanzas.tf.backend.MybancaApp.models.Cartera;
import com.finanzas.tf.backend.MybancaApp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cartera")
public class CarteraController {


    @Autowired
    private CarteraService carteraService;

    @Autowired
    private ValorService valorService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private TipoCalendarioService tipoCalendarioService;

    @Autowired
    private DescuentoService descuentoService;

    @GetMapping
    @ResponseBody
    public List<CarteraDTO> getAll() throws Exception{
        return carteraService.findAll().stream().map(CarteraDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public CarteraDTO createCartera(@RequestBody() CarteraPostDTO carteraPostDTO)throws Exception {
        Cartera cartera = new Cartera();
        cartera.setValor(valorService.findById(carteraPostDTO.getIdValor()).get());
        cartera.setUsuario(usuarioService.findById(carteraPostDTO.getIdUsuario()).get());
        cartera.setMovimiento(movimientoService.findById(carteraPostDTO.getIdMovimiento()).get());
        cartera.setTipoCalendario(tipoCalendarioService.findById(carteraPostDTO.getIdCalendario()).get());
        cartera.setDescuento(descuentoService.findById(carteraPostDTO.getIdDescuento()).get());
        cartera.setDCartera(carteraPostDTO.getDCartera());
        return new CarteraDTO(carteraService.save(cartera));
    }

    @DeleteMapping("{id}")
    public void deleteCartera(@PathVariable() Integer id)throws Exception{
        carteraService.deleteById(id);
    }
}

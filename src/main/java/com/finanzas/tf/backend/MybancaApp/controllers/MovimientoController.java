package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.MovimientoDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.MovimientoPostDTO;
import com.finanzas.tf.backend.MybancaApp.models.Movimiento;
import com.finanzas.tf.backend.MybancaApp.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/movimiento")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<MovimientoDTO> getAll() throws Exception{
        return movimientoService.findAll().stream().map(MovimientoDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public MovimientoDTO createMovimiento(@RequestBody()MovimientoPostDTO movimientoPostDTO) throws Exception{
        Movimiento movimiento = movimientoPostDTO.toEntity();
        MovimientoDTO movimientoDTO = new MovimientoDTO(movimientoService.save(movimiento));
        return movimientoDTO;
    }

    @DeleteMapping("{id}")
    public void deleteMovimiento(@PathVariable() Integer id)throws Exception{
        movimientoService.deleteById(id);
    }
}

package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.TipoCalendarioDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.TipoCalendarioPostDTO;
import com.finanzas.tf.backend.MybancaApp.models.TipoCalendario;
import com.finanzas.tf.backend.MybancaApp.services.TipoCalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tipocalendario")
public class TipoCalendarioController {

    @Autowired
    private TipoCalendarioService tipoCalendarioService;

    @GetMapping
    @ResponseBody
    public List<TipoCalendarioDTO> getAl() throws Exception{
        return tipoCalendarioService.findAll().stream().map(TipoCalendarioDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public TipoCalendarioDTO createCalendario(@RequestBody()TipoCalendarioPostDTO tipoCalendarioPostDTO)throws Exception{
        TipoCalendario tipoCalendario = tipoCalendarioPostDTO.toEntity();
        TipoCalendarioDTO tipoCalendarioDTO = new TipoCalendarioDTO(tipoCalendarioService.save(tipoCalendario));
        return tipoCalendarioDTO;
    }
}

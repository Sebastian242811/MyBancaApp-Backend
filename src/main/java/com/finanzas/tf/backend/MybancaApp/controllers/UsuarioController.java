package com.finanzas.tf.backend.MybancaApp.controllers;

import com.finanzas.tf.backend.MybancaApp.DTO.UsuarioDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.UsuarioPostDTO;
import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import com.finanzas.tf.backend.MybancaApp.services.UsuarioService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> getAll() throws Exception{
        return usuarioService.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public UsuarioDTO createUsuario(@RequestBody()UsuarioPostDTO usuarioPostDTO)throws Exception{
        Usuario usuario = usuarioPostDTO.toEntity();
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioService.save(usuario));
        return usuarioDTO;
    }

    @DeleteMapping("{id}")
    public void deleteUsuario(@PathVariable() Integer id)throws Exception{
        usuarioService.deleteById(id);
    }
}

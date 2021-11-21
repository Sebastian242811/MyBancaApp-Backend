package com.finanzas.tf.backend.MybancaApp.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finanzas.tf.backend.MybancaApp.DTO.RolDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.RolPostDTO;
import com.finanzas.tf.backend.MybancaApp.DTO.UsuarioDTO;
import com.finanzas.tf.backend.MybancaApp.models.Rol;
import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import com.finanzas.tf.backend.MybancaApp.services.RolService;
import com.finanzas.tf.backend.MybancaApp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.FORBIDDEN;

@RestController
@RequestMapping(value = "/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<RolDTO> getAll() throws Exception{
        return rolService.findAll().stream().map(RolDTO::new).collect(Collectors.toList());
    }

    @PostMapping
    public RolDTO createRol(@RequestBody()RolPostDTO rolPostDTO)throws Exception{
        Rol rol = rolPostDTO.toEntity();
        RolDTO rolDTO= new RolDTO(rolService.save(rol));
        return rolDTO;
    }

    @DeleteMapping("{id}")
    public void deleteRol(@PathVariable() Integer id)throws Exception{
        rolService.deleteById(id);
    }

    @PostMapping("{idRol}/addtouser/{idUsuario}")
    public UsuarioDTO addRol(@PathVariable Integer idRol,@PathVariable Integer idUsuario){
        return rolService.addRolToUser(idUsuario,idRol);
    }

    @GetMapping("token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(authorizationHeader != null ){
            try{
                String refresh_token = authorizationHeader;
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier= JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                Usuario user = usuarioService.findByUsuario(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsuario())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 *1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles",user.getRoles().stream().map(Rol::getNombre).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token",access_token);
                tokens.put("refresh_token",refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),tokens);
            }catch (Exception exception){
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),error);

            }
        }else {
            throw new RuntimeException("Refresh Token is missing");
        }
    }
}

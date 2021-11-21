package com.finanzas.tf.backend.MybancaApp.config;
import com.finanzas.tf.backend.MybancaApp.models.Rol;
import com.finanzas.tf.backend.MybancaApp.models.Usuario;
import com.finanzas.tf.backend.MybancaApp.services.RolService;
import com.finanzas.tf.backend.MybancaApp.services.UsuarioService;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class openApiConfiguration {
    @Bean(name = "consultationOpenApi")
    public OpenAPI consultationOpenApi() {
        return new OpenAPI().info(
                new Info()
                        .title("MyBancaApp API")
                        .description("MyBancaApp API implemented with Spring Boot RESTful service and documented using springdoc-openapi and OpenAPI 3.0")
                        .version("1.0")
                        .contact(
                                new Contact()
                                        .name("Sebastian Daniel Hernandez Tuesta")
                                        .email("hernandesebastian0@gmail.com")
                                        .url("https://blucode.solutions"))
        );
    }

    @Bean
    CommandLineRunner run(UsuarioService usuarioService, RolService rolService){

        return args -> {
            rolService.save(new Rol(null,"Administrador"));
            rolService.save(new Rol(null,"Cliente"));

            usuarioService.save(new Usuario(null, "Admin", "admin@user.com", "00000000", "admin", "1234", new ArrayList<>(),new ArrayList<>()));

            rolService.addRolToUser(1,1);
            rolService.addRolToUser(1,2);
        };
    }

}

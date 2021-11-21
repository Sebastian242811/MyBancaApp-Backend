package com.finanzas.tf.backend.MybancaApp.DTO;

import com.finanzas.tf.backend.MybancaApp.models.Rol;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class RolPostDTO {

    @Length(max = 20,message = "El nombre de rol no debe tener mas de 20 caracteres")
    @NotNull
    private String nombre;

    public Rol toEntity(){
        Rol rol = new Rol();
        rol.setNombre(this.nombre);
        return rol;
    }
}

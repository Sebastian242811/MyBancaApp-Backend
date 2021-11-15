package com.finanzas.tf.backend.MybancaApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finanzas.tf.backend.MybancaApp.models.Descuento;
import com.finanzas.tf.backend.MybancaApp.models.Tasa;
import com.finanzas.tf.backend.MybancaApp.repositories.TasaRepository;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@JsonIgnoreProperties(value = {"tasaRepository"},allowGetters = true,allowSetters = true)
@Component
public class DescuentoPostDTO {

    @Autowired
    private TasaRepository tasaRepository;

    @NotNull
    private Double MontoFinanciar;

    @Length(max = 30, message = "el tipo de descuento no debe tener mas de 30 caracteres")
    @NotNull
    private String tipoDescuento;

    private Integer idtasa;

    public Tasa findById(Integer idTasa) throws Exception {
        return tasaRepository.getById(idTasa);
    }

    public Descuento toEntity() throws Exception{
        Tasa tasa = findById(this.idtasa);
        Descuento descuento = new Descuento();
        descuento.setMontoFinanciar(this.MontoFinanciar);
        descuento.setTipoDescuento(this.tipoDescuento);
        if (tasa == null)
            descuento.setTasa(null);
        else
            descuento.setTasa(tasa);
        return descuento;
    }
}

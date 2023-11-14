package co.edu.javeriana.parcial.model.dto;

import co.edu.javeriana.parcial.model.entities.Equipo583;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link co.edu.javeriana.parcial.model.entities.Equipo583}
 */
@Value
public class Equipo583Dto implements Serializable {
    Integer id;
    String nombre;
    String ciudad;
    Integer copasInternacionales;

    public Equipo583Dto(Equipo583 equipo583){
        this.id = equipo583.getId();
        this.nombre = equipo583.getNombre();
        this.ciudad = equipo583.getCiudad();
        this.copasInternacionales = equipo583.getCopasInternacionales();
    }
}
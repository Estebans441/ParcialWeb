package co.edu.javeriana.parcial.model.dto;

import co.edu.javeriana.parcial.model.entities.Jugador583;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link co.edu.javeriana.parcial.model.entities.Jugador583}
 */
@Value
public class Jugador583Dto implements Serializable {
    Integer id;
    String nombre;
    String apellidos;
    Integer numero;

    public Jugador583Dto(Jugador583 jugador){
        this.id = jugador.getId();
        this.nombre = jugador.getNombre();
        this.apellidos = jugador.getApellidos();
        this.numero = jugador.getNumero();
    }
}
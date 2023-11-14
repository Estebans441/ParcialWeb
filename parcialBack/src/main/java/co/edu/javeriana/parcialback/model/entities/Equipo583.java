package co.edu.javeriana.parcialback.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EQUIPO583", schema = "final_javeriana")
public class Equipo583 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ciudad", length = 100)
    private String ciudad;

    @Column(name = "copas_internacionales")
    private Integer copasInternacionales;

}
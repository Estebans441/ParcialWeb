package co.edu.javeriana.parcialback.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "JUGADOR583", schema = "final_javeriana")
public class Jugador583 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo")
    private Equipo583 idEquipo;

}
package co.edu.javeriana.parcialback.model.repository;

import co.edu.javeriana.parcialback.model.entities.Jugador583;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Jugador583Repository extends JpaRepository<Jugador583, Integer> {
    List<Jugador583> findAllByIdEquipo_Id(Integer id);
}
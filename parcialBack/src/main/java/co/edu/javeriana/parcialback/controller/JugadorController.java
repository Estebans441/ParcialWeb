package co.edu.javeriana.parcialback.controller;


import co.edu.javeriana.parcialback.model.dto.Jugador583Dto;
import co.edu.javeriana.parcialback.model.entities.Equipo583;
import co.edu.javeriana.parcialback.model.entities.Jugador583;
import co.edu.javeriana.parcialback.model.repository.Equipo583Repository;
import co.edu.javeriana.parcialback.model.repository.Jugador583Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parcial/api/jugador/")
public class JugadorController {
    @Autowired
    Jugador583Repository jugador583Repository;

    @Autowired
    Equipo583Repository equipo583Repository;

    @CrossOrigin
    @GetMapping()
    private ResponseEntity<List<Jugador583Dto>> getAllJugadores() {
        List<Jugador583Dto> jugadores = jugador583Repository.findAll().stream().map(Jugador583Dto::new).toList();
        return ResponseEntity.ok(jugadores);
    }

    @CrossOrigin
    @GetMapping("equipo/{id}")
    private ResponseEntity<List<Jugador583Dto>> getAllJugadoresByEquipo(@PathVariable Integer id) {
        List<Jugador583Dto> jugadores = jugador583Repository.findAllByIdEquipo_Id(id).stream().map(Jugador583Dto::new).toList();
        return ResponseEntity.ok(jugadores);
    }

    @CrossOrigin
    @GetMapping("{id}")
    private ResponseEntity<Jugador583Dto> getJugador(@PathVariable Integer id) {
        Optional<Jugador583> jugador583Optional = jugador583Repository.findById(id);
        return jugador583Optional.map(jugador583 -> ResponseEntity.ok(new Jugador583Dto(jugador583))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PostMapping()
    private ResponseEntity<Jugador583Dto> createJugador(@RequestBody Jugador583 jugador) {
        Optional<Equipo583> equipo583Optional = equipo583Repository.findById(jugador.getIdEquipo().getId());
        if (equipo583Optional.isPresent())
            return ResponseEntity.ok(new Jugador583Dto(jugador583Repository.save(jugador)));
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @PutMapping("{id}")
    private ResponseEntity<Jugador583Dto> updateJugador(@PathVariable Integer id, @RequestBody Jugador583 jugador583) {
        Optional<Jugador583> jugador583Optional = jugador583Repository.findById(id);
        Optional<Equipo583> equipo583Optional = equipo583Repository.findById(jugador583.getIdEquipo().getId());
        if (jugador583Optional.isPresent() && equipo583Optional.isPresent()) {
            jugador583.setId(id);
            jugador583.setIdEquipo(equipo583Optional.get());
            return ResponseEntity.ok(new Jugador583Dto(jugador583Repository.save(jugador583)));
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin()
    @DeleteMapping("{id}")
    private Boolean deleteJugador(@PathVariable Integer id) {
        jugador583Repository.deleteById(id);
        return true;
    }
}

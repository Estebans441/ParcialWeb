package co.edu.javeriana.parcial.controller;

import co.edu.javeriana.parcial.model.dto.Equipo583Dto;
import co.edu.javeriana.parcial.model.entities.Equipo583;
import co.edu.javeriana.parcial.model.repository.Equipo583Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parcial/api/equipo/")
public class EquipoController {
    @Autowired
    Equipo583Repository equipo583Repository;

    @CrossOrigin
    @GetMapping()
    private ResponseEntity<List<Equipo583Dto>> getAllEquipos() {
        List<Equipo583Dto> equipos = equipo583Repository.findAll().stream().map(Equipo583Dto::new).toList();
        return ResponseEntity.ok(equipos);
    }

    @CrossOrigin
    @GetMapping("{id}")
    private ResponseEntity<Equipo583Dto> getEquipoById(@PathVariable Integer id) {
        Optional<Equipo583> equipo583Optional = equipo583Repository.findById(id);
        return equipo583Optional.map(equipo583 -> ResponseEntity.ok(new Equipo583Dto(equipo583))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @CrossOrigin
    @PostMapping()
    private ResponseEntity<Equipo583Dto> createEquipo(@RequestBody Equipo583 equipo583) {
        return ResponseEntity.ok(new Equipo583Dto(equipo583Repository.save(equipo583)));
    }

    @CrossOrigin
    @PutMapping("{id}")
    private ResponseEntity<Equipo583Dto> updateEquipo(@PathVariable Integer id, @RequestBody Equipo583 equipo583) {
        Optional<Equipo583> equipo583Optional = equipo583Repository.findById(id);
        if (equipo583Optional.isPresent()) {
            equipo583.setId(id);
            return ResponseEntity.ok(new Equipo583Dto(equipo583Repository.save(equipo583)));
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin
    @DeleteMapping("{id}")
    private Boolean deleteEquipo(@PathVariable Integer id){
        equipo583Repository.deleteById(id);
        return true;
    }
}

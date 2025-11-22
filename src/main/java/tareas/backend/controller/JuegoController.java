package tareas.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tareas.backend.entity.Juego;
import tareas.backend.service.JuegoService;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    @Autowired
    private JuegoService service;

    @GetMapping
    public List<Juego> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juego> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Juego create(@RequestBody Juego j) {
        return service.save(j);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Juego> update(@PathVariable Long id, @RequestBody Juego j) {
        return service.findById(id)
                .map(existing -> ResponseEntity.ok(service.save(j)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(j -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

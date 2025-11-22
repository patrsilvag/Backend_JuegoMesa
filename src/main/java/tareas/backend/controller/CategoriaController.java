package tareas.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tareas.backend.entity.Categoria;
import tareas.backend.service.CategoriaService;
import org.springframework.lang.NonNull;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@NonNull @PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria create(@NonNull @RequestBody Categoria c) {
        return service.save(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@NonNull @PathVariable Long id, @RequestBody Categoria c) {
        return service.findById(id)
                .map(existing -> ResponseEntity.ok(service.save(c)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@NonNull @PathVariable Long id) {
        service.deleteById(id);
    }
}

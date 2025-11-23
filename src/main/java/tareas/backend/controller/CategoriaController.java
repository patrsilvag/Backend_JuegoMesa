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
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria c) {
        return service.findById(id)
                .map(existing -> {
                    c.setIdCategoria(id);

                    if (c.getNombre() == null)
                        c.setNombre(existing.getNombre());
                    if (c.getTitulo() == null)
                        c.setTitulo(existing.getTitulo());
                    if (c.getSubtitulo() == null)
                        c.setSubtitulo(existing.getSubtitulo());
                    if (c.getImagen() == null)
                        c.setImagen(existing.getImagen());

                    return ResponseEntity.ok(service.save(c));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build(); // 404
        }

        service.deleteById(id);
        return ResponseEntity.noContent().build(); // 204
    }

}

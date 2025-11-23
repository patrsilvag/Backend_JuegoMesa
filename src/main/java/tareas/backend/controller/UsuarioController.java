package tareas.backend.controller;

import tareas.backend.entity.Usuario;
import tareas.backend.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200") 
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Usuario u) {
        if (service.existsById(u.getCorreo())) {
            // 409 Conflict: ya existe
            return ResponseEntity.status(409).build();
            // si quieres body: .body("USUARIO_YA_EXISTE")
        }
        Usuario creado = service.save(u);
        return ResponseEntity.ok(creado); // o 201 si quieres REST estricto
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable String id, @Valid @RequestBody Usuario u) {
        return service.findById(id)
                .map(existing -> {
                    u.setCorreo(id); // amarra ID al path
                    return ResponseEntity.ok(service.save(u));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!service.existsById(id)) {
            return ResponseEntity.notFound().build(); // 404
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build(); // 204
    }
}

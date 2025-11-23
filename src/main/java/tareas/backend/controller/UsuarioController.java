package tareas.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tareas.backend.entity.Usuario;
import tareas.backend.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

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
    public Usuario create(@RequestBody Usuario u) {
        return service.save(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable String id, @RequestBody Usuario u) {
        return service.findById(id)
                .map(existing -> {

                    // ✅ siempre mantener el ID original
                    u.setCorreo(id);

                    // ✅ merge campo a campo si viene null
                    if (u.getNombre() == null)
                        u.setNombre(existing.getNombre());
                    if (u.getUsuario() == null)
                        u.setUsuario(existing.getUsuario());
                    if (u.getClave() == null)
                        u.setClave(existing.getClave());
                    if (u.getRol() == null)
                        u.setRol(existing.getRol());
                    if (u.getDireccion() == null)
                        u.setDireccion(existing.getDireccion());
                    if (u.getFechaNacimiento() == null)
                        u.setFechaNacimiento(existing.getFechaNacimiento());
                    if (u.getEstado() == null)
                        u.setEstado(existing.getEstado());

                    return ResponseEntity.ok(service.save(u));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.findById(id)
                .map(u -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

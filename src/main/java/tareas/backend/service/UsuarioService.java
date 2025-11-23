package tareas.backend.service;

import tareas.backend.entity.Usuario;
import tareas.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(String correo) {
        return repository.findById(correo);
    }

    public Usuario save(Usuario u) {
        return repository.save(u);
    }

    public void deleteById(String correo) {
        repository.deleteById(correo);
    }

    public boolean existsById(String correo) {
        return repository.existsById(correo);
    }
}

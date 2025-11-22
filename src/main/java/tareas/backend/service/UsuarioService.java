package tareas.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import tareas.backend.entity.Usuario;
import tareas.backend.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(@NonNull String id) {
        return repository.findById(id);
    }

    public Usuario save(@NonNull Usuario u) {
        return repository.save(u);
    }

    public void deleteById(@NonNull String id) {
        repository.deleteById(id);
    }
}

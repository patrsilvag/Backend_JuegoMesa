package tareas.backend.service;

import tareas.backend.entity.Usuario;
import tareas.backend.repository.UsuarioRepository;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

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

    // 🔐 Nuevo método para login con logger
    public Optional<Usuario> login(String correo, String clave) {
        logger.debug("Intentando login con correo: {} y clave: {}", correo, clave);
        return repository.findByCorreoAndClave(correo, clave);
    }
}

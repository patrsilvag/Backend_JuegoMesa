package tareas.backend.repository;

import tareas.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    // Buscar usuario por correo y clave (para login)
    Optional<Usuario> findByCorreoAndClave(String correo, String clave);
}

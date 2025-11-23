package tareas.backend.repository;

import tareas.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    // correo es el ID, no necesitas nada extra por ahora
}

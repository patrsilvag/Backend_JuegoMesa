package tareas.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tareas.backend.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}

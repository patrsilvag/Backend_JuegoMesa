package tareas.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tareas.backend.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

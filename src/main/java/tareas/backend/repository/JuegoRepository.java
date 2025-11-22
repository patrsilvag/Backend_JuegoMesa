package tareas.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tareas.backend.entity.Juego;

public interface JuegoRepository extends JpaRepository<Juego, Long> {
}

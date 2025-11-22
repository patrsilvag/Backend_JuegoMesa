package tareas.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import tareas.backend.entity.Juego;
import tareas.backend.repository.JuegoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JuegoService {

    @Autowired
    private JuegoRepository repository;

    public List<Juego> findAll() {
        return repository.findAll();
    }

    public Optional<Juego> findById(@NonNull Long id) {
        return repository.findById(id);
    }

    public Juego save(@NonNull Juego j) {
        return repository.save(j);
    }

    public void deleteById(@NonNull Long id) {
        repository.deleteById(id);
    }
}

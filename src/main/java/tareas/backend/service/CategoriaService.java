package tareas.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import tareas.backend.entity.Categoria;
import tareas.backend.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Optional<Categoria> findById(@NonNull Long id) {
        return repository.findById(id);
    }

    public Categoria save(@NonNull Categoria c) {
        return repository.save(c);
    }

    public void deleteById(@NonNull Long id) {
        repository.deleteById(id);
    }
}

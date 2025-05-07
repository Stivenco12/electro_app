package com.electroapp.electro_app.infrastructure.repository.Arls;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.electroapp.electro_app.application.services.IArlsService;
import com.electroapp.electro_app.domain.entities.Arls;

@Service
public class ArlsImpl implements IArlsService {
    @Autowired
    private ArlsRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Arls> findAll() {
        return (List<Arls>) repository.findAll();
    }

    @Override
    public Optional<Arls> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Arls save(Arls arls) {
        return repository.save(arls);
    }

    @Override
    public Optional<Arls> update(Long id, Arls arls) {
        Optional<Arls> arlsold = repository.findById(id);
        if(arlsold.isPresent()){
            Arls arlsDb = arlsold.orElseThrow();
            arlsDb.setNombre(arls.getNombre());
            return Optional.of(repository.save(arlsDb));
        }
        return Optional.empty();
    }
    
    @Override
    public Optional<Arls> delete(Long id) {
        Optional<Arls> arlsOptional = repository.findById(id);
        arlsOptional.ifPresent(arlsDb -> {
            repository.delete(arlsDb);
        });
        return arlsOptional;        
    }
}

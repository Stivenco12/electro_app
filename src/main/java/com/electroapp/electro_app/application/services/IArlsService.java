package com.electroapp.electro_app.application.services;

import java.util.List;
import java.util.Optional;
import com.electroapp.electro_app.domain.entities.Arls;

public interface IArlsService {
    List<Arls> findAll();

    Optional<Arls> findById(Long id);

    Arls save(Arls arls);
    
    Optional<Arls> update(Long id, Arls arls);

    Optional<Arls> delete(Long id);    
}
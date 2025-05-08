package com.electroapp.electro_app.application.services;

import java.util.List;
import java.util.Optional;

import com.electroapp.electro_app.domain.entities.Eps;

public interface IEpsService {
    List<Eps> findAll();

    Optional<Eps> findById(Long id);

    Eps save(Eps eps);
    
    Optional<Eps> update(Long id, Eps eps);

    Optional<Eps> delete(Long id);    
    
} 
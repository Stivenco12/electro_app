package com.electroapp.electro_app.infrastructure.repository.Eps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electroapp.electro_app.domain.entities.Eps;

@Repository
public interface EpsRepository extends JpaRepository<Eps, Long> {
    
}

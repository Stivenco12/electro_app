package com.electroapp.electro_app.infrastructure.repository.Arls;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.electroapp.electro_app.domain.entities.Arls;

@Repository
public interface ArlsRepository extends JpaRepository<Arls, Long> {
    
}
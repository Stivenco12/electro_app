package com.electroapp.electro_app.infrastructure.repository.Region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.electroapp.electro_app.domain.entities.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region,Long>  {
    
}

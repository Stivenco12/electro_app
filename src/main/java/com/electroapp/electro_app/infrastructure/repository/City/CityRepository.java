package com.electroapp.electro_app.infrastructure.repository.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.electroapp.electro_app.domain.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}

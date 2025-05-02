package electro_app.electro_app.application.services;

import java.util.List;
import java.util.Optional;
import electro_app.electro_app.domain.entities.City;

public interface ICityService {
    List<City> findAll();

    Optional<City> findById(int id);

    City save(City city);

    Optional<City> update(int id, City city);

    Optional<City> delete(int id);
} 

package electro_app.electro_app.application.services;

import java.util.List;
import java.util.Optional;
import electro_app.electro_app.domain.entities.City;

public interface ICityService {
    List<City> findAll();

    Optional<City> findById(int id);

    String save(City city);

    Optional<City> update(int id, String city);

    Optional<City> delete(int id);
} 

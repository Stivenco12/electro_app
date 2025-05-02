package electro_app.electro_app.application.services;

import java.util.List;
import java.util.Optional;
import electro_app.electro_app.domain.entities.Country;

public interface ICountryService {
    List<Country> findAll();

    Optional<Country> findById(int id);

    Country save(Country country);

    Optional<Country> update(int id, Country country);

    Optional<Country> delete(int id);
}

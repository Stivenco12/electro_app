package electro_app.electro_app.application.services;

import java.util.List;
import java.util.Optional;
import electro_app.electro_app.domain.entities.region;

public interface IRegionService {
    List<region> findAll();

    Optional<region> findById(int id);

    region save(region region);

    Optional<region> update(int id, region region);

    Optional<region> delete(int id);
}

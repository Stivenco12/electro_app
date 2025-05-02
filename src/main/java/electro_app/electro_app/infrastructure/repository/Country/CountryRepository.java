package electro_app.electro_app.infrastructure.repository.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import electro_app.electro_app.domain.entities.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    
}

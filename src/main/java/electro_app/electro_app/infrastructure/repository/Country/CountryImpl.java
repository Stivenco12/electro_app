package electro_app.electro_app.infrastructure.repository.Country;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import electro_app.electro_app.application.services.ICountryService;
import electro_app.electro_app.domain.entities.Country;

@Service
public class CountryImpl implements ICountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Country>  findAll() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> update(int id, Country country) {
        Optional<Country> countryOld = countryRepository.findById(id);
        if (countryOld.isPresent()) {
            Country countryDb = countryOld.orElseThrow();
            countryDb.setNameCountry(country.getNameCountry());
            return Optional.of(countryRepository.save(countryDb));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Country> delete(int id) {
        Optional<Country> countryOptional = countryRepository.findById(id);
        countryOptional.ifPresent(countryDb -> {
            countryRepository.delete(countryDb);
        });
        return countryOptional;
    }

}

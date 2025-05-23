package electro_app.electro_app.infrastructure.controllers;

import org.springframework.web.bind.annotation.RestController;
import electro_app.electro_app.application.services.ICountryService;
import electro_app.electro_app.domain.entities.Country;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired
    private ICountryService countryService;

    @GetMapping
    public List<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable int id) {
        Optional<Country> countryOptional = countryService.findById(id);
        if (countryOptional.isPresent()) {
            return ResponseEntity.ok(countryOptional.orElseThrow());
        } 
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Country country) {
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(country));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Country> countryOptional = countryService.delete(id);
        if (countryOptional.isPresent()) {
            return ResponseEntity.ok(countryOptional.orElseThrow());
        } 
        return ResponseEntity.notFound().build();
    }
    
    
}

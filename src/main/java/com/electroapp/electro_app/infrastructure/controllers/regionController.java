package com.electroapp.electro_app.infrastructure.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.electroapp.electro_app.application.services.IRegionService;
import com.electroapp.electro_app.domain.entities.Region;

@RestController
@RequestMapping("/api/region")
public class regionController {
        @Autowired
    private IRegionService countryService;

    @GetMapping
    public List<Region> list() {
        return countryService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Region> countryOptional = countryService.findById(id);
        if (countryOptional.isPresent()) {
            return ResponseEntity.ok(countryOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Region country) {
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(country));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Region> countryOptional = countryService.delete(id);
        if (countryOptional.isPresent()) {
            return ResponseEntity.ok(countryOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Region country) {
        Optional<Region> countryOptional = countryService.update(id, country);
        if (countryOptional.isPresent()) {
            return ResponseEntity.ok(countryOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}

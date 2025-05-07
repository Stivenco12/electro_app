package com.electroapp.electro_app.infrastructure.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.electroapp.electro_app.application.services.IArlsService;
import com.electroapp.electro_app.domain.entities.Arls;

@RestController
@RequestMapping("/api/Arls")
public class ArlsController {
    @Autowired
    private IArlsService arlsService;

    @GetMapping
    public List<Arls> list() {
        return arlsService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Arls> show(@Validated @PathVariable Long id) {
        Optional<Arls> ArlsOptional = arlsService.findById(id);
        if (ArlsOptional.isPresent()) {
            return ResponseEntity.ok(ArlsOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Arls arls) {
        return ResponseEntity.status(HttpStatus.CREATED).body(arlsService.save(arls));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Arls> ArlsOptional = arlsService.delete(id);
        if (ArlsOptional.isPresent()) {
            return ResponseEntity.ok(ArlsOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Arls arls) {
        Optional<Arls> ArlsOptional = arlsService.update(id, arls);
        if (ArlsOptional.isPresent()) {
            return ResponseEntity.ok(ArlsOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}

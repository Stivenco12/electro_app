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
import com.electroapp.electro_app.application.services.IEpsService;
import com.electroapp.electro_app.domain.entities.Eps;

@RestController
@RequestMapping("/api/Eps")
public class EpsController {
    @Autowired
    private IEpsService epsService;

    @GetMapping
    public List<Eps> list() {
        return epsService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Eps> epsOptional = epsService.findById(id);
        if (epsOptional.isPresent()) {
            return ResponseEntity.ok(epsOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Eps eps) {
        return ResponseEntity.status(HttpStatus.CREATED).body(epsService.save(eps));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Eps> epsOptional = epsService.delete(id);
        if (epsOptional.isPresent()) {
            return ResponseEntity.ok(epsOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Eps eps) {
        Optional<Eps> epsOptional = epsService.update(id, eps);
        if (epsOptional.isPresent()) {
            return ResponseEntity.ok(epsOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}

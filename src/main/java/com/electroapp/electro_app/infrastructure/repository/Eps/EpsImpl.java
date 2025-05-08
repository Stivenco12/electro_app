package com.electroapp.electro_app.infrastructure.repository.Eps;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.electroapp.electro_app.application.services.IEpsService;
import com.electroapp.electro_app.domain.entities.Eps;

@Service
public class EpsImpl implements IEpsService {
    private final EpsRepository epsRepository;

    public EpsImpl(EpsRepository epsRepository) {
        this.epsRepository = epsRepository;
    }

    @Override
    public List<Eps> findAll() {
        return epsRepository.findAll();
    }

    @Override
    public Optional<Eps> findById(Long id) {
        return epsRepository.findById(id);
    }

    @Override
    public Eps save(Eps eps) {
        return epsRepository.save(eps);
    }

    @Override
    public Optional<Eps> update(Long id, Eps eps) {
        if (epsRepository.existsById(id)) {
            eps.setId(id);
            return Optional.of(epsRepository.save(eps));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Eps> delete(Long id) {
        if (epsRepository.existsById(id)) {
            Optional<Eps> eps = epsRepository.findById(id);
            epsRepository.deleteById(id);
            return eps;
        }
        return Optional.empty();
    }
}

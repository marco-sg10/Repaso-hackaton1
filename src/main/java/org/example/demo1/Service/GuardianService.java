package org.example.demo1.Service;

import lombok.RequiredArgsConstructor;
import org.example.demo1.Exception.EmailAlreadyExistsException;
import org.example.demo1.Repository.GuardianRepository;
import org.example.demo1.entity.Guardian;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class GuardianService {

    private final GuardianRepository repository;

    public Guardian create(Guardian guardian) {
        if (repository.existsByEmail(guardian.getEmail())) {
            throw new EmailAlreadyExistsException(guardian.getEmail());
        }
        guardian.setCreatedAt(Instant.now());
        return repository.save(guardian);
    }
}

package org.example.demo1.Repository;

import org.example.demo1.entity.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuardianRepository extends JpaRepository<Guardian, Long> {
    Optional<Guardian> findByEmail(String email);
    boolean existsByEmail(String email);
}

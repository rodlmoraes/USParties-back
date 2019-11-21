package com.usp.usparties.repository;

import com.usp.usparties.model.AcademicCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcademicCenterRepository extends JpaRepository<AcademicCenter, Long> {
    Optional<AcademicCenter> findByEmailAndPassword (String email, String password);
}

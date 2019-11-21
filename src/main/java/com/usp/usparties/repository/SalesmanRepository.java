package com.usp.usparties.repository;

import com.usp.usparties.model.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalesmanRepository extends JpaRepository<Salesman, Long> {
    Optional<Salesman> findByEmailAndPassword (String email, String password);
}

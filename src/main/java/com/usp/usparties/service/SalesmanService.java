package com.usp.usparties.service;

import com.usp.usparties.model.Salesman;
import com.usp.usparties.repository.SalesmanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesmanService {
    private final SalesmanRepository repository;

    public List<Salesman> findAll(){
        return repository.findAll();
    }

    public Optional<Salesman> findById(Long id){
        return repository.findById(id);
    }

    public Optional<Salesman> findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public Salesman save(Salesman salesman){
        return repository.save(salesman);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

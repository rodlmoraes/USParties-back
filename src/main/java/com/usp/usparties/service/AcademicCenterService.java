package com.usp.usparties.service;

import com.usp.usparties.model.AcademicCenter;
import com.usp.usparties.repository.AcademicCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcademicCenterService {
    private final AcademicCenterRepository repository;

    public List<AcademicCenter> findAll(){
        return repository.findAll();
    }

    public Optional<AcademicCenter> findById(Long id){
        return repository.findById(id);
    }

    public Optional<AcademicCenter> findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public AcademicCenter save(AcademicCenter academicCenter){
        return repository.save(academicCenter);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

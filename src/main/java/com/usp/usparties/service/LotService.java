package com.usp.usparties.service;

import com.usp.usparties.model.Lot;
import com.usp.usparties.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LotService {

    private final LotRepository repository;

    public List<Lot> findAll(){
        return repository.findAll();
    }

    public Optional<Lot> findById(Long id){
        return repository.findById(id);
    }

    public Lot save(Lot lot){
        return repository.save(lot);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

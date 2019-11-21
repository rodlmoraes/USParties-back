package com.usp.usparties.service;

import com.usp.usparties.model.Party;
import com.usp.usparties.repository.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartyService {

    private final PartyRepository repository;

    public List<Party> findAll(){
        return repository.findAll();
    }

    public Optional<Party> findById(Long id){
        return repository.findById(id);
    }

    public List<Party> findAllByAcademicCenter_Id(Long id){
        return repository.findAllByAcademicCenter_Id(id);
    }

    public Party save(Party party){
        return repository.save(party);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}

package com.usp.usparties.service;

import com.usp.usparties.model.PartyEdition;
import com.usp.usparties.repository.PartyEditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartyEditionService {
    private final PartyEditionRepository repository;

    public List<PartyEdition> findAll(){
        return repository.findAll();
    }

    public List<PartyEdition> findAllByAcademicCenter(Long idAcademicCenter) { return repository.findAllByAcademicCenter(idAcademicCenter); }

    public Optional<PartyEdition> findById(Long id){
        return repository.findById(id);
    }

    public PartyEdition save(PartyEdition partyEdition){
        return repository.save(partyEdition);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

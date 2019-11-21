package com.usp.usparties.service;


import com.usp.usparties.model.TicketPost;
import com.usp.usparties.repository.TicketPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketPostService {

    private final TicketPostRepository repository;

    public List<TicketPost> findAll(){
        return repository.findAll();
    }

    public List<TicketPost> findAllBySalesman_Id(Long id) { return repository.findAllBySalesman_Id(id); }

    public Optional<TicketPost> findById(Long id){
        return repository.findById(id);
    }

    public TicketPost save(TicketPost ticketPost){
        return repository.save(ticketPost);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

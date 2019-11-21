package com.usp.usparties.controller;

import com.usp.usparties.model.TicketPost;
import com.usp.usparties.service.TicketPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/ticket-post"})
@Slf4j
@RequiredArgsConstructor
public class TicketPostController {

    private final TicketPostService service;

    @GetMapping
    public ResponseEntity<List<TicketPost>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<TicketPost> findById(@PathVariable Long id) {
        Optional<TicketPost> ticketPost = service.findById(id);
        if (!ticketPost.isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(ticketPost.get());
    }

    @GetMapping(path = {"salesman/{id}"})
    public ResponseEntity<List<TicketPost>> findAllBySalesman_Id(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllBySalesman_Id(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TicketPost ticketPost){
        return ResponseEntity.ok(service.save(ticketPost));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,
                                 @RequestBody TicketPost ticketPost) {
        if (!service.findById(id).isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.save(ticketPost));
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

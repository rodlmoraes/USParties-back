package com.usp.usparties.controller;

import com.usp.usparties.model.PartyEdition;
import com.usp.usparties.service.PartyEditionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/edition"})
@Slf4j
@RequiredArgsConstructor
public class PartyEditionController {
    private final PartyEditionService service;

    @GetMapping
    public ResponseEntity<List<PartyEdition>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<PartyEdition> findById(@PathVariable Long id){
        Optional<PartyEdition> partyEdition = service.findById(id);
        if (!partyEdition.isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(partyEdition.get());
    }

    @GetMapping(path = {"/academic-center/{id}"})
    public ResponseEntity<List<PartyEdition>> findAllByAcademicCenter(@PathVariable Long id){
        return ResponseEntity.ok(service.findAllByAcademicCenter(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody PartyEdition partyEdition){
        return ResponseEntity.ok(service.save(partyEdition));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,
                                 @RequestBody PartyEdition partyEdition) {
        if (!service.findById(id).isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.save(partyEdition));
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

package com.usp.usparties.controller;

import com.usp.usparties.model.Party;
import com.usp.usparties.service.PartyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/party"})
@Slf4j
@RequiredArgsConstructor
public class PartyController {

    private final PartyService service;

    @GetMapping
    public ResponseEntity<List<Party>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Party> findById(@PathVariable Long id){
        Optional<Party> party = service.findById(id);
        if (!party.isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(party.get());
    }

    @GetMapping(path = {"/academic-center/{id}"})
    public ResponseEntity<List<Party>> findAllByAcademicCenter_Id(@PathVariable Long id){
        return ResponseEntity.ok(service.findAllByAcademicCenter_Id(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Party party){
        return ResponseEntity.ok(service.save(party));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,
                                 @RequestBody Party party) {
        if (!service.findById(id).isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.save(party));
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

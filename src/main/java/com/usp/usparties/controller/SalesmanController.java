package com.usp.usparties.controller;

import com.usp.usparties.model.Salesman;
import com.usp.usparties.service.SalesmanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/salesman"})
@Slf4j
@RequiredArgsConstructor
public class SalesmanController {
    private final SalesmanService service;

    @GetMapping
    public ResponseEntity<List<Salesman>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Salesman> findById(@PathVariable Long id){
        Optional<Salesman> salesman = service.findById(id);
        if (!salesman.isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(salesman.get());
    }

    @GetMapping(path = {"/check-password/{email}/{password}"})
    public ResponseEntity<Salesman> checkPassword(@PathVariable String email, @PathVariable String password){
        Optional<Salesman> salesman = service.findByEmailAndPassword(email, password);
        if (!salesman.isPresent()) {
            log.error("Email or Password invalid");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(salesman.get());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Salesman salesman){
        return ResponseEntity.ok(service.save(salesman));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,
                                 @RequestBody Salesman salesman) {
        if (!service.findById(id).isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.save(salesman));
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

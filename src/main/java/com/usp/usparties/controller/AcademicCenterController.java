package com.usp.usparties.controller;

import com.usp.usparties.model.AcademicCenter;
import com.usp.usparties.service.AcademicCenterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/academic-center"})
@Slf4j
@RequiredArgsConstructor
public class AcademicCenterController {
    private final AcademicCenterService service;

    @GetMapping
    public ResponseEntity<List<AcademicCenter>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<AcademicCenter> findById(@PathVariable Long id){
        Optional<AcademicCenter> academicCenter = service.findById(id);
        if (!academicCenter.isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(academicCenter.get());
    }

    @GetMapping(path = {"/check-password/{email}/{password}"})
    public ResponseEntity<AcademicCenter> checkPassword(@PathVariable String email, @PathVariable String password){
        Optional<AcademicCenter> academicCenter = service.findByEmailAndPassword(email, password);
        if (!academicCenter.isPresent()) {
            log.error("Email or Password invalid");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(academicCenter.get());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody AcademicCenter academicCenter){
        return ResponseEntity.ok(service.save(academicCenter));
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,
                                 @RequestBody AcademicCenter academicCenter) {
        if (!service.findById(id).isPresent()) {
            log.error("Id " + id + " does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.save(academicCenter));
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

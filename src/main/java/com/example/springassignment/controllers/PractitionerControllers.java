package com.example.springassignment.controllers;

import com.example.springassignment.Repository.PatientRepository;
import com.example.springassignment.Repository.PractitionerRepository;
import com.example.springassignment.models.Practitioner;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class PractitionerControllers {

    private final PractitionerRepository practitionerRepository;

    public PractitionerControllers(PractitionerRepository practitionerRepository) {
        this.practitionerRepository = practitionerRepository;
    }

    //  get all practitioners
    @GetMapping("practitioners")
    private List<Practitioner> getAllPractitioners() {
        return this.practitionerRepository.findAll();
    }

    //  get practitioner by id
    @GetMapping("practitioner/{id}")
    private Practitioner getPractitionerById(@PathVariable(value = "id") int id) {
        return this.practitionerRepository.findById(id).get();
    }

    //  update practitioner by id
    @PutMapping("practitioner/{id}")
    private Practitioner updatePractitioner(@PathVariable(value = "id") int id, @RequestBody Practitioner newPractitionerDetails) {
        Practitioner existingPractitioner = practitionerRepository.findById(id).get();
        existingPractitioner.setEmail(newPractitionerDetails.getEmail());
        existingPractitioner.setFirstName(newPractitionerDetails.getFirstName());
        existingPractitioner.setLastName(newPractitionerDetails.getLastName());
        practitionerRepository.save(existingPractitioner);
        return existingPractitioner;
    }

    //  create practitioner
    @PostMapping("practitioner")
    private Practitioner addPractitioner(@RequestBody Practitioner newPractitioner) {
        return this.practitionerRepository.save(newPractitioner);
    }

    // delete practitioner
    @DeleteMapping("practitioner/{id}")
    private String deletePractitioner(@PathVariable(value = "id") int id) {
        try {
            this.practitionerRepository.deleteById(id);
            return "success";
        } catch (Exception e) {
            return "Not found";
        }
    }
}

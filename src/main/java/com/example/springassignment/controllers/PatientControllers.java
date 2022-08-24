package com.example.springassignment.controllers;

import com.example.springassignment.Repository.PatientRepository;
import com.example.springassignment.models.Patient;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientControllers {
    private PatientRepository patientRepository;

    public PatientControllers(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    //    get list of all patients
    @GetMapping("patients")
    private List<Patient> getAllPatients() {
        return this.patientRepository.findAll();
    }

    //     get patient by id
    @GetMapping("patient/{id}")
    private Optional<Patient> getPatientById(@PathVariable(value = "id") int id) {
        return this.patientRepository.findById(id);
    }

    //  create new patient
    @PostMapping("patient")
    private Patient addPatient(@RequestBody Patient patient) {
        return this.patientRepository.save(patient);
    }

    //  update patient by id
    @PutMapping("patient/{id}")
    private Patient updatePatient(@PathVariable(value = "id") int id, @RequestBody Patient newPatientDetails) {
        Patient exsistingPatient = patientRepository.findById(id).get();
        BeanUtils.copyProperties(newPatientDetails, exsistingPatient, "id");
        patientRepository.save(exsistingPatient);
        return exsistingPatient;
    }

    // delete patient by id
    @DeleteMapping("patient/{id}")
    private String deletePatientById(@PathVariable(value = "id") int id) {
        try {
            this.patientRepository.deleteById(id);
            return "success";
        } catch (Exception e) {
            return "No patient exists with this id";
        }

    }
}

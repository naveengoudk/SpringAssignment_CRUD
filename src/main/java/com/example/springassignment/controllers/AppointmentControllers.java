package com.example.springassignment.controllers;

import com.example.springassignment.Repository.AppointmentRepository;
import com.example.springassignment.Repository.PatientRepository;
import com.example.springassignment.Repository.PractitionerRepository;
import com.example.springassignment.models.Appoinment;
import com.example.springassignment.models.Patient;
import com.example.springassignment.models.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class AppointmentControllers {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PractitionerRepository practitionerRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;


    public AppointmentControllers() {
    }

    @GetMapping("appointments")
    private List<Appoinment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @DeleteMapping("appointment/{id}")
    private String deleteAppointment(@PathVariable(value = "id") int id) {
        try {
            appointmentRepository.deleteById(id);
            return "success";
        } catch (Exception e) {
            return "No appointment exist with that id";
        }
    }

    @PostMapping("appointment/patient/{patient_id}/practitioner/{practitioner_id}")
    private Appoinment createAppointment(@PathVariable(value = "patient_id") int patientId, @PathVariable(value = "practitioner_id") int practitionerId, @RequestBody Appoinment appoinment) {
        Patient patient = this.patientRepository.findById(patientId).get();
        Practitioner practitioner = this.practitionerRepository.findById(practitionerId).get();
        Appoinment appoinment1 = new Appoinment();
        assert false;
        appoinment1.setAppointmentStartTime(appoinment.getAppointmentStartTime());
        appoinment1.setAppointmentEndTime(appoinment.getAppointmentEndTime());
        appoinment1.setPatient(patient);
        appoinment1.setPractitioner(practitioner);
        appointmentRepository.save(appoinment1);
        return appoinment1;
    }

}

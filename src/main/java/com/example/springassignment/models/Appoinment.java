package com.example.springassignment.models;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.sql.Time;

@Entity(name = "appointments")
public class Appoinment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "appointment_starttime")
    private String appointmentStartTime;
    @Column(name = "appointment_endtime")
    private String appointmentEndTime;

    @ManyToOne
//    @Lazy(value = true)
    @JoinColumn(name = "patient", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
//    @Lazy(value = true)
    @JoinColumn(name = "practitioner", referencedColumnName = "id")
    private Practitioner practitioner;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(String appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public String getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(String appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Practitioner getPractitioner() {
        return practitioner;
    }

    public void setPractitioner(Practitioner practitioner) {
        this.practitioner = practitioner;
    }

    public Appoinment() {

    }

}

package com.example.springassignment.Repository;

import com.example.springassignment.models.Appoinment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appoinment, Integer> {
}

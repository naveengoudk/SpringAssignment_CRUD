package com.example.springassignment.Repository;

import com.example.springassignment.models.Practitioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PractitionerRepository extends JpaRepository<Practitioner, Integer> {
}

package com.hospital.hms_backend.repository;

import com.hospital.hms_backend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
  
}
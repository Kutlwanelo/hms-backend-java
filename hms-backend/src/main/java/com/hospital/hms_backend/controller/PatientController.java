package com.hospital.hms_backend.controller;

import com.hospital.hms_backend.model.Patient;
import com.hospital.hms_backend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Tells Spring "This class handles web requests"
@RequestMapping("/api/patients") // The base URL for everything in this class
@CrossOrigin("*") // Allows future frontend (React/Angular) to talk to this
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // 1. Get all patients (GET http://localhost:8080/api/patients)
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // 2. Create a new patient (POST http://localhost:8080/api/patients)
    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
  // 3. Update a patient (PUT http://localhost:8080/api/patients/{id})
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        // First, find the patient we want to edit
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        // Update the specific fields
        patient.setFirstName(patientDetails.getFirstName());
        patient.setLastName(patientDetails.getLastName());
        patient.setEmail(patientDetails.getEmail());
        patient.setDiagnosis(patientDetails.getDiagnosis());
        patient.setPhoneNumber(patientDetails.getPhoneNumber());

        // Save the updated version back to the database
        return patientRepository.save(patient);
    }

    // 4. Delete a patient (DELETE http://localhost:8080/api/patients/{id})
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        // Check if patient exists before deleting
        if (!patientRepository.existsById(id)) {
            return "Patient not found!";
        }
        
        patientRepository.deleteById(id);
        return "Patient with id " + id + " has been deleted successfully.";
    }
}

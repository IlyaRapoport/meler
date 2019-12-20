package com.clinic.meler.service;
import com.clinic.meler.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> findAll();

    Patient createPatient(Patient patient);

    List<Patient> findBy(String pk, String name, String surname);

    void deletePatient(List<Patient> patients);

    Patient updatePatient(Patient patient);

    Optional<Patient> findById(Long id);
}

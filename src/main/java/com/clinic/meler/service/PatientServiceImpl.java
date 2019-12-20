package com.clinic.meler.service;
import com.clinic.meler.model.Patient;
import com.clinic.meler.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findBy(String pk, String name, String surname) {
        if (pk != null) {
            return patientRepository.findByPersonalCode(pk);
        }
        if (surname != null) {
            return patientRepository.findBySurname(surname);
        }
        if (name != null) {
            return patientRepository.findByName(name);
        }
        return patientRepository.findAll();
    }

    @Override
    public void deletePatient(List<Patient> patients) {
        patientRepository.deleteAll(patients);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }
}

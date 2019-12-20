package com.clinic.meler.repositories;
import com.clinic.meler.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByPersonalCode(String pk);

    List<Patient> findByName(String name);

    List<Patient> findBySurname(String surname);
}

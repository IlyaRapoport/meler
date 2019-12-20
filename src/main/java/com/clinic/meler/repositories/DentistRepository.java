package com.clinic.meler.repositories;
import com.clinic.meler.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
    List<Dentist> findBySurname(String surname);
}

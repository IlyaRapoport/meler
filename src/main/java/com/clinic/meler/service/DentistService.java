package com.clinic.meler.service;
import com.clinic.meler.model.Dentist;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    List<Dentist> findAll();
    Dentist createDentist(Dentist dentist);
    List<Dentist> findBySurname(String surname);
    Optional<Dentist> findById(Long id);
    void deleteDentist(List<Dentist> dentists);
    Dentist updateDentist(Dentist dentist);

}

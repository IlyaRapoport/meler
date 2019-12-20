package com.clinic.meler.service;
import com.clinic.meler.model.Dentist;
import com.clinic.meler.repositories.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistServiceImpl implements DentistService {
    @Autowired
    private
    DentistRepository dentistRepository;

    @Override
    public List<Dentist> findAll() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist createDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public List<Dentist> findBySurname(String surname) {
        if (surname == null) {
            return dentistRepository.findAll();
        }
        return dentistRepository.findBySurname(surname);
    }

    @Override
    public Optional<Dentist> findById(Long id) {
        return dentistRepository.findById(id);
    }

    @Override
    public void deleteDentist(List<Dentist> dentists) {
        dentistRepository.deleteAll(dentists);
    }

    @Override
    public Dentist updateDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
}

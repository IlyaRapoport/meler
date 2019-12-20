package com.clinic.meler.service;
import com.clinic.meler.exceptions.NotFoundException;
import com.clinic.meler.model.Dentist;
import com.clinic.meler.model.Patient;
import com.clinic.meler.model.TimeTable;
import com.clinic.meler.repositories.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TimeTableServiceImpl implements TimeTableService {
    @Autowired
    private
    TimeTableRepository timeTableRepository;
    @Autowired
    private
    DentistService dentistService;
    @Autowired
    private
    PatientService patientService;

    @Override
    public List<TimeTable> findBy(Date date, Dentist dentist, Patient patient) {
        if (date != null) {
            return timeTableRepository.findByDateTime(date);
        }
        if (dentist != null) {
            return timeTableRepository.findByDentist(dentist);
        }
        if (patient != null) {
            return timeTableRepository.findByPatient(patient);
        }
        return timeTableRepository.findAll();
    }

    @Override
    public TimeTable create(TimeTable timeTable) {
        return timeTableRepository.save(timeTable);
    }

    @Override
    public TimeTable update(TimeTable timeTable) {
        return timeTableRepository.save(timeTable);
    }

    @Override
    public void delete(Long id) throws Exception {
        timeTableRepository.delete(timeTableRepository.findById(id).orElseThrow(() -> new NotFoundException("TimeTable not found")));
    }
}

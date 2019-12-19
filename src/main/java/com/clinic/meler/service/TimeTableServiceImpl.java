package com.clinic.meler.service;
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
    public TimeTable create(Date date, String dentist, String patient) throws Exception {
        TimeTable timeTable = new TimeTable();

        if (date != null) {
            timeTable.setDateTime(date);
        }
        if (dentist != null) {
            timeTable.setDentist(dentistService.findById(Long.valueOf(dentist)).orElseThrow(()->new Exception("not found")));
        }
        if (patient != null) {
            timeTable.setPatient(patientService.findById(Long.valueOf(patient)).orElseThrow(()->new Exception("not found")));
        }

        return timeTableRepository.save(timeTable);
    }
}

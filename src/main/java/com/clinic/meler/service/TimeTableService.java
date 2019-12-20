package com.clinic.meler.service;
import com.clinic.meler.model.Dentist;
import com.clinic.meler.model.Patient;
import com.clinic.meler.model.TimeTable;

import java.util.Date;
import java.util.List;

public interface TimeTableService {
    List<TimeTable> findBy(Date date, Dentist dentist, Patient patient);

    TimeTable create(TimeTable timeTable);

    TimeTable update(TimeTable timeTable);

    void delete(Long id) throws Exception;
}


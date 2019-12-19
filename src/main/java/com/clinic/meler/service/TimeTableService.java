package com.clinic.meler.service;
import com.clinic.meler.model.Dentist;
import com.clinic.meler.model.Patient;
import com.clinic.meler.model.TimeTable;

import java.util.Date;
import java.util.List;

public interface TimeTableService {
    List<TimeTable> findBy(Date date, Dentist dentist, Patient patient);
    TimeTable create(Date date, String dentist, String patient) throws Exception;
}


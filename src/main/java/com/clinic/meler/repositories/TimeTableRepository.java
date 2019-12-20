package com.clinic.meler.repositories;
import com.clinic.meler.model.Dentist;
import com.clinic.meler.model.Patient;
import com.clinic.meler.model.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
    List<TimeTable> findByDateTime(Date date);

    List<TimeTable> findByDentist(Dentist dentist);

    List<TimeTable> findByPatient(Patient patient);
}


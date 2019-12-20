package com.clinic.meler.mapper;
import com.clinic.meler.dto.TimeTableDto;
import com.clinic.meler.exceptions.NotFoundException;
import com.clinic.meler.model.TimeTable;
import com.clinic.meler.service.DentistService;
import com.clinic.meler.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimeTableMapper {
    @Autowired
    private
    DentistService dentistService;
    @Autowired
    private PatientService patientService;

    public TimeTable dtoToTimeTable(TimeTableDto timeTableDto) throws NotFoundException {
        TimeTable timeTable = new TimeTable();
        timeTable.setId(timeTableDto.getId());
        timeTable.setDateTime(timeTableDto.getDateTime());
        timeTable.setDropdown(timeTableDto.getDropdown());
        timeTable.setDescription(timeTableDto.getDescription());
        timeTable.setDentist(dentistService.findById(timeTableDto.getDentistId()).orElseThrow(() -> new NotFoundException("Dentist not found")));
        timeTable.setPatient(patientService.findById(timeTableDto.getPatientId()).orElseThrow(() -> new NotFoundException("Patient not found")));
        return timeTable;
    }

    public List<TimeTableDto> timeTableToDtoList(List<TimeTable> timeTables) {
        List<TimeTableDto> timeTableDtoList = new ArrayList<>();
        for (TimeTable timeTable : timeTables) {
            TimeTableDto timeTableDto = new TimeTableDto();
            timeTableDto.setId(timeTable.getId());
            timeTableDto.setDateTime(timeTable.getDateTime());
            timeTableDto.setDropdown(timeTable.getDropdown());
            timeTableDto.setDescription(timeTable.getDescription());
            timeTableDto.setDentistId(timeTable.getDentist().getId());
            timeTableDto.setPatientId(timeTable.getPatient().getId());
            timeTableDtoList.add(timeTableDto);
        }

        return timeTableDtoList;
    }

    public TimeTableDto timeTableToDto(TimeTable timeTable) {

        TimeTableDto timeTableDto = new TimeTableDto();
        timeTableDto.setId(timeTable.getId());
        timeTableDto.setDateTime(timeTable.getDateTime());
        timeTableDto.setDropdown(timeTable.getDropdown());
        timeTableDto.setDescription(timeTable.getDescription());
        timeTableDto.setDentistId(timeTable.getDentist().getId());
        timeTableDto.setPatientId(timeTable.getPatient().getId());

        return timeTableDto;
    }
}

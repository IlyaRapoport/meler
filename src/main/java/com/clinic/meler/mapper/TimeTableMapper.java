package com.clinic.meler.mapper;
import com.clinic.meler.dto.TimeTableDto;
import com.clinic.meler.model.TimeTable;
import com.clinic.meler.service.DentistService;
import com.clinic.meler.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TimeTableMapper {
    @Autowired
    private
    DentistService dentistService;
@Autowired
private PatientService patientService;

    public TimeTable dtoToTimeTable(TimeTableDto timeTableDto) throws Exception {
        TimeTable timeTable = new TimeTable();
        timeTable.setId(timeTableDto.getId());
        timeTable.setDateTime(timeTableDto.getDateTime());
        timeTable.setDentist(dentistService.findById(timeTableDto.getDentistId()).orElseThrow(()->new Exception("not found")));
        timeTable.setPatient(patientService.findById(timeTableDto.getPatientId()).orElseThrow(()->new Exception("not found")));
        return timeTable;
    }
    public List<TimeTableDto> timeTableToDtoList(List<TimeTable> timeTables){
        List<TimeTableDto> timeTableDtoList=new ArrayList<>();
        for (TimeTable timeTable : timeTables) {
            TimeTableDto timeTableDto= new TimeTableDto();
            timeTableDto.setId(timeTable.getId());
            timeTableDto.setDateTime(timeTable.getDateTime());
            timeTableDto.setDentistId(timeTable.getDentist().getId());
            timeTableDto.setPatientId(timeTable.getPatient().getId());
            timeTableDtoList.add(timeTableDto);
        }

        return timeTableDtoList;
    }

    public TimeTableDto timeTableToDto(TimeTable timeTable){

            TimeTableDto timeTableDto= new TimeTableDto();
            timeTableDto.setId(timeTable.getId());
            timeTableDto.setDateTime(timeTable.getDateTime());
            timeTableDto.setDentistId(timeTable.getDentist().getId());
            timeTableDto.setPatientId(timeTable.getPatient().getId());



        return timeTableDto;
    }
}

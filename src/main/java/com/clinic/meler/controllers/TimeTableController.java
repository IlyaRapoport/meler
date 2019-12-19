package com.clinic.meler.controllers;
import com.clinic.meler.dto.TimeTableDto;
import com.clinic.meler.mapper.TimeTableMapper;
import com.clinic.meler.model.Dentist;
import com.clinic.meler.model.Patient;
import com.clinic.meler.model.TimeTable;
import com.clinic.meler.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TimeTableController {

    @Autowired
    private
    TimeTableService timeTableService;
    @Autowired
    private
    TimeTableMapper timeTableMapper;

    @GetMapping("/timetable")
    public List<TimeTableDto> getTimeTable(@RequestParam(name = "date", required = false) Date date,
                                         @RequestParam(name = "dentist_id", required = false) Dentist dentist,
                                         @RequestParam(name = "patient_id", required = false) Patient patient) {

        return timeTableMapper.timeTableToDtoList(timeTableService.findBy(date, dentist, patient));
    }

    @PostMapping
    public TimeTable createTimeTable(@RequestParam(name = "date", required = false) Date date,
                                     @RequestParam(name = "dentist_id", required = false) String dentist,
                                     @RequestParam(name = "patient_id", required = false) String patient){
        return timeTableService.create(date, dentist, patient);
    }
}

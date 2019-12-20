package com.clinic.meler.controllers;
import com.clinic.meler.dto.TimeTableDto;
import com.clinic.meler.exceptions.NotFoundException;
import com.clinic.meler.mapper.TimeTableMapper;
import com.clinic.meler.model.Dentist;
import com.clinic.meler.model.Dropdown;
import com.clinic.meler.model.Patient;
import com.clinic.meler.service.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
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

    @PostMapping("/timetable")
    public TimeTableDto createTimeTable(@RequestBody TimeTableDto timeTableDto) throws NotFoundException {
        return timeTableMapper.timeTableToDto(timeTableService.create(timeTableMapper.dtoToTimeTable(timeTableDto)));
    }

    @PutMapping("/timetable")
    public TimeTableDto updateTimeTable(@RequestBody TimeTableDto timeTableDto) throws NotFoundException {
        return timeTableMapper.timeTableToDto(timeTableService.update(timeTableMapper.dtoToTimeTable(timeTableDto)));
    }

    @DeleteMapping("/timetable")
    public void deleteTimeTable(@RequestParam(name = "id", required = false) Long id) throws Exception {

        timeTableService.delete(id);
    }

    @GetMapping("/dropdown")
    public List<String> getDropdown() {
        return Dropdown.getList();
    }

    @GetMapping("/time")
    public Date getTime() {
        return Date.from(Instant.now());
    }
}

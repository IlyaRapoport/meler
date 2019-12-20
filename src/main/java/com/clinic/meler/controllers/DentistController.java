package com.clinic.meler.controllers;
import com.clinic.meler.dto.DentistDto;
import com.clinic.meler.mapper.DentistMapper;
import com.clinic.meler.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DentistController {

    @Autowired
    private
    DentistService dentistService;
    @Autowired
    private
    DentistMapper dentistMapper;

    @GetMapping("/dentist")
    public List<DentistDto> getDentist(@RequestParam(name = "surname", required = false) String surname) {
        return dentistMapper.dentistToDtoList(dentistService.findBySurname(surname));
    }

    @PostMapping("/dentist")
    public DentistDto createDentist(@RequestBody DentistDto dentistDto) {
        return dentistMapper.dentistToDto(dentistService.createDentist(dentistMapper.dtoToDentist(dentistDto)));
    }

    @DeleteMapping("/dentist")
    public String deleteDentist(@RequestParam String surname) {
        dentistService.deleteDentist(dentistService.findBySurname(surname));
        return "ok";
    }

    @PutMapping("/dentist")
    public DentistDto updateDentist(@RequestBody DentistDto dentistDto) {
        return dentistMapper.dentistToDto(dentistService.updateDentist(dentistMapper.dtoToDentist(dentistDto)));
    }
}

package com.clinic.meler.controllers;
import com.clinic.meler.dto.PatientDto;
import com.clinic.meler.mapper.PatientMapper;
import com.clinic.meler.model.Patient;
import com.clinic.meler.service.PatientService;
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
public class PatientController {
    @Autowired
    private
    PatientService patientService;
    @Autowired
    private
    PatientMapper patientMapper;

    @GetMapping("/patient")
    public List<PatientDto> getPatient(@RequestParam(name = "pk", required = false) String pk,
                                       @RequestParam(name = "name", required = false) String name,
                                       @RequestParam(name = "surname", required = false) String surname) {
        return patientMapper.patientToDtoList(patientService.findBy(pk, name, surname));
    }

    @PutMapping("/patient")
    public Patient updatePatient(@RequestBody PatientDto patientDto) {
        return patientService.updatePatient(patientMapper.dtoToPatient(patientDto));
    }

    @PostMapping("/patient")
    public Patient createPatient(@RequestBody PatientDto patientDto) {
        return patientService.createPatient(patientMapper.dtoToPatient(patientDto));
    }

    @DeleteMapping("/patient")
    public String deletePatient(@RequestParam String pk) {
        patientService.deletePatient(patientService.findBy(pk,null,null));
        return "ok";
    }
}

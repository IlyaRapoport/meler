package com.clinic.meler.mapper;
import com.clinic.meler.dto.PatientDto;
import com.clinic.meler.model.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapper {
    public Patient dtoToPatient(PatientDto patientDto) {
        return Patient.builder()
                .id(patientDto.getId())
                .name(patientDto.getName())
                .surname(patientDto.getSurname())
                .personalCode(patientDto.getPersonalCode())
                .telephone(patientDto.getTelephone())
                .address(patientDto.getAddress())
                .description(patientDto.getDescription())
                .build();
    }

    public List<PatientDto> patientToDtoList(List<Patient> patients) {
        List<PatientDto> patientDtoList = new ArrayList<>();
        for (Patient patient : patients) {
            PatientDto patientDto = new PatientDto();
            patientDto.setId(patient.getId());
            patientDto.setName(patient.getName());
            patientDto.setSurname(patient.getSurname());
            patientDto.setPersonalCode(patient.getPersonalCode());
            patientDto.setAddress(patient.getAddress());
            patientDto.setTelephone(patient.getTelephone());
            patientDto.setDescription(patient.getDescription());
            patientDtoList.add(patientDto);
        }
        return patientDtoList;
    }
}

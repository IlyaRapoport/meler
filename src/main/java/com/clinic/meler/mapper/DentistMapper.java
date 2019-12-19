package com.clinic.meler.mapper;
import com.clinic.meler.dto.DentistDto;
import com.clinic.meler.model.Dentist;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DentistMapper {
    public Dentist dtoToDentist(DentistDto dentistDto) {
        return Dentist.builder()
                .id(dentistDto.getId())
                .name(dentistDto.getName())
                .surname(dentistDto.getSurname())
                .cabinet(dentistDto.getCabinet())
                .build();
    }

    public List<DentistDto> dentistToDtoList(List<Dentist> dentists) {
        List<DentistDto> dentistDtoList = new ArrayList<>();
        for (Dentist dentist : dentists) {
            DentistDto dentistDto = new DentistDto();
            dentistDto.setId(dentist.getId());
            dentistDto.setName(dentist.getName());
            dentistDto.setSurname(dentist.getSurname());
            dentistDto.setCabinet(dentist.getCabinet());
            dentistDtoList.add(dentistDto);
        }

        return dentistDtoList;
    }

    public DentistDto dentistToDto(Dentist dentist) {

        DentistDto dentistDto = new DentistDto();
        dentistDto.setId(dentist.getId());
        dentistDto.setName(dentist.getName());
        dentistDto.setSurname(dentist.getSurname());
        dentistDto.setCabinet(dentist.getCabinet());

        return dentistDto;
    }
}

package com.clinic.meler.mapper;
import com.clinic.meler.dto.ImageDto;
import com.clinic.meler.exceptions.NotFoundException;
import com.clinic.meler.model.Image;
import com.clinic.meler.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImageMapper {

    @Autowired
    private
    PatientService patientService;

    public Image dtoToImage(ImageDto imageDto) throws NotFoundException {
        Image image = new Image();
        image.setId(imageDto.getId());
        image.setDescription(imageDto.getDescription());
        image.setPatient(patientService.findById(imageDto.getPatientId()).orElseThrow(() -> new NotFoundException("Patient not found")));
        return image;
    }

    public ImageDto imageDto(Image image) {

        ImageDto imageDto = new ImageDto();
        imageDto.setId(image.getId());
        imageDto.setDescription(image.getDescription());
        imageDto.setPatientId(image.getPatient().getId());
        imageDto.setImg(image.getImg().toString());
        return imageDto;
    }

    public List<ImageDto> imageDtoList(List<Image> images) {
        List<ImageDto> imageDtoList = new ArrayList<>();
        for (Image image : images) {
            ImageDto imageDto = new ImageDto();
            imageDto.setId(image.getId());
            imageDto.setDescription(image.getDescription());
            imageDto.setPatientId(image.getPatient().getId());
            imageDto.setImg(image.getImg().toString());
            imageDtoList.add(imageDto);
        }
        return imageDtoList;
    }
}

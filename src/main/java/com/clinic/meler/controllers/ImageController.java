package com.clinic.meler.controllers;
import com.clinic.meler.dto.ImageDto;
import com.clinic.meler.exceptions.NotFoundException;
import com.clinic.meler.mapper.ImageMapper;
import com.clinic.meler.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ImageController {
    @Autowired
    private
    ImageService imageService;
    @Autowired
    private ImageMapper imageMapper;

    @PostMapping("/image")
    public ImageDto createImage(@RequestBody ImageDto imageDto) throws IOException, NotFoundException {
        String file = "C:/Users/ilya.rapoports/Downloads/Logos (2) (1)/Logos/360.JPG";

        return imageMapper.imageDto(imageService.createImage(file, imageMapper.dtoToImage(imageDto)));
    }

    @GetMapping("/image")
    public List<ImageDto> getImage(@RequestParam(name = "patient_id", required = false) Long patientId) throws NotFoundException {

        return imageMapper.imageDtoList(imageService.findByPatientId(patientId));
    }

    @DeleteMapping("/image")
    public void deleteImage(@RequestParam(name = "id", required = false) Long id) throws IOException, NotFoundException {

        imageService.deleteImage(id);
    }

    @PutMapping("/image")
    public ImageDto updateImage(@RequestBody ImageDto imageDto) throws IOException, NotFoundException {
        String file = "C:/Users/ilya.rapoports/Downloads/Logos (2) (1)/Logos/360.JPG";

        return imageMapper.imageDto(imageService.createImage(file, imageMapper.dtoToImage(imageDto)));
    }
}

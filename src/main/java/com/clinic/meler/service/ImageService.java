package com.clinic.meler.service;
import com.clinic.meler.exceptions.NotFoundException;
import com.clinic.meler.model.Image;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    Image createImage(String file, Image image) throws IOException;

    void deleteImage(Long id) throws IOException, NotFoundException;

    List<Image> findByPatientId(Long patientId) throws NotFoundException;
}

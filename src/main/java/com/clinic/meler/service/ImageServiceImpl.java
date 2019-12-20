package com.clinic.meler.service;
import com.clinic.meler.exceptions.NotFoundException;
import com.clinic.meler.model.Image;
import com.clinic.meler.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image createImage(String file, Image image) throws IOException {

        File fnew = new File(file);
        BufferedImage originalImage = ImageIO.read(fnew);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage, "jpg", baos);
        image.setImg(baos.toByteArray());

        return imageRepository.save(image);
    }

    @Override
    public List<Image> findByPatientId(Long patientId) throws NotFoundException {

        if (patientId != null) {
            return imageRepository.findByPatientId(patientId);
        }
        return imageRepository.findAll();
    }

    @Override
    public void deleteImage(Long id) throws IOException, NotFoundException {
        imageRepository.delete(imageRepository.findById(id).orElseThrow(() -> new NotFoundException("Image not found")));
    }
}

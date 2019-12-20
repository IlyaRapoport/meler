package com.clinic.meler.repositories;
import com.clinic.meler.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByPatientId(Long patientId);
}

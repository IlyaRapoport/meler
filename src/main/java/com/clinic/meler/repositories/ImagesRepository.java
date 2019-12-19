package com.clinic.meler.repositories;
import com.clinic.meler.model.Dentist;
import com.clinic.meler.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<Images,Long> {
}

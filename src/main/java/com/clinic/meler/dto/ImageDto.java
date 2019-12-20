package com.clinic.meler.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageDto {
    private Long id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("patient_id")
    private Long patientId;

    @JsonProperty("patient_img")
    private String img;

    public ImageDto() {
    }

    public ImageDto(Long id, String description, Long patientId, String img) {
        this.id = id;
        this.description = description;
        this.patientId = patientId;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}

package com.clinic.meler.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TimeTableDto {
    private Long id;

    @JsonProperty("date_time")
    private Date dateTime;
    @JsonProperty("dropdown")
    private String dropdown;
    @JsonProperty("description")
    private String description;

    @JsonProperty("patient_id")
    private Long patientId;
    @JsonProperty("dentist_id")
    private Long dentistId;

    public TimeTableDto() {
    }

    public TimeTableDto(Long id, Date dateTime, String dropdown, String description, Long patientId, Long dentistId) {
        this.id = id;
        this.dateTime = dateTime;
        this.dropdown = dropdown;
        this.description = description;
        this.patientId = patientId;
        this.dentistId = dentistId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDropdown() {
        return dropdown;
    }

    public void setDropdown(String dropdown) {
        this.dropdown = dropdown;
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

    public Long getDentistId() {
        return dentistId;
    }

    public void setDentistId(Long dentistId) {
        this.dentistId = dentistId;
    }
}

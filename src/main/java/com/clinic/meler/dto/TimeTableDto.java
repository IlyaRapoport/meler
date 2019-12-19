package com.clinic.meler.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TimeTableDto {
    private Long id;

    @JsonProperty("date_time")
    private Date dateTime;
    @JsonProperty("patient_id")
    private Long patientId;
    @JsonProperty("dentist_id")
    private Long dentistId;

    public TimeTableDto() {
    }

    public TimeTableDto(Long id, Date dateTime, Long patientId, Long dentistId) {
        this.id = id;
        this.dateTime = dateTime;
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

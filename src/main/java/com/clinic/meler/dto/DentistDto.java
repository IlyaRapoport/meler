package com.clinic.meler.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DentistDto {
    private Long id;

    @JsonProperty("dentist_name")
    private String name;

    @JsonProperty("dentist_surname")
    private String surname;

    @JsonProperty("dentist_cabinet")
    private String cabinet;

    public DentistDto() {
    }

    public DentistDto(Long id,String name, String surname, String cabinet) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.cabinet = cabinet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }
}

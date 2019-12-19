package com.clinic.meler.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PatientDto {

    private Long id;

    @JsonProperty("patient_name")
    private String name;
    @JsonProperty("patient_surname")
    private String surname;

    @JsonProperty("patient_pk")
    private String personalCode;

    @JsonProperty("patient_telephone")
    private String telephone;

    @JsonProperty("patient_address")
    private String address;

    @JsonProperty("patient_description")
    private String description;

    public PatientDto() {
    }

    public PatientDto(Long id, String name, String surname, String personalCode, String telephone, String address, String description) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personalCode = personalCode;
        this.telephone = telephone;
        this.address = address;
        this.description = description;
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

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

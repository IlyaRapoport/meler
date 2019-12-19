package com.clinic.meler.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String personalCode;

    @Column
    private String telephone;

    @Column
    private String address;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "images_id")
    private Images images;

    @OneToMany(mappedBy = "patient")
    private List<TimeTable> timeTables;

    public Patient() {
    }

    public Patient(Long id, String name, String surname, String personalCode, String telephone, String address, String description, Images images, List<TimeTable> timeTables) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personalCode = personalCode;
        this.telephone = telephone;
        this.address = address;
        this.description = description;
        this.images = images;
        this.timeTables = timeTables;
    }

    public static PatientBuilder builder() {
        return new PatientBuilder();
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

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public List<TimeTable> getTimeTables() {
        return timeTables;
    }

    public void setTimeTables(List<TimeTable> timeTables) {
        this.timeTables = timeTables;
    }

    public static class PatientBuilder {
        private Long id;
        private String name;
        private String surname;
        private String personalCode;
        private String telephone;
        private String address;
        private String description;
        private Images images;
        private List<TimeTable> timeTable;

        PatientBuilder() {
        }

        public PatientBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PatientBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PatientBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public PatientBuilder personalCode(String personalCode) {
            this.personalCode = personalCode;
            return this;
        }

        public PatientBuilder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public PatientBuilder address(String address) {
            this.address = address;
            return this;
        }

        public PatientBuilder description(String description) {
            this.description = description;
            return this;
        }

        public PatientBuilder images(Images images) {
            this.images = images;
            return this;
        }

        public PatientBuilder timeTable(List<TimeTable> timeTable) {
            this.timeTable = timeTable;
            return this;
        }

        public Patient build() {
            return new Patient(id, name, surname, personalCode, telephone, address, description, images, timeTable);
        }

        public String toString() {
            return "Patient.PatientBuilder(id=" + this.id + ", name=" + this.name + ", surname=" + this.surname + ", personalCode=" + this.personalCode + ", telephone=" + this.telephone + ", address=" + this.address + ", description=" + this.description + ", images=" + this.images + ", timeTable=" + this.timeTable + ")";
        }
    }
}
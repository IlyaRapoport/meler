package com.clinic.meler.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "dentist")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String cabinet;

@OneToMany(mappedBy = "dentist")
    private List<TimeTable> timeTables;

    public Dentist() {
    }

    public Dentist(Long id, String name, String surname, String cabinet, List<TimeTable> timeTables) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cabinet = cabinet;
        this.timeTables = timeTables;
    }

    public static DentistBuilder builder() {
        return new DentistBuilder();
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

    public List<TimeTable> getTimeTables() {
        return timeTables;
    }

    public void setTimeTables(List<TimeTable> timeTables) {
        this.timeTables = timeTables;
    }

    public static class DentistBuilder {
        private Long id;
        private String name;
        private String surname;
        private String cabinet;
        private List<TimeTable> timeTable;

        DentistBuilder() {
        }

        public DentistBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DentistBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DentistBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public DentistBuilder cabinet(String cabinet) {
            this.cabinet = cabinet;
            return this;
        }

        public DentistBuilder timeTable(List<TimeTable> timeTable) {
            this.timeTable = timeTable;
            return this;
        }

        public Dentist build() {
            return new Dentist(id, name, surname, cabinet, timeTable);
        }

        public String toString() {
            return "Dentist.DentistBuilder(id=" + this.id + ", name=" + this.name + ", surname=" + this.surname + ", cabinet=" + this.cabinet + ", timeTable=" + this.timeTable + ")";
        }
    }
}
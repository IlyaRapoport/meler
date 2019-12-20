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
    @OneToMany(mappedBy = "patient")
    private List<Image> image;

    public Patient(Long id, String name, String surname, String personalCode, String telephone, String address, String description, List<Image> image) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personalCode = personalCode;
        this.telephone = telephone;
        this.address = address;
        this.description = description;
        this.image = image;
    }

    public Patient() {
    }

    public static PatientBuilder builder() {
        return new PatientBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonalCode() {
        return this.personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImage() {
        return this.image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Patient)) return false;
        final Patient other = (Patient) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$surname = this.getSurname();
        final Object other$surname = other.getSurname();
        if (this$surname == null ? other$surname != null : !this$surname.equals(other$surname)) return false;
        final Object this$personalCode = this.getPersonalCode();
        final Object other$personalCode = other.getPersonalCode();
        if (this$personalCode == null ? other$personalCode != null : !this$personalCode.equals(other$personalCode))
            return false;
        final Object this$telephone = this.getTelephone();
        final Object other$telephone = other.getTelephone();
        if (this$telephone == null ? other$telephone != null : !this$telephone.equals(other$telephone)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$image = this.getImage();
        final Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Patient;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $surname = this.getSurname();
        result = result * PRIME + ($surname == null ? 43 : $surname.hashCode());
        final Object $personalCode = this.getPersonalCode();
        result = result * PRIME + ($personalCode == null ? 43 : $personalCode.hashCode());
        final Object $telephone = this.getTelephone();
        result = result * PRIME + ($telephone == null ? 43 : $telephone.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $image = this.getImage();
        result = result * PRIME + ($image == null ? 43 : $image.hashCode());
        return result;
    }

    public String toString() {
        return "Patient(id=" + this.getId() + ", name=" + this.getName() + ", surname=" + this.getSurname() + ", personalCode=" + this.getPersonalCode() + ", telephone=" + this.getTelephone() + ", address=" + this.getAddress() + ", description=" + this.getDescription() + ", image=" + this.getImage() + ")";
    }

    public static class PatientBuilder {
        private Long id;
        private String name;
        private String surname;
        private String personalCode;
        private String telephone;
        private String address;
        private String description;
        private List<Image> image;

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

        public PatientBuilder image(List<Image> image) {
            this.image = image;
            return this;
        }

        public Patient build() {
            return new Patient(id, name, surname, personalCode, telephone, address, description, image);
        }

        public String toString() {
            return "Patient.PatientBuilder(id=" + this.id + ", name=" + this.name + ", surname=" + this.surname + ", personalCode=" + this.personalCode + ", telephone=" + this.telephone + ", address=" + this.address + ", description=" + this.description + ", image=" + this.image + ")";
        }
    }
}
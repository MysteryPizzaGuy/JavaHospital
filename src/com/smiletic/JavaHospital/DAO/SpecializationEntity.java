package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SPECIALIZATION", schema = "main", catalog = "")
public class SpecializationEntity {
    private Short idSpecialization;
    private String title;
    private String desciption;
    private Set<DoctorEntity> doctors;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDSpecialization")
    public Short getIdSpecialization() {
        return idSpecialization;
    }

    public void setIdSpecialization(Short idSpecialization) {
        this.idSpecialization = idSpecialization;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Desciption")
    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return title;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "specialization")
    public Set<DoctorEntity> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<DoctorEntity> doctors) {
        this.doctors = doctors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecializationEntity that = (SpecializationEntity) o;
        return Objects.equals(idSpecialization, that.idSpecialization) &&
                Objects.equals(title, that.title) &&
                Objects.equals(desciption, that.desciption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSpecialization, title, desciption);
    }
}

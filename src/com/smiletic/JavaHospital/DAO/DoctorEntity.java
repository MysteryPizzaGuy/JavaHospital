package com.smiletic.JavaHospital.DAO;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DOCTOR", schema = "main", catalog = "")
public class DoctorEntity {
    private Short idDoctor;
    private String name;
    private SpecializationEntity specialization;
    private Set<AvailabilityEntity> availabilities;
    private Set<AppointmentEntity> appointments;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDDoctor")
    public Short getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Short idDoctor) {
        this.idDoctor = idDoctor;
    }

    @ManyToOne
    @JoinColumn(name = "SpecializationID")
    public SpecializationEntity getSpecialization() {
        return specialization;
    }

    public void setSpecialization(SpecializationEntity specialization) {
        this.specialization = specialization;
    }

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL,mappedBy ="doctor")

    public Set<AppointmentEntity> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<AppointmentEntity> appointments) {
        this.appointments = appointments;
    }

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL,mappedBy ="doctor")

    public Set<AvailabilityEntity> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(Set<AvailabilityEntity> availabilities) {
        this.availabilities = availabilities;
    }


    @Override
    public String toString() {
        return  name ;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEntity that = (DoctorEntity) o;
        return Objects.equals(idDoctor, that.idDoctor) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoctor, name);
    }
}

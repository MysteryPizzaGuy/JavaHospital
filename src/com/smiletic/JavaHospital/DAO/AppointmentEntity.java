package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "APPOINTMENT", schema = "main", catalog = "")
public class AppointmentEntity {
    private Short idAppointment;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;
    private DoctorEntity doctor;
    private PersonEntity patient;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDAppointment")
    public Short getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(Short idAppointment) {
        this.idAppointment = idAppointment;
    }

    @Basic
    @Column(name = "fromDate")
    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    @Override
    public String toString() {
        return idAppointment +
                " " + doctor +
                " " + patient;
    }

    @ManyToOne
    @JoinColumn(name = "DoctorID")
    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }
    @ManyToOne
    @JoinColumn(name = "PatientID")

    public PersonEntity getPatient() {
        return patient;
    }

    public void setPatient(PersonEntity patient) {
        this.patient = patient;
    }

    @Basic
    @Column(name = "toDate")
    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentEntity that = (AppointmentEntity) o;
        return Objects.equals(idAppointment, that.idAppointment) &&
                Objects.equals(fromDate, that.fromDate) &&
                Objects.equals(toDate, that.toDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAppointment, fromDate, toDate);
    }
}

package com.smiletic.JavaHospital.DAO;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AVAILABILITY", schema = "main", catalog = "")
public class AvailabilityEntity {
    private Short idAvailability;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;
    private DoctorEntity doctor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDAvailability")
    public Short getIdAvailability() {
        return idAvailability;
    }

    public void setIdAvailability(Short idAvailability) {
        this.idAvailability = idAvailability;
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
        return  Integer.toString(idAvailability);
    }

    @ManyToOne

    @JoinColumn(name = "DoctorID")
    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }




    @Basic
    @Column(name = "toDate")
    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    @Basic
    @Column(name = "fromTime")
    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    @Basic
    @Column(name = "toTime")
    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvailabilityEntity that = (AvailabilityEntity) o;
        return Objects.equals(idAvailability, that.idAvailability) &&
                Objects.equals(fromDate, that.fromDate) &&
                Objects.equals(toDate, that.toDate) &&
                Objects.equals(fromTime, that.fromTime) &&
                Objects.equals(toTime, that.toTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAvailability, fromDate, toDate, fromTime, toTime);
    }
}

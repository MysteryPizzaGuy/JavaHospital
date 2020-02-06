package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MARITALSTATUS", schema = "main", catalog = "")
public class MaritalstatusEntity {
    private Short idMaritalStatus;
    private String maritalStatus;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDMaritalStatus")
    public Short getIdMaritalStatus() {
        return idMaritalStatus;
    }

    public void setIdMaritalStatus(Short idMaritalStatus) {
        this.idMaritalStatus = idMaritalStatus;
    }

    @Basic
    @Column(name = "MaritalStatus")
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return  maritalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaritalstatusEntity that = (MaritalstatusEntity) o;
        return Objects.equals(idMaritalStatus, that.idMaritalStatus) &&
                Objects.equals(maritalStatus, that.maritalStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMaritalStatus, maritalStatus);
    }
}

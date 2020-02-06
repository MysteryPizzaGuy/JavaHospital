package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BLOODTYPE", schema = "main", catalog = "")
public class BloodtypeEntity {
    private Short idBloodType;
    private String bloodType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDBloodType")
    public Short getIdBloodType() {
        return idBloodType;
    }

    public void setIdBloodType(Short idBloodType) {
        this.idBloodType = idBloodType;
    }

    @Basic
    @Column(name = "BloodType")
    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Override
    public String toString() {
        return  bloodType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BloodtypeEntity that = (BloodtypeEntity) o;
        return Objects.equals(idBloodType, that.idBloodType) &&
                Objects.equals(bloodType, that.bloodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBloodType, bloodType);
    }
}

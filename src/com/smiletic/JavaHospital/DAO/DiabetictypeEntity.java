package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DIABETICTYPE", schema = "main", catalog = "")
public class DiabetictypeEntity {
    private Short idDiabeticType;
    private String diabeticType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDDiabeticType")
    public Short getIdDiabeticType() {
        return idDiabeticType;
    }

    public void setIdDiabeticType(Short idDiabeticType) {
        this.idDiabeticType = idDiabeticType;
    }

    @Basic
    @Column(name = "DiabeticType")
    public String getDiabeticType() {
        return diabeticType;
    }

    public void setDiabeticType(String diabeticType) {
        this.diabeticType = diabeticType;
    }

    @Override
    public String toString() {
        return diabeticType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiabetictypeEntity that = (DiabetictypeEntity) o;
        return Objects.equals(idDiabeticType, that.idDiabeticType) &&
                Objects.equals(diabeticType, that.diabeticType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiabeticType, diabeticType);
    }
}

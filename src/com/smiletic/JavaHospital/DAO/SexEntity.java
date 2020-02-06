package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SEX", schema = "main", catalog = "")
public class SexEntity {
    private Short idSex;
    private String sex;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDSex")
    public Short getIdSex() {
        return idSex;
    }

    public void setIdSex(Short idSex) {
        this.idSex = idSex;
    }

    @Basic
    @Column(name = "Sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SexEntity sexEntity = (SexEntity) o;
        return Objects.equals(idSex, sexEntity.idSex) &&
                Objects.equals(sex, sexEntity.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSex, sex);
    }

    @Override
    public String toString() {
        return sex;
    }
}

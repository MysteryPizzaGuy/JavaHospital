package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "AREA", schema = "main", catalog = "")
public class AreaEntity {
    private Short idArea;
    private String area;
    private CityEntity city;
    private Set<StreetEntity> streets;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDArea")
    public Short getIdArea() {
        return idArea;
    }

    public void setIdArea(Short idArea) {
        this.idArea = idArea;
    }

    @Basic
    @Column(name = "Area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    @ManyToOne
    @JoinColumn(name = "CityID")
    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<StreetEntity> getStreets() {
        return streets;
    }

    public void setStreets(Set<StreetEntity> streets) {
        this.streets = streets;
    }

    @Override
    public String toString() {
        return  " "+ String.valueOf(area) +
                " "+String.valueOf( city);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaEntity that = (AreaEntity) o;
        return Objects.equals(idArea, that.idArea) &&
                Objects.equals(area, that.area) &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArea, area, city);
    }
}

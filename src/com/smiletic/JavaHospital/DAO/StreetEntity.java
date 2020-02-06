package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.awt.geom.Area;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "STREET", schema = "main", catalog = "")
public class StreetEntity {
    private Short idStreet;
    private String street;
    private AreaEntity area;
    private Set<StreetEntity> streets;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDStreet")
    public Short getIdStreet() {
        return idStreet;
    }

    public void setIdStreet(Short idStreet) {
        this.idStreet = idStreet;
    }

    @Basic
    @Column(name = "Street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    @ManyToOne
    @JoinColumn(name = "AreaID")
    public AreaEntity getArea() {
        return area;
    }

    public void setArea(AreaEntity area) {
        this.area = area;
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
        return street +" "+ area ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetEntity that = (StreetEntity) o;
        return Objects.equals(idStreet, that.idStreet) &&
                Objects.equals(street, that.street) &&
                Objects.equals(area, that.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStreet, street, area);
    }
}

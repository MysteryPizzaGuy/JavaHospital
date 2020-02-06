package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PINCODE", schema = "main", catalog = "")
public class PincodeEntity {
    private Short idPincode;
    private String pincodes;

    private Set<CityEntity> cities;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDPincode")
    public Short getIdPincode() {
        return idPincode;
    }

    public void setIdPincode(Short idPincode) {
        this.idPincode = idPincode;
    }

    @Basic
    @Column(name = "Pincode")
    public String getPincode() {
        return pincodes;
    }

    public void setPincode(String pincode) {
        this.pincodes = pincode;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<CityEntity> getCities() {
        return cities;
    }

    public void setCities(Set<CityEntity> cities) {
        this.cities = cities;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PincodeEntity that = (PincodeEntity) o;
        return Objects.equals(idPincode, that.idPincode) &&
                Objects.equals(pincodes, that.pincodes);
    }

    @Override
    public String toString() {
        return pincodes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPincode, pincodes);
    }
}

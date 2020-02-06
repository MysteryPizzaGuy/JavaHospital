package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import javax.swing.plaf.nimbus.State;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CITY", schema = "main", catalog = "")
public class CityEntity {
    private Short idCity;
    private String city;
//    private Short stateId;
//    private Short pincodeId;
    private PincodeEntity pincode;
    private StateEntity state;
    private Set<AreaEntity> areas;




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCity")
    public Short getIdCity() {
        return idCity;
    }

    public void setIdCity(Short idCity) {
        this.idCity = idCity;
    }

    @Basic
    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<AreaEntity> getArea() {
        return areas;
    }

    public void setArea(Set<AreaEntity> area) {
        this.areas = area;
    }

    @ManyToOne
    @JoinColumn(name = "StateID")
    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }

    @ManyToOne
    @JoinColumn(name = "PincodeID")
    public PincodeEntity getPincode() {
        return pincode;
    }

    public void setPincode(PincodeEntity pincode) {
        this.pincode = pincode;
    }
//    @Basic
//    @Column(name = "StateID")
//    public Short getStateId() {
//        return stateId;
//    }
//
//    public void setStateId(Short stateId) {
//        this.stateId = stateId;
//    }

//    @Basic
//    @Column(name = "PincodeID")
//    public Short getPincodeId() {
//        return pincodeId;
//    }
//
//    public void setPincodeId(Short pincodeId) {
//        this.pincodeId = pincodeId;

    @Override
    public String toString() {
        return   String.valueOf(city) + " "+
                pincode +" "+
                String.valueOf(state);
    }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return Objects.equals(idCity, that.idCity) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, city, state, pincode);
    }
}

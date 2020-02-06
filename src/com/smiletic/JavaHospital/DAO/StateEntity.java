package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "STATE", schema = "main", catalog = "")
public class StateEntity {
    private Short idState;
    private String state;
    private Set<CityEntity> cities;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDState")
    public Short getIdState() {
        return idState;
    }

    public void setIdState(Short idState) {
        this.idState = idState;
    }

    @Basic
    @Column(name = "State")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<CityEntity> getCities() {
        return cities;
    }

    public void setCities(Set<CityEntity> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateEntity that = (StateEntity) o;
        return Objects.equals(idState, that.idState) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idState, state);
    }
}

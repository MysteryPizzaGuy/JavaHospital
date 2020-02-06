package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ADDRESS", schema = "main", catalog = "")
public class AddressEntity {
    private Short idAddress;
    private String doorNo;
    private StreetEntity street;
    private Set<ContactdetailsEntity> contactdetails;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDAddress")
    public Short getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Short idAddress) {
        this.idAddress = idAddress;
    }

    @Basic
    @Column(name = "DoorNo")
    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }


    @OneToMany
    public Set<ContactdetailsEntity> getContactdetails() {
        return contactdetails;
    }

    public void setContactdetails(Set<ContactdetailsEntity> contactdetails) {
        this.contactdetails = contactdetails;
    }

    @ManyToOne
    @JoinColumn(name = "StreetID")
    public StreetEntity getStreet() {
        return street;
    }

    public void setStreet(StreetEntity street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return doorNo +  " " + String.valueOf(street);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(idAddress, that.idAddress) &&
                Objects.equals(doorNo, that.doorNo) &&
                Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAddress, doorNo, street);
    }
}

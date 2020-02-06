package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CONTACTDETAILS", schema = "main", catalog = "")
public class ContactdetailsEntity {
    private Short idContactDetails;
    private AddressEntity presentAddress;
    private String telephoneWork;
    private String telephoneHome;
    private String mobile;
    private String pager;
    private String fax;
    private String email;

    @Id
    @Column(name = "IDContactDetails")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Short getIdContactDetails() {
        return idContactDetails;
    }

    public void setIdContactDetails(Short idContactDetails) {
        this.idContactDetails = idContactDetails;
    }

    @ManyToOne
    @JoinColumn(name = "PresentAddressID")
    public AddressEntity getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(AddressEntity presentAddress) {
        this.presentAddress = presentAddress;
    }




    @Basic
    @Column(name = "Telephone_Work")
    public String getTelephoneWork() {
        return telephoneWork;
    }

    public void setTelephoneWork(String telephoneWork) {
        this.telephoneWork = telephoneWork;
    }

    @Basic
    @Column(name = "Telephone_Home")
    public String getTelephoneHome() {
        return telephoneHome;
    }

    public void setTelephoneHome(String telephoneHome) {
        this.telephoneHome = telephoneHome;
    }

    @Basic
    @Column(name = "Mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "Pager")
    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    @Basic
    @Column(name = "Fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "Address: "+ presentAddress +" "+
                "Work Phone: " +telephoneWork + " "+
                "Home Phone: " +telephoneHome + " "+
                "Mobile Phone: " +mobile + " "+
                "Pager: " +pager + " "+
                "Fax: " +fax + " "+
                "Email: " +email +" ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactdetailsEntity that = (ContactdetailsEntity) o;
        return Objects.equals(idContactDetails, that.idContactDetails) &&
                Objects.equals(presentAddress, that.presentAddress) &&
                Objects.equals(telephoneWork, that.telephoneWork) &&
                Objects.equals(telephoneHome, that.telephoneHome) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(pager, that.pager) &&
                Objects.equals(fax, that.fax) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContactDetails, presentAddress, telephoneWork, telephoneHome, mobile, pager, fax, email);
    }
}

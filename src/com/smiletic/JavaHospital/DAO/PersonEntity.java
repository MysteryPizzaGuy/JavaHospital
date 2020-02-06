package com.smiletic.JavaHospital.DAO;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PERSON", schema = "main", catalog = "")
public class PersonEntity {
    private Short idPerson;
    private String name;
    private String briefStatement;
    private SexEntity sex;
    private String dateOfBirth;
    private ContactdetailsEntity contactDetails;
    private AddressEntity permanentAddress;
    private String nextOfKinName;
    private String nextOfKinRelationshipWithPatient;
    private ContactdetailsEntity nextOfKinContactDetails;
    private MaritalstatusEntity maritalStatus;
    private Short numberOfDependents;
    private Short height;
    private Short weight;
    private BloodtypeEntity bloodType;
    private String occupation;
    private Short grossAnualIncome;
    private String vegetarian;
    private String smoker;
    private Short avgNumberOfCigarettesPerDay;
    private String alcoholic;
    private Short avgNumberOfDrinksPerDay;
    private String stimulants;
    private String infoAboutStimulants;
    private Short avgCoffieTeePerDay;
    private Short avgSoftDrinksPerDay;
    private String regularMeals;
    private FoodtypeEntity predominantlyFoodType;
    private String historyOfPreviousTreatment;
    private String physicianTreated;
    private String hospitalTreated;
    private String diabetic;
    private DiabetictypeEntity diabeticType;
    private String hypertensive;
    private String cardiacCondition;
    private String respiratoryCondition;
    private String digestiveCondition;
    private String orthopedicCondition;
    private String muscularCondition;
    private String neurologicalCondition;
    private String knownAlergies;
    private String knownReactionToDrugs;
    private String majorSurgeries;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "IDPerson")
    public Short getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Short idPerson) {
        this.idPerson = idPerson;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "BriefStatement")
    public String getBriefStatement() {
        return briefStatement;
    }

    public void setBriefStatement(String briefStatement) {
        this.briefStatement = briefStatement;
    }

    @ManyToOne
    @JoinColumn(name = "SexID")

    public SexEntity getSex() {
        return sex;
    }

    public void setSex(SexEntity sex) {
        this.sex = sex;
    }


    @Basic
    @Column(name = "DateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @ManyToOne
    @JoinColumn(name = "ContactdetailsID")

    public ContactdetailsEntity getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactdetailsEntity contactDetails) {
        this.contactDetails = contactDetails;
    }

    @ManyToOne
    @JoinColumn(name = "NextOfKinContactDetailsID")

    public ContactdetailsEntity getNextOfKinContactDetails() {
        return nextOfKinContactDetails;
    }

    public void setNextOfKinContactDetails(ContactdetailsEntity nextOfKinContactDetails) {
        this.nextOfKinContactDetails = nextOfKinContactDetails;
    }

    @ManyToOne
    @JoinColumn(name = "PermanentAddressID")
    public AddressEntity getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(AddressEntity permanentAddress) {
        this.permanentAddress = permanentAddress;
    }



    @Basic
    @Column(name = "NextOfKinName")
    public String getNextOfKinName() {
        return nextOfKinName;
    }

    public void setNextOfKinName(String nextOfKinName) {
        this.nextOfKinName = nextOfKinName;
    }

    @Basic
    @Column(name = "NextOfKinRelationshipWithPatient")
    public String getNextOfKinRelationshipWithPatient() {
        return nextOfKinRelationshipWithPatient;
    }

    public void setNextOfKinRelationshipWithPatient(String nextOfKinRelationshipWithPatient) {
        this.nextOfKinRelationshipWithPatient = nextOfKinRelationshipWithPatient;
    }



    @ManyToOne
    @JoinColumn(name = "MaritalStatusID")

    public MaritalstatusEntity getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalstatusEntity maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Basic
    @Column(name = "NumberOfDependents")
    public Short getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(Short numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    @Basic
    @Column(name = "Height")
    public Short getHeight() {
        return height;
    }

    public void setHeight(Short height) {
        this.height = height;
    }

    @Basic
    @Column(name = "Weight")
    public Short getWeight() {
        return weight;
    }

    public void setWeight(Short weight) {
        this.weight = weight;
    }

    @ManyToOne
    @JoinColumn(name = "BloodTypeID")

    public BloodtypeEntity getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodtypeEntity bloodType) {
        this.bloodType = bloodType;
    }






    @Basic
    @Column(name = "Occupation")
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Basic
    @Column(name = "GrossAnualIncome")
    public Short getGrossAnualIncome() {
        return grossAnualIncome;
    }

    public void setGrossAnualIncome(Short grossAnualIncome) {
        this.grossAnualIncome = grossAnualIncome;
    }

    @Basic
    @Column(name = "Vegetarian")
    public String getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(String vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Basic
    @Column(name = "Smoker")
    public String getSmoker() {
        return smoker;
    }

    public void setSmoker(String smoker) {
        this.smoker = smoker;
    }

    @Basic
    @Column(name = "AvgNumberOfCigarettesPerDay")
    public Short getAvgNumberOfCigarettesPerDay() {
        return avgNumberOfCigarettesPerDay;
    }

    public void setAvgNumberOfCigarettesPerDay(Short avgNumberOfCigarettesPerDay) {
        this.avgNumberOfCigarettesPerDay = avgNumberOfCigarettesPerDay;
    }

    @Basic
    @Column(name = "Alcoholic")
    public String getAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }

    @Basic
    @Column(name = "AvgNumberOfDrinksPerDay")
    public Short getAvgNumberOfDrinksPerDay() {
        return avgNumberOfDrinksPerDay;
    }

    public void setAvgNumberOfDrinksPerDay(Short avgNumberOfDrinksPerDay) {
        this.avgNumberOfDrinksPerDay = avgNumberOfDrinksPerDay;
    }

    @Basic
    @Column(name = "Stimulants")
    public String getStimulants() {
        return stimulants;
    }

    public void setStimulants(String stimulants) {
        this.stimulants = stimulants;
    }

    @Basic
    @Column(name = "InfoAboutStimulants")
    public String getInfoAboutStimulants() {
        return infoAboutStimulants;
    }

    public void setInfoAboutStimulants(String infoAboutStimulants) {
        this.infoAboutStimulants = infoAboutStimulants;
    }

    @Basic
    @Column(name = "AvgCoffieTeePerDay")
    public Short getAvgCoffieTeePerDay() {
        return avgCoffieTeePerDay;
    }

    public void setAvgCoffieTeePerDay(Short avgCoffieTeePerDay) {
        this.avgCoffieTeePerDay = avgCoffieTeePerDay;
    }

    @Basic
    @Column(name = "AvgSoftDrinksPerDay")
    public Short getAvgSoftDrinksPerDay() {
        return avgSoftDrinksPerDay;
    }

    public void setAvgSoftDrinksPerDay(Short avgSoftDrinksPerDay) {
        this.avgSoftDrinksPerDay = avgSoftDrinksPerDay;
    }

    @Basic
    @Column(name = "RegularMeals")
    public String getRegularMeals() {
        return regularMeals;
    }

    public void setRegularMeals(String regularMeals) {
        this.regularMeals = regularMeals;
    }

    @ManyToOne
    @JoinColumn(name = "PredominantlyFoodTypeID")
    public FoodtypeEntity getPredominantlyFoodType() {
        return predominantlyFoodType;
    }

    public void setPredominantlyFoodType(FoodtypeEntity predominantlyFoodType) {
        this.predominantlyFoodType = predominantlyFoodType;
    }

    @Basic
    @Column(name = "HistoryOfPreviousTreatment")
    public String getHistoryOfPreviousTreatment() {
        return historyOfPreviousTreatment;
    }

    public void setHistoryOfPreviousTreatment(String historyOfPreviousTreatment) {
        this.historyOfPreviousTreatment = historyOfPreviousTreatment;
    }

    @Basic
    @Column(name = "PhysicianTreated")
    public String getPhysicianTreated() {
        return physicianTreated;
    }

    public void setPhysicianTreated(String physicianTreated) {
        this.physicianTreated = physicianTreated;
    }

    @Basic
    @Column(name = "HospitalTreated")
    public String getHospitalTreated() {
        return hospitalTreated;
    }

    public void setHospitalTreated(String hospitalTreated) {
        this.hospitalTreated = hospitalTreated;
    }

    @Basic
    @Column(name = "Diabetic")
    public String getDiabetic() {
        return diabetic;
    }

    public void setDiabetic(String diabetic) {
        this.diabetic = diabetic;
    }


    @ManyToOne
    @JoinColumn(name = "DiabeticTypeID")
    public DiabetictypeEntity getDiabeticType() {
        return diabeticType;
    }

    public void setDiabeticType(DiabetictypeEntity diabeticType) {
        this.diabeticType = diabeticType;
    }

    @Basic
    @Column(name = "Hypertensive")
    public String getHypertensive() {
        return hypertensive;
    }

    public void setHypertensive(String hypertensive) {
        this.hypertensive = hypertensive;
    }

    @Basic
    @Column(name = "CardiacCondition")
    public String getCardiacCondition() {
        return cardiacCondition;
    }

    public void setCardiacCondition(String cardiacCondition) {
        this.cardiacCondition = cardiacCondition;
    }

    @Basic
    @Column(name = "RespiratoryCondition")
    public String getRespiratoryCondition() {
        return respiratoryCondition;
    }

    public void setRespiratoryCondition(String respiratoryCondition) {
        this.respiratoryCondition = respiratoryCondition;
    }

    @Basic
    @Column(name = "DigestiveCondition")
    public String getDigestiveCondition() {
        return digestiveCondition;
    }

    public void setDigestiveCondition(String digestiveCondition) {
        this.digestiveCondition = digestiveCondition;
    }

    @Basic
    @Column(name = "OrthopedicCondition")
    public String getOrthopedicCondition() {
        return orthopedicCondition;
    }

    public void setOrthopedicCondition(String orthopedicCondition) {
        this.orthopedicCondition = orthopedicCondition;
    }

    @Basic
    @Column(name = "MuscularCondition")
    public String getMuscularCondition() {
        return muscularCondition;
    }

    public void setMuscularCondition(String muscularCondition) {
        this.muscularCondition = muscularCondition;
    }

    @Basic
    @Column(name = "NeurologicalCondition")
    public String getNeurologicalCondition() {
        return neurologicalCondition;
    }

    public void setNeurologicalCondition(String neurologicalCondition) {
        this.neurologicalCondition = neurologicalCondition;
    }

    @Basic
    @Column(name = "KnownAlergies")
    public String getKnownAlergies() {
        return knownAlergies;
    }

    public void setKnownAlergies(String knownAlergies) {
        this.knownAlergies = knownAlergies;
    }

    @Basic
    @Column(name = "KnownReactionToDrugs")
    public String getKnownReactionToDrugs() {
        return knownReactionToDrugs;
    }

    public void setKnownReactionToDrugs(String knownReactionToDrugs) {
        this.knownReactionToDrugs = knownReactionToDrugs;
    }

    @Basic
    @Column(name = "MajorSurgeries")
    public String getMajorSurgeries() {
        return majorSurgeries;
    }

    public void setMajorSurgeries(String majorSurgeries) {
        this.majorSurgeries = majorSurgeries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity that = (PersonEntity) o;
        return Objects.equals(idPerson, that.idPerson) &&
                Objects.equals(name, that.name) &&
                Objects.equals(briefStatement, that.briefStatement) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(contactDetails, that.contactDetails) &&
                Objects.equals(permanentAddress, that.permanentAddress) &&
                Objects.equals(nextOfKinName, that.nextOfKinName) &&
                Objects.equals(nextOfKinRelationshipWithPatient, that.nextOfKinRelationshipWithPatient) &&
                Objects.equals(nextOfKinContactDetails, that.nextOfKinContactDetails) &&
                Objects.equals(maritalStatus, that.maritalStatus) &&
                Objects.equals(numberOfDependents, that.numberOfDependents) &&
                Objects.equals(height, that.height) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(bloodType, that.bloodType) &&
                Objects.equals(occupation, that.occupation) &&
                Objects.equals(grossAnualIncome, that.grossAnualIncome) &&
                Objects.equals(vegetarian, that.vegetarian) &&
                Objects.equals(smoker, that.smoker) &&
                Objects.equals(avgNumberOfCigarettesPerDay, that.avgNumberOfCigarettesPerDay) &&
                Objects.equals(alcoholic, that.alcoholic) &&
                Objects.equals(avgNumberOfDrinksPerDay, that.avgNumberOfDrinksPerDay) &&
                Objects.equals(stimulants, that.stimulants) &&
                Objects.equals(infoAboutStimulants, that.infoAboutStimulants) &&
                Objects.equals(avgCoffieTeePerDay, that.avgCoffieTeePerDay) &&
                Objects.equals(avgSoftDrinksPerDay, that.avgSoftDrinksPerDay) &&
                Objects.equals(regularMeals, that.regularMeals) &&
                Objects.equals(predominantlyFoodType, that.predominantlyFoodType) &&
                Objects.equals(historyOfPreviousTreatment, that.historyOfPreviousTreatment) &&
                Objects.equals(physicianTreated, that.physicianTreated) &&
                Objects.equals(hospitalTreated, that.hospitalTreated) &&
                Objects.equals(diabetic, that.diabetic) &&
                Objects.equals(diabeticType, that.diabeticType) &&
                Objects.equals(hypertensive, that.hypertensive) &&
                Objects.equals(cardiacCondition, that.cardiacCondition) &&
                Objects.equals(respiratoryCondition, that.respiratoryCondition) &&
                Objects.equals(digestiveCondition, that.digestiveCondition) &&
                Objects.equals(orthopedicCondition, that.orthopedicCondition) &&
                Objects.equals(muscularCondition, that.muscularCondition) &&
                Objects.equals(neurologicalCondition, that.neurologicalCondition) &&
                Objects.equals(knownAlergies, that.knownAlergies) &&
                Objects.equals(knownReactionToDrugs, that.knownReactionToDrugs) &&
                Objects.equals(majorSurgeries, that.majorSurgeries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, name, briefStatement, sex, dateOfBirth, contactDetails, permanentAddress, nextOfKinName, nextOfKinRelationshipWithPatient, nextOfKinContactDetails, maritalStatus, numberOfDependents, height, weight, bloodType, occupation, grossAnualIncome, vegetarian, smoker, avgNumberOfCigarettesPerDay, alcoholic, avgNumberOfDrinksPerDay, stimulants, infoAboutStimulants, avgCoffieTeePerDay, avgSoftDrinksPerDay, regularMeals, predominantlyFoodType, historyOfPreviousTreatment, physicianTreated, hospitalTreated, diabetic, diabeticType, hypertensive, cardiacCondition, respiratoryCondition, digestiveCondition, orthopedicCondition, muscularCondition, neurologicalCondition, knownAlergies, knownReactionToDrugs, majorSurgeries);
    }
}

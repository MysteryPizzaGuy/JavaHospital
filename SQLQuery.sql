CREATE TABLE [STATE](
    IDState integer primary key,
    [State] text
);

CREATE TABLE PINCODE(
    IDPincode integer primary key,
    Pincode text
);

CREATE TABLE CITY(
    IDCity integer primary key,
    City text,
    StateID integer,
    PincodeID integer,
	foreign key(StateID) references [STATE](IDState),
	foreign key(PincodeID) references PINCODE(IDPincode)
);

CREATE TABLE AREA(
	IDArea INTEGER primary key,
	Area text,
	CityID INTEGER,
	FOREIGN key (CityID) references CITY(IDCity)
);

CREATE TABLE STREET(
    IDStreet integer primary key, 
    Street text,
    AreaID integer,
	foreign key(AreaID) references AREA(IDArea)
);



CREATE TABLE ADDRESS(
	IDAddress integer primary key,
	DoorNo text,
	StreetID integer,
	FOREIGN key(StreetID) REFERENCES STREET(IDStreet)
);



CREATE TABLE MARITALSTATUS(
    IDMaritalStatus integer primary key,
    MaritalStatus text
);
CREATE TABLE BLOODTYPE(
    IDBloodType integer primary key,
    BloodType text
);
CREATE TABLE FOODTYPE(
    IDFoodType integer primary key,
    FoodType text
);
CREATE TABLE DIABETICTYPE(
    IDDiabeticType integer primary key,
    DiabeticType text
);
CREATE TABLE SEX(
    IDSex integer primary key,
    Sex text
);
CREATE TABLE CONTACTDETAILS(
	IDContactDetails integer primary key,
	PresentAddressID integer,
	Telephone_Work text,
	Telephone_Home text,
	Mobile text,
	Pager text,
	Fax text,
	Email TEXT,
	FOREIGN KEY (PresentAddressID) REFERENCES ADDRESS(IDAddress)
);
CREATE TABLE PERSON(
	IDPerson integer primary key,
	Name text,
	BriefStatement text,
	SexID integer,
	DateOfBirth date,
	ContactDetailsID integer,
	PermanentAddressID integer,
	NextOfKinName text,
	NextOfKinRelationshipWithPatient text,
	NextOfKinContactDetailsID integer,
	MaritalStatusID integer,
	NumberOfDependents integer,
	Height integer,
	Weight integer,
	BloodTypeID integer,
	Occupation text,
	GrossAnualIncome integer,
	Vegetarian text,
	Smoker text,
	AvgNumberOfCigarettesPerDay integer,
	Alcoholic text,
	AvgNumberOfDrinksPerDay integer,
	Stimulants text,
	InfoAboutStimulants text,
	AvgCoffieTeePerDay integer,
	AvgSoftDrinksPerDay integer,
	RegularMeals text,
	PredominantlyFoodTypeID integer,
	HistoryOfPreviousTreatment text,
	PhysicianTreated text,
	HospitalTreated text,
	Diabetic text,
	DiabeticTypeID integer,
	Hypertensive text,
	CardiacCondition text,
	RespiratoryCondition text,
	DigestiveCondition text,
	OrthopedicCondition text,
	MuscularCondition text,
	NeurologicalCondition text,
	KnownAlergies text,
	KnownReactionToDrugs text,
	MajorSurgeries text,
	foreign key(SexID) references SEX(IDSex),
	foreign key(NextOfKinContactDetailsID) REFERENCES CONTACTDETAILS(IDContactDetails),
	foreign key(PermanentAddressID) REFERENCES ADDRESS(IDAddress),
	foreign key(ContactDetailsID) REFERENCES CONTACTDETAILS(IDContactDetails)
	foreign key(MaritalStatusID) references MARITALSTATUS(IDMaritalStatus),
	foreign key(BloodTypeID) references BLOODTYPE(IDBloodType),
	foreign key(PredominantlyFoodTypeID) references FOODTYPE(IDFoodType),
	foreign key(DiabeticTypeID) references DIABETICTYPE(IDDiabeticType)
);



INSERT INTO [STATE] VALUES(null,'State1');
INSERT INTO [STATE] VALUES(null,'State2');
INSERT INTO [STATE] VALUES(null,'State3');
INSERT INTO [STATE] VALUES(null,'State4');
INSERT INTO PINCODE VALUES(null,'101');
INSERT INTO PINCODE VALUES(null,'102');
INSERT INTO PINCODE VALUES(null,'103');
INSERT INTO PINCODE VALUES(null,'104');
INSERT INTO PINCODE VALUES(null,'105');

INSERT INTO CITY VALUES(null,'City1',1,1);
INSERT INTO CITY VALUES(null,'City2',2,1);
INSERT INTO CITY VALUES(null,'City3',2,2);
INSERT INTO CITY VALUES(null,'City4',3,3);
INSERT INTO CITY VALUES(null,'City5',4,4);
INSERT INTO CITY VALUES(null,'City6',4,5);

INSERT INTO AREA VALUES(null,'Area1',1);
INSERT INTO AREA VALUES(null,'Area2',1);
INSERT INTO AREA VALUES(null,'Area3',2);
INSERT INTO AREA VALUES(null,'Area4',2);

INSERT INTO AREA VALUES(null,'Area5',3);
INSERT INTO AREA VALUES(null,'Area6',4);
INSERT INTO AREA VALUES(null,'Area7',5);
INSERT INTO AREA VALUES(null,'Area8',6);

INSERT INTO STREET VALUES(null,'Street1',1);
INSERT INTO STREET VALUES(null,'Street2',2);
INSERT INTO STREET VALUES(null,'Street3',3);
INSERT INTO STREET VALUES(null,'Street4',4);
INSERT INTO STREET VALUES(null,'Street5',5);
INSERT INTO STREET VALUES(null,'Street6',6);
INSERT INTO STREET VALUES(null,'Street5',7);
INSERT INTO STREET VALUES(null,'Street6',8);

INSERT INTO ADDRESS VALUES(null,'Address1',1);
INSERT INTO ADDRESS VALUES(null,'Address2',2);
INSERT INTO ADDRESS VALUES(null,'Address3',3);


INSERT INTO CONTACTDETAILS VALUES(null,1,'11-22','22-33','1423','123','123','as@as.net');
INSERT INTO CONTACTDETAILS VALUES(null,2,'12-22','232-33','1623','1223','173','as2@as.net');
INSERT INTO CONTACTDETAILS VALUES(null,3,'13-22','225-33','1123','153','1673','as3@as.net');

INSERT INTO MARITALSTATUS VALUES(null,'Married');
INSERT INTO MARITALSTATUS VALUES(null,'Single');
INSERT INTO MARITALSTATUS VALUES(null,'Divorced');
INSERT INTO MARITALSTATUS VALUES(null,'Widowed');
INSERT INTO BLOODTYPE VALUES(null,'A-');
INSERT INTO BLOODTYPE VALUES(null,'A+');
INSERT INTO BLOODTYPE VALUES(null,'B-');
INSERT INTO BLOODTYPE VALUES(null,'B+');
INSERT INTO BLOODTYPE VALUES(null,'AB-');
INSERT INTO BLOODTYPE VALUES(null,'AB+');
INSERT INTO BLOODTYPE VALUES(null,'O-');
INSERT INTO BLOODTYPE VALUES(null,'O+');
INSERT INTO FOODTYPE VALUES(null,'Home food');
INSERT INTO FOODTYPE VALUES(null,'Outsourced ');
INSERT INTO DIABETICTYPE VALUES(null,'Type 1');
INSERT INTO DIABETICTYPE VALUES(null,'Type 2');
INSERT INTO SEX VALUES(null,'Male');
INSERT INTO SEX VALUES(null,'Female');

Insert into PERSON VALUES(null,'Mate Miso','Brief STATEMENT1',1,'1978-01-01',1,1,'Kreso Miso','Sin',1,1,2,170,120,1,'Pjevac',124567,'no','no',0,'yes',0,'no',null,2,1,'yes',1,'Broken Arm','Haso','NYC','no',null,'no','no','no','no','no','no','no','no','no','None');


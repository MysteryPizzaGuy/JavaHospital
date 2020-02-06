package com.smiletic.JavaHospital.Console;

import com.smiletic.JavaHospital.Assist.DataProvider;
import com.smiletic.JavaHospital.DAO.PersonEntity;

import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

public class Console {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PersonEntity> persons = DataProvider.getListofAllEntities(PersonEntity.class);

        System.out.println("[ID] Name | Sex | DOB(Y/M/D) | Brief statement | Next OF Kin Name | Relationship | Phone 1 | Phone 2 \n");
        for (PersonEntity person:persons
             ) {
            System.out.println(MessageFormat.format(
                    "[{0}] {1} | {2} | {3} | {4} | {5} | {6} | {7} | {8}",person.getIdPerson(),person.getName(),person.getSex(),person.getDateOfBirth(),
                    person.getBriefStatement(),person.getNextOfKinName(),person.getNextOfKinRelationshipWithPatient(),
                    person.getContactDetails().getTelephoneHome(),person.getContactDetails().getTelephoneWork()
            ));
            System.out.println("-------------------------------------------");

        }
    }


}

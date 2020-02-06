package com.smiletic.JavaHospital.Console;

import com.smiletic.JavaHospital.Assist.DataProvider;
import com.smiletic.JavaHospital.DAO.PersonEntity;
import com.smiletic.JavaHospital.SwingGUI.MainForm;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Console {


    public static void main(String[] args) {
        disableLogging();




        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        do{
            System.out.println("Choose 1 to print all patients");
            System.out.println("Choose 2 to go to GUI interface (This will close the console)");
            System.out.println("Choose 0 to quit");

            switch(scanner.next()){
                case "1":
                    printPatients();
                    break;
                case "2":
                    try {
                        MainForm.main(args);
                        done = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "0":
                    done = true;
                    break;
            }
        }while (!done);

    }

    public static void printPatients(){
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
        System.out.println("Press ENTER to go back to menu");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    private static void disableLogging() {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE); //could be Level.OFF
    }


}

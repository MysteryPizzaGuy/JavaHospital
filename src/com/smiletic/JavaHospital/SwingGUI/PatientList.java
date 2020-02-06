package com.smiletic.JavaHospital.SwingGUI;

import com.smiletic.JavaHospital.Assist.DataProvider;
import com.smiletic.JavaHospital.DAO.PersonEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Vector;

public class PatientList {
    private JTable tblPatients;
    private JPanel pnlPatientList;


    private void createUIComponents() {
        List<PersonEntity> persons = DataProvider.getListofAllEntities(PersonEntity.class);
        tblPatients = new JTable();
        Object columnNames[] = {"ID", "Name", "Brief Statement", "Sex", "Date of Birth", "Contact Details", "Permanent Address", "Next of Kin", "NOK Relationship", "NOK CD", "MaritalStatus", "Number of Dependants", "Height", "Weight", "Blood Type", "Occupation", "Annual Income", "Vegetarian", "Smoker", "Number of Cigarettes", "Alcoholic", "Numbers of Drinks", "Stimulants", "Stimulants Info",
                "Coffee per Day", "Soft Drinks per Day", "Regular Meals", "Food Type", "History of Treatment", "Physician Treated", "Hospital Treated", "Diabetic", "Diabetic Type", "Hypertensive", "Cardiac Condition", "Respiratory Condition", "Digestive Condition", "Orthopedic Condition", "Muscular Condition", "Neurological Condition", "Known Allergies", "Known Reaction to Drugs", "Major Surgeries"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (PersonEntity person : persons
        ) {
            Object rowData[] = {person.getIdPerson(), person.getName(), person.getBriefStatement(), person.getSex(), person.getDateOfBirth(), String.valueOf(person.getContactDetails()), String.valueOf(person.getPermanentAddress()), person.getNextOfKinName(), person.getNextOfKinRelationshipWithPatient(), person.getNextOfKinContactDetails(), String.valueOf(person.getMaritalStatus()), person.getNumberOfDependents(), person.getHeight(), person.getWeight(), String.valueOf(person.getBloodType()), person.getOccupation(), person.getGrossAnualIncome(), person.getVegetarian(), person.getSmoker(), person.getAvgNumberOfCigarettesPerDay(), person.getAlcoholic(), person.getAvgNumberOfDrinksPerDay(), person.getStimulants(), person.getInfoAboutStimulants(),
                    person.getAvgCoffieTeePerDay(), person.getAvgSoftDrinksPerDay(), person.getRegularMeals(), String.valueOf(person.getPredominantlyFoodType()), person.getHistoryOfPreviousTreatment(), person.getPhysicianTreated(), person.getHospitalTreated(), person.getDiabetic(), String.valueOf(person.getDiabeticType()), person.getHypertensive(), person.getCardiacCondition(), person.getRespiratoryCondition(), person.getDigestiveCondition(), person.getOrthopedicCondition(), person.getMuscularCondition(), person.getNeurologicalCondition(), person.getKnownAlergies(), person.getKnownReactionToDrugs(), person.getMajorSurgeries()};
            model.addRow(rowData);
        }
        tblPatients.setModel(model);

        // TODO: place custom component creation code here
    }

    public static void main(final String[] args) throws Exception {
        JFrame frame = new JFrame("PatientTable");
        frame.setContentPane(new PatientList().pnlPatientList);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        pnlPatientList = new JPanel();
        pnlPatientList.setLayout(new BorderLayout(0, 0));
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setHorizontalScrollBarPolicy(32);
        pnlPatientList.add(scrollPane1, BorderLayout.CENTER);
        tblPatients.setAutoResizeMode(0);
        scrollPane1.setViewportView(tblPatients);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnlPatientList;
    }

}
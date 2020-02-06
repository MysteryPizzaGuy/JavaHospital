package com.smiletic.JavaHospital.SwingGUI;

import com.smiletic.JavaHospital.Assist.DataProvider;
import com.smiletic.JavaHospital.DAO.PersonEntity;
import com.smiletic.JavaHospital.DAO.SexEntity;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm {


    private JPanel pnlMainForm;
    private JButton btnMiniInput;
    private JButton btnPatientList;
    private JButton btnExit;
    private JPanel pnlMenu;
    private JPanel pnlPatientList;
    private JTable tblPatients;
    private JPanel panelmain;
    private JTextField tfName;
    private JLabel lblName;
    private JComboBox cboSex;
    private JLabel lblSex;
    private JLabel lblDatePicker;
    private JDatePicker dpDateofBirth;
    private JLabel lblBriefStatement;
    private JTextField tfPhone1;
    private JTextField tfPhone2;
    private JLabel lblPhone1;
    private JLabel lblPhone2;
    private JTextField txtNextOfKInName;
    private JTextField txtRelationship;
    private JLabel lblNextOfKinName;
    private JLabel lblRtO;
    private JButton btnSubmit;
    private JTextArea txtaBriefStatement;
    private JButton btnPatientsReturnToMenu;
    private JButton btnMiniFormReturn;

    public MainForm() {
        $$$setupUI$$$();
        btnExit.addActionListener(e -> System.exit(0));
        btnPatientList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshPatientList();
                switchCardWindow("patients");
            }
        });
        btnMiniInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchCardWindow("miniform");

            }
        });
        btnPatientsReturnToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchCardWindow("menu");
            }
        });
        btnMiniFormReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchCardWindow("menu");
            }
        });
        List<SexEntity> sexes = DataProvider.getListofAllEntities(SexEntity.class);
        for (SexEntity sex : sexes
        ) {
            cboSex.addItem(sex);
        }

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataProvider.insertMiniform(tfName.getText(), (SexEntity) cboSex.getSelectedItem(), txtaBriefStatement.getText(),
                        Integer.toString(dpDateofBirth.getModel().getYear()), Integer.toString(dpDateofBirth.getModel().getMonth()), Integer.toString(dpDateofBirth.getModel().getDay()),
                        tfPhone1.getText(), tfPhone2.getText(), txtNextOfKInName.getText(), txtRelationship.getText());
            }
        });
    }

    private void switchCardWindow(String carddname) {
        CardLayout layout = (CardLayout) pnlMainForm.getLayout();
        layout.show(pnlMainForm, carddname);
    }

    private void refreshPatientList() {
        List<PersonEntity> persons = DataProvider.getListofAllEntities(PersonEntity.class);
        Object columnNames[] = {"ID", "Name", "Brief Statement", "Sex", "Date of Birth", "Contact Details", "Permanent Address", "Next of Kin", "NOK Relationship", "NOK CD", "MaritalStatus", "Number of Dependants", "Height", "Weight", "Blood Type", "Occupation", "Annual Income", "Vegetarian", "Smoker", "Number of Cigarettes", "Alcoholic", "Numbers of Drinks", "Stimulants", "Stimulants Info",
                "Coffee per Day", "Soft Drinks per Day", "Regular Meals", "Food Type", "History of Treatment", "Physician Treated", "Hospital Treated", "Diabetic", "Diabetic Type", "Hypertensive", "Cardiac Condition", "Respiratory Condition", "Digestive Condition", "Orthopedic Condition", "Muscular Condition", "Neurological Condition", "Known Allergies", "Known Reaction to Drugs", "Major Surgeries"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (PersonEntity person : persons
        ) {
            Object rowData[] = {person.getIdPerson(), person.getName(), person.getBriefStatement(), person.getSex(), person.getDateOfBirth(), String.valueOf(person.getContactDetails()), String.valueOf(person.getPermanentAddress()), person.getNextOfKinName(), person.getNextOfKinRelationshipWithPatient(), person.getNextOfKinContactDetails(), String.valueOf(person.getMaritalStatus()), person.getNumberOfDependents(), person.getHeight(), person.getWeight(), String.valueOf(person.getBloodType()), person.getOccupation(), person.getGrossAnualIncome(), person.getVegetarian(), person.getSmoker(), person.getAvgNumberOfCigarettesPerDay(), person.getAlcoholic(), person.getAvgNumberOfDrinksPerDay(), person.getStimulants(), person.getInfoAboutStimulants(),
                    person.getAvgCoffieTeePerDay(), person.getAvgSoftDrinksPerDay(), person.getRegularMeals(), String.valueOf(person.getPredominantlyFoodType()), person.getHistoryOfPreviousTreatment(), person.getPhysicianTreated(), person.getHospitalTreated(), person.getDiabetic(), String.valueOf(person.getDiabeticType()), person.getHypertensive(), person.getCardiacCondition(), person.getRespiratoryCondition(), person.getDigestiveCondition(), person.getOrthopedicCondition(), person.getMuscularCondition(), person.getNeurologicalCondition(), person.getKnownAlergies(), person.getKnownReactionToDrugs(), person.getMajorSurgeries()};
            model.addRow(rowData);
        }
        ((AbstractTableModel) tblPatients.getModel()).fireTableDataChanged();
        System.out.println("UPDATED");

        tblPatients.setModel(model);
    }

//    private void loadPatientList() {
//        List<PersonEntity> persons = DataProvider.getListofAllEntities(PersonEntity.class);
//        tblPatients = new JTable();
//        Object columnNames[] = {"ID", "Name", "Brief Statement", "Sex", "Date of Birth", "Contact Details", "Permanent Address", "Next of Kin", "NOK Relationship", "NOK CD", "MaritalStatus", "Number of Dependants", "Height", "Weight", "Blood Type", "Occupation", "Annual Income", "Vegetarian", "Smoker", "Number of Cigarettes", "Alcoholic", "Numbers of Drinks", "Stimulants", "Stimulants Info",
//                "Coffee per Day", "Soft Drinks per Day", "Regular Meals", "Food Type", "History of Treatment", "Physician Treated", "Hospital Treated", "Diabetic", "Diabetic Type", "Hypertensive", "Cardiac Condition", "Respiratory Condition", "Digestive Condition", "Orthopedic Condition", "Muscular Condition", "Neurological Condition", "Known Allergies", "Known Reaction to Drugs", "Major Surgeries"};
//        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
//
//        for (PersonEntity person : persons
//        ) {
//            Object rowData[] = {person.getIdPerson(), person.getName(), person.getBriefStatement(), person.getSex(), person.getDateOfBirth(), String.valueOf(person.getContactDetails()), String.valueOf(person.getPermanentAddress()), person.getNextOfKinName(), person.getNextOfKinRelationshipWithPatient(), person.getNextOfKinContactDetails(), String.valueOf(person.getMaritalStatus()), person.getNumberOfDependents(), person.getHeight(), person.getWeight(), String.valueOf(person.getBloodType()), person.getOccupation(), person.getGrossAnualIncome(), person.getVegetarian(), person.getSmoker(), person.getAvgNumberOfCigarettesPerDay(), person.getAlcoholic(), person.getAvgNumberOfDrinksPerDay(), person.getStimulants(), person.getInfoAboutStimulants(),
//                    person.getAvgCoffieTeePerDay(), person.getAvgSoftDrinksPerDay(), person.getRegularMeals(), String.valueOf(person.getPredominantlyFoodType()), person.getHistoryOfPreviousTreatment(), person.getPhysicianTreated(), person.getHospitalTreated(), person.getDiabetic(), String.valueOf(person.getDiabeticType()), person.getHypertensive(), person.getCardiacCondition(), person.getRespiratoryCondition(), person.getDigestiveCondition(), person.getOrthopedicCondition(), person.getMuscularCondition(), person.getNeurologicalCondition(), person.getKnownAlergies(), person.getKnownReactionToDrugs(), person.getMajorSurgeries()};
//            model.addRow(rowData);
//        }
//        tblPatients.setModel(model);
//    }

    ;

    public static void main(final String[] args) throws Exception {
        JFrame frame = new JFrame("MainForm");
        frame.setTitle("Java Hospital");
        frame.setContentPane(new MainForm().pnlMainForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


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
        pnlMainForm = new JPanel();
        pnlMainForm.setLayout(new CardLayout(0, 0));
        pnlMenu = new JPanel();
        pnlMenu.setLayout(new GridBagLayout());
        pnlMainForm.add(pnlMenu, "menu");
        btnMiniInput = new JButton();
        btnMiniInput.setHorizontalTextPosition(11);
        btnMiniInput.setText("Mini Input");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlMenu.add(btnMiniInput, gbc);
        btnPatientList = new JButton();
        btnPatientList.setText("Patient Form");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlMenu.add(btnPatientList, gbc);
        btnExit = new JButton();
        btnExit.setText("Exit");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlMenu.add(btnExit, gbc);
        pnlPatientList = new JPanel();
        pnlPatientList.setLayout(new BorderLayout(0, 0));
        pnlMainForm.add(pnlPatientList, "patients");
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setHorizontalScrollBarPolicy(32);
        pnlPatientList.add(scrollPane1, BorderLayout.CENTER);
        tblPatients.setAutoResizeMode(0);
        scrollPane1.setViewportView(tblPatients);
        btnPatientsReturnToMenu = new JButton();
        btnPatientsReturnToMenu.setText("Return");
        pnlPatientList.add(btnPatientsReturnToMenu, BorderLayout.SOUTH);
        panelmain = new JPanel();
        panelmain.setLayout(new GridBagLayout());
        pnlMainForm.add(panelmain, "miniform");
        tfName = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelmain.add(tfName, gbc);
        lblName = new JLabel();
        lblName.setText("Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelmain.add(lblName, gbc);
        cboSex = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelmain.add(cboSex, gbc);
        lblSex = new JLabel();
        lblSex.setText("Sex");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelmain.add(lblSex, gbc);
        lblDatePicker = new JLabel();
        lblDatePicker.setText("D/O/B");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelmain.add(lblDatePicker, gbc);
        dpDateofBirth = new JDatePicker();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panelmain.add(dpDateofBirth, gbc);
        lblBriefStatement = new JLabel();
        lblBriefStatement.setText("BriefStatement");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelmain.add(lblBriefStatement, gbc);
        tfPhone1 = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelmain.add(tfPhone1, gbc);
        tfPhone2 = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelmain.add(tfPhone2, gbc);
        lblPhone1 = new JLabel();
        lblPhone1.setText("Phone 1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelmain.add(lblPhone1, gbc);
        lblPhone2 = new JLabel();
        lblPhone2.setText("Phone 2");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelmain.add(lblPhone2, gbc);
        txtNextOfKInName = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelmain.add(txtNextOfKInName, gbc);
        txtRelationship = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelmain.add(txtRelationship, gbc);
        lblNextOfKinName = new JLabel();
        lblNextOfKinName.setText("Next of Kin Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelmain.add(lblNextOfKinName, gbc);
        lblRtO = new JLabel();
        lblRtO.setText("Relationship to pat");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelmain.add(lblRtO, gbc);
        btnSubmit = new JButton();
        btnSubmit.setText("SUBMIT");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelmain.add(btnSubmit, gbc);
        txtaBriefStatement = new JTextArea();
        txtaBriefStatement.setRows(6);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panelmain.add(txtaBriefStatement, gbc);
        btnMiniFormReturn = new JButton();
        btnMiniFormReturn.setText("RETURN");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelmain.add(btnMiniFormReturn, gbc);
        comprehensiveform = new JPanel();
        comprehensiveform.setLayout(new GridBagLayout());
        pnlMainForm.add(comprehensiveform, "Card1");
        lblCompName = new JLabel();
        lblCompName.setHorizontalAlignment(10);
        lblCompName.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        comprehensiveform.add(lblCompName, gbc);
        txtCompName = new JTextField();
        txtCompName.setHorizontalAlignment(10);
        txtCompName.setPreferredSize(new Dimension(200, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 4.0;
        gbc.weighty = 1.0;
        comprehensiveform.add(txtCompName, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnlMainForm;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        tblPatients = new JTable();
        refreshPatientList();

    }
}

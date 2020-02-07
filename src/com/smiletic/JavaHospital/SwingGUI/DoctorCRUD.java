package com.smiletic.JavaHospital.SwingGUI;

import com.smiletic.JavaHospital.Assist.DataProvider;
import com.smiletic.JavaHospital.DAO.AvailabilityEntity;
import com.smiletic.JavaHospital.DAO.DoctorEntity;
import com.smiletic.JavaHospital.DAO.SpecializationEntity;
import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DoctorCRUD {
    private JComboBox cboDoctor;
    private JTextField txtName;
    private JLabel lblName;
    private JLabel lblSpecialization;
    private JComboBox cboSpec;
    private JComboBox cboAvlbl;
    private JSpinner spinFromTime;
    private JSpinner spinToTime;
    private JPanel pnlDoctorCRUD;
    private JDatePicker dpFromDate;
    private JDatePicker dpToDate;
    private JLabel lblAction;
    private JButton btnSubmit;
    private JButton btnCloseForm;
    private JButton btnClearAction;
    private JButton btnACreate;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnDCreate;
    private JButton btnDUpdate;
    private JButton btnDDelete;
    private JLabel btnDoctor;
    private JComboBox cboAssignedDoctor;

    private static enum Action {UPDATINGA, DELETINGA, CREATINGA, UPDATINGD, DELETINGD, CREATINGD}

    private static Action currentAction;

    public DoctorCRUD() {
        $$$setupUI$$$();
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (currentAction) {
                    case UPDATINGA:
                        updateAvail();
                        lblAction.setText("");
                        currentAction = null;
                        UpdateCboAvailability();
                        break;
                    case CREATINGA:
                        parseAndInsertAvail();
                        lblAction.setText("");
                        currentAction = null;
                        UpdateCboAvailability();

                        break;
                    case DELETINGA:
                        deleteAvail();
                        lblAction.setText("");
                        currentAction = null;
                        UpdateCboAvailability();

                        break;
                    case CREATINGD:
                        parseandinsertDoctor();
                        lblAction.setText("");
                        currentAction = null;
                        UpdateCboDoctors();
                        break;
                    case DELETINGD:
                        deleteDoctor();
                        lblAction.setText("");
                        currentAction = null;
                        UpdateCboDoctors();

                        break;
                    case UPDATINGD:
                        updateDoctor();
                        lblAction.setText("");
                        currentAction = null;
                        UpdateCboDoctors();

                        break;
                    default:
                        break;

                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAction.setText("UPDATING AVAILABILITY");
                currentAction = Action.UPDATINGA;

            }
        });
        btnACreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAction.setText("CREATING AVAILABILITY");
                currentAction = Action.CREATINGA;

            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAction.setText("DELETING AVAILABILITY");
                currentAction = Action.DELETINGA;

            }
        });
        btnDCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAction.setText("CREATING DOCTOR");
                currentAction = Action.CREATINGD;


            }
        });
        btnDUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAction.setText("UPDATE DOCTOR");
                currentAction = Action.UPDATINGD;
            }
        });
        btnDDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAction.setText("DELETE DOCTOR");
                currentAction = Action.DELETINGD;

            }
        });
        btnClearAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblAction.setText("");
                currentAction = null;
            }
        });
        btnCloseForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentAction = null;
                mainFrame.dispose();
                mainFrame.setVisible(false);
            }
        });


    }

    private void UpdateCboDoctors() {
        List<DoctorEntity> doctors = DataProvider.getListofAllEntities(DoctorEntity.class);
        cboDoctor.setModel(new DefaultComboBoxModel(doctors.toArray()));
        cboAssignedDoctor.setModel(new DefaultComboBoxModel(doctors.toArray()));
    }

    private void UpdateCboAvailability() {
        List<AvailabilityEntity> avails = DataProvider.getListofAllEntities(AvailabilityEntity.class);
        cboAvlbl.setModel(new DefaultComboBoxModel(avails.toArray()));
    }

    private void UpdateCboSpec() {

        List<SpecializationEntity> specs = DataProvider.getListofAllEntities(SpecializationEntity.class);
        cboSpec.setModel(new DefaultComboBoxModel(specs.toArray()));
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        SpinnerDateModel model = new SpinnerDateModel();
        SpinnerDateModel model2 = new SpinnerDateModel();
        model.setCalendarField(Calendar.MINUTE);
        model2.setCalendarField(Calendar.MINUTE);

        spinToTime = new JSpinner();
        spinFromTime = new JSpinner();
        spinFromTime.setModel(model);
        spinToTime.setModel(model2);
        spinFromTime.setEditor(new JSpinner.DateEditor(spinFromTime, "HH:mm"));
        spinToTime.setEditor(new JSpinner.DateEditor(spinToTime, "HH:mm"));


        cboDoctor = new JComboBox();
        cboAvlbl = new JComboBox();
        cboSpec = new JComboBox();
        cboAssignedDoctor = new JComboBox();

        UpdateCboDoctors();
        UpdateCboAvailability();
        UpdateCboSpec();


        cboDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorSetUp((DoctorEntity) cboDoctor.getSelectedItem());

            }
        });
        cboAvlbl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AvailSetUp((AvailabilityEntity) cboAvlbl.getSelectedItem());
            }
        });


    }

    static JFrame mainFrame;

    public static void main(final String[] args) throws Exception {
        mainFrame = new JFrame("DoctorCRUD");
        mainFrame.setTitle("Doctor CRUD");
        mainFrame.setContentPane(new DoctorCRUD().pnlDoctorCRUD);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);


    }

    private void DoctorSetUp(DoctorEntity doctor) {
        txtName.setText(doctor.getName());
        cboSpec.setSelectedItem(doctor.getSpecialization());
    }


    private void AvailSetUp(AvailabilityEntity availb) {
        Calendar cal = Calendar.getInstance();
        String[] date = availb.getFromDate().split("-");
        cal.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        DateModel<Calendar> dateModel = (DateModel<Calendar>) dpFromDate.getModel();
        dateModel.setValue(cal);
        Calendar cal2 = Calendar.getInstance();
        date = availb.getToDate().split("-");
        cal2.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        dateModel = (DateModel<Calendar>) dpToDate.getModel();
        dateModel.setValue(cal2);
        Date timefrom = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm");
        try {
            timefrom = format.parse(availb.getFromTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ((SpinnerDateModel) spinFromTime.getModel()).setValue(timefrom);

        Date timefrom2 = new Date();
        DateFormat format2 = new SimpleDateFormat("HH:mm");
        try {
            timefrom2 = format2.parse(availb.getToTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ((SpinnerDateModel) spinToTime.getModel()).setValue(timefrom2);
        cboAssignedDoctor.setSelectedItem(availb.getDoctor());

    }

    private void parseAndInsertAvail() {
        String date = dpFromDate.getModel().getYear() + "-" + dpFromDate.getModel().getMonth() + "-" + dpFromDate.getModel().getDay();
        String date2 = dpToDate.getModel().getYear() + "-" + dpToDate.getModel().getMonth() + "-" + dpToDate.getModel().getDay();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String time = dateFormat.format((Date) spinFromTime.getModel().getValue());
        String time2 = dateFormat.format((Date) spinToTime.getModel().getValue());
        DataProvider.insertAvailability(date, date2, time, time2, (DoctorEntity) cboAssignedDoctor.getSelectedItem());


    }

    private void deleteAvail() {
        DataProvider.deleteAvailability((AvailabilityEntity) cboAvlbl.getSelectedItem());
    }

    private void updateAvail() {
        String date = dpFromDate.getModel().getYear() + "-" + dpFromDate.getModel().getMonth() + "-" + dpFromDate.getModel().getDay();
        String date2 = dpToDate.getModel().getYear() + "-" + dpToDate.getModel().getMonth() + "-" + dpToDate.getModel().getDay();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String time = dateFormat.format((Date) spinToTime.getModel().getValue());
        String time2 = dateFormat.format((Date) spinFromTime.getModel().getValue());
        DataProvider.updateAvailability(date, date2, time, time2, (DoctorEntity) cboAssignedDoctor.getSelectedItem(), (AvailabilityEntity) cboAvlbl.getSelectedItem());

    }

    private void parseandinsertDoctor() {
        String name = txtName.getText();
        SpecializationEntity spec = (SpecializationEntity) cboSpec.getSelectedItem();
        DataProvider.insertDoctor(name, spec);
    }

    private void updateDoctor() {
        String name = txtName.getText();
        SpecializationEntity spec = (SpecializationEntity) cboSpec.getSelectedItem();
        DataProvider.updateDoctor(name, spec, (DoctorEntity) cboDoctor.getSelectedItem());
    }

    private void deleteDoctor() {
        DataProvider.deleteDoctor((DoctorEntity) cboDoctor.getSelectedItem());
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
        pnlDoctorCRUD = new JPanel();
        pnlDoctorCRUD.setLayout(new GridBagLayout());
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        pnlDoctorCRUD.add(spacer2, gbc);
        lblName = new JLabel();
        lblName.setText("Name");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        pnlDoctorCRUD.add(lblName, gbc);
        txtName = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(txtName, gbc);
        lblSpecialization = new JLabel();
        lblSpecialization.setText("lblSpec");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        pnlDoctorCRUD.add(lblSpecialization, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(cboSpec, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(cboDoctor, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(cboAvlbl, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("FromDate");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        pnlDoctorCRUD.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("ToDate");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        pnlDoctorCRUD.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("FromTime");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        pnlDoctorCRUD.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("ToTime");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        pnlDoctorCRUD.add(label4, gbc);
        dpFromDate = new JDatePicker();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        pnlDoctorCRUD.add(dpFromDate, gbc);
        dpToDate = new JDatePicker();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        pnlDoctorCRUD.add(dpToDate, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(spinFromTime, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(spinToTime, gbc);
        lblAction = new JLabel();
        lblAction.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        pnlDoctorCRUD.add(lblAction, gbc);
        btnACreate = new JButton();
        btnACreate.setText("Create");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(btnACreate, gbc);
        btnUpdate = new JButton();
        btnUpdate.setText("Update");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(btnUpdate, gbc);
        btnDelete = new JButton();
        btnDelete.setText("Delete");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(btnDelete, gbc);
        btnCloseForm = new JButton();
        btnCloseForm.setText("Close");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(btnCloseForm, gbc);
        btnSubmit = new JButton();
        btnSubmit.setText("Submit");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(btnSubmit, gbc);
        btnClearAction = new JButton();
        btnClearAction.setText("Clear Action");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(btnClearAction, gbc);
        btnDCreate = new JButton();
        btnDCreate.setText("Create");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(btnDCreate, gbc);
        btnDUpdate = new JButton();
        btnDUpdate.setText("Update");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(btnDUpdate, gbc);
        btnDDelete = new JButton();
        btnDDelete.setText("Delete");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(btnDDelete, gbc);
        btnDoctor = new JLabel();
        btnDoctor.setText("Doctor Assigned To");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        pnlDoctorCRUD.add(btnDoctor, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlDoctorCRUD.add(cboAssignedDoctor, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnlDoctorCRUD;
    }

}



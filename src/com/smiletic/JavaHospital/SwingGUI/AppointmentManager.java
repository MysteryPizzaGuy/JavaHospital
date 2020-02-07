package com.smiletic.JavaHospital.SwingGUI;

import com.smiletic.JavaHospital.Assist.DataProvider;
import com.smiletic.JavaHospital.DAO.AppointmentEntity;
import com.smiletic.JavaHospital.DAO.DoctorEntity;
import com.smiletic.JavaHospital.DAO.PersonEntity;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AppointmentManager {
    private JDatePicker dpStart;
    private JDatePicker dpEnd;
    private JComboBox cboDoctors;
    private JComboBox cboAppointment;
    private JComboBox cboPatient;
    private JButton btnSubmit;
    private JPanel pnlAppointment;
    private JSpinner spinStartTime;
    private JSpinner spinEndTime;
    private JButton btnCheck;
    private JButton btnClose;


    public AppointmentManager() {
        $$$setupUI$$$();
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateCboDoctors();


            }
        });
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String date = dpStart.getModel().getYear() + "-" + dpStart.getModel().getMonth() + "-" + dpStart.getModel().getDay();
                String date2 = dpEnd.getModel().getYear() + "-" + dpEnd.getModel().getMonth() + "-" + dpEnd.getModel().getDay();
                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                String time = dateFormat.format((Date) spinStartTime.getModel().getValue());
                String time2 = dateFormat.format((Date) spinEndTime.getModel().getValue());
                DataProvider.insertAppointment(date, date2, time, time2, (PersonEntity) cboPatient.getSelectedItem(), (DoctorEntity) cboDoctors.getSelectedItem());
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                mainFrame.setVisible(false);
            }
        });
    }

    private void UpdateCboAppointment() {
        List<AppointmentEntity> appos = DataProvider.getListofAllEntities(AppointmentEntity.class);
        cboAppointment.setModel(new DefaultComboBoxModel(appos.toArray()));
    }

    private void UpdateCboDoctors() {
        String date = dpStart.getModel().getYear() + "-" + dpStart.getModel().getMonth() + "-" + dpStart.getModel().getDay();
        String date2 = dpEnd.getModel().getYear() + "-" + dpEnd.getModel().getMonth() + "-" + dpEnd.getModel().getDay();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String time = dateFormat.format((Date) spinStartTime.getModel().getValue());
        String time2 = dateFormat.format((Date) spinEndTime.getModel().getValue());
        List<DoctorEntity> doctors = DataProvider.getListofDoctorsforAppointment(date, date2, time, time2);

        cboDoctors.setModel(new DefaultComboBoxModel(doctors.toArray()));
    }

    private void UpdateCboPatient() {
        List<PersonEntity> patients = DataProvider.getListofAllEntities(PersonEntity.class);
        cboPatient.setModel(new DefaultComboBoxModel(patients.toArray()));
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        cboAppointment = new JComboBox();
        cboDoctors = new JComboBox();
        cboPatient = new JComboBox();
        UpdateCboAppointment();
        UpdateCboPatient();

        SpinnerDateModel model = new SpinnerDateModel();
        SpinnerDateModel model2 = new SpinnerDateModel();
        model.setCalendarField(Calendar.MINUTE);
        model2.setCalendarField(Calendar.MINUTE);

        spinStartTime = new JSpinner();
        spinEndTime = new JSpinner();
        spinStartTime.setModel(model);
        spinEndTime.setModel(model2);
        spinStartTime.setEditor(new JSpinner.DateEditor(spinStartTime, "HH:mm"));
        spinEndTime.setEditor(new JSpinner.DateEditor(spinEndTime, "HH:mm"));

        cboAppointment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateCboAppointment();
            }
        });

    }


    static JFrame mainFrame;

    public static void main(final String[] args) throws Exception {
        mainFrame = new JFrame("AppointmentManager");
        mainFrame.setTitle("Appointment Manager");
        mainFrame.setContentPane(new AppointmentManager().pnlAppointment);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);


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
        pnlAppointment = new JPanel();
        pnlAppointment.setLayout(new GridBagLayout());
        final JLabel label1 = new JLabel();
        label1.setText("Start");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        pnlAppointment.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlAppointment.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        pnlAppointment.add(spacer2, gbc);
        dpStart = new JDatePicker();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        pnlAppointment.add(dpStart, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("End");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        pnlAppointment.add(label2, gbc);
        dpEnd = new JDatePicker();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        pnlAppointment.add(dpEnd, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlAppointment.add(cboDoctors, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Doctor");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        pnlAppointment.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Appointments");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        pnlAppointment.add(label4, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlAppointment.add(cboAppointment, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("Patient");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        pnlAppointment.add(label5, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlAppointment.add(cboPatient, gbc);
        btnSubmit = new JButton();
        btnSubmit.setText("btnSubmit");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlAppointment.add(btnSubmit, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlAppointment.add(spinStartTime, gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlAppointment.add(spinEndTime, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        pnlAppointment.add(spacer3, gbc);
        btnCheck = new JButton();
        btnCheck.setText("Check");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlAppointment.add(btnCheck, gbc);
        btnClose = new JButton();
        btnClose.setText("Close");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pnlAppointment.add(btnClose, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return pnlAppointment;
    }

}

package ui;

import control.MaintainProgrammeControl;
import model.Programme;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MaintainProgrammeFrame extends JFrame {

    private MaintainProgrammeControl progControl;
    private JTextField jtfCode = new JTextField();
    private JTextField jtfName = new JTextField();
    private JTextField jtfFaculty = new JTextField();
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtDelete = new JButton("Delete");

    public MaintainProgrammeFrame() {

        progControl = new MaintainProgrammeControl();

        JPanel jpCenter = new JPanel(new GridLayout(3, 2));
        jpCenter.add(new JLabel("Programme Code"));
        jpCenter.add(jtfCode);
        jpCenter.add(new JLabel("Programme Name"));
        jpCenter.add(jtfName);
        jpCenter.add(new JLabel("Faculty"));
        jpCenter.add(jtfFaculty);
        add(jpCenter);

        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtAdd);
        jpSouth.add(jbtRetrieve);
        jpSouth.add(jbtUpdate);
        jpSouth.add(jbtDelete);
        add(jpSouth, BorderLayout.SOUTH);

        //btn ActionListner
        jbtAdd.addActionListener(new CreateLIstner());
        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtUpdate.addActionListener(new UpdateListner());
        jbtDelete.addActionListener(new deleteLIstner());

        setTitle("Programme CRUD");
        setSize(600, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);

    }

    private class CreateLIstner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Get code,name,faculty
            String code = jtfCode.getText();
            String name = jtfName.getText();
            String faculty = jtfFaculty.getText();

            //pass value to createRecord method
            // go to createRecord
            Programme programme = progControl.createRecord(code, name, faculty);

            if (programme != null) {
                jtfCode.setText(programme.getCode());
                jtfName.setText(programme.getName());
                jtfFaculty.setText(programme.getFaculty());
            }

        }

    }

    private class RetrieveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            Programme programme = progControl.selectRecord(code);
            if (programme != null) {
                jtfName.setText(programme.getName());
                jtfFaculty.setText(programme.getFaculty());
            } else
                JOptionPane.showMessageDialog(null, "No such programme code.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class CompareListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String code = jtfCode.getText();
            Boolean sameRecord = progControl.compareRecord(code);
            if (!sameRecord)
                JOptionPane.showMessageDialog(null, "Db dont exist");
            else
                JOptionPane.showMessageDialog(null, "Database already exist");
        }
    }

    private class UpdateListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Get code,name,faculty
            String code = jtfCode.getText();
            String name = jtfName.getText();
            String faculty = jtfFaculty.getText();

            //pass value to createRecord method
            // go to createRecord
            Programme programme = progControl.updateRecord(code, name, faculty);

            if (programme != null) {
                jtfCode.setText(programme.getCode());
                jtfName.setText(programme.getName());
                jtfFaculty.setText(programme.getFaculty());
            }
        }

    }

    private class deleteLIstner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String code = jtfCode.getText();

            //pass value to createRecord method
            // go to createRecord
            Programme programme = progControl.deleteRecord(code);
        }

    }

}

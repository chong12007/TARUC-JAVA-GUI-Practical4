package ui;

import ui.MaintainProgrammeFrame;
import ui.StudentGUI;
import da.ProgrammeDA;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.Programme;

public class MaintainInformationGUI extends JFrame {

    private JButton btnProgramme = new JButton("Maintain Programme");
    private JButton btnStudent = new JButton("Maintain Student");

    public MaintainInformationGUI() {
        setLayout(new GridLayout(2, 1));

        //action listner
        btnProgramme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaintainProgrammeFrame m1 = new MaintainProgrammeFrame();
                ProgrammeDA da = new ProgrammeDA();
                Programme programme = da.getRecord("IA");
            }

        });

        btnStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentGUI student = new StudentGUI();

            }

        });

        add(btnProgramme);
        add(btnStudent);

        setTitle("Maintance Information");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}

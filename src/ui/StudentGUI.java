package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Programme;

public class StudentGUI extends JFrame {

    private JPanel inputJPanel = new JPanel(new GridLayout(0, 2));
    private JTextField jtfID = new JTextField();
    private JTextField jtfIC = new JTextField();
    private JTextField jtfName = new JTextField();
    private JTextField jtfEmail = new JTextField();
    private JTextField jtfProgCode = new JTextField();
    private JTextField jtfYear = new JTextField();

    private JPanel buttonPanel = new JPanel(new FlowLayout());
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtDelete = new JButton("Delete");

    public StudentGUI() {
        
        setLayout(new BorderLayout());

        inputJPanel.add(new JLabel("Student ID"));
        inputJPanel.add(jtfID);
        inputJPanel.add(new JLabel("Student IC"));
        inputJPanel.add(jtfIC);
        inputJPanel.add(new JLabel("Student Name"));
        inputJPanel.add(jtfName);
        inputJPanel.add(new JLabel("Email"));
        inputJPanel.add(jtfEmail);
        inputJPanel.add(new JLabel("Programme Code"));
        inputJPanel.add(jtfProgCode);
        inputJPanel.add(new JLabel("Year"));
        inputJPanel.add(jtfYear);

        add(inputJPanel, BorderLayout.CENTER);
        
       buttonPanel.add(jbtAdd);
       buttonPanel.add(jbtRetrieve);
       buttonPanel.add(jbtUpdate);
       buttonPanel.add(jbtDelete);
       
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Programme CRUD");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }

    
     
}

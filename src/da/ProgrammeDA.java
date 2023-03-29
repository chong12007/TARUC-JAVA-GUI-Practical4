package da;

import model.Programme;
import java.sql.*;
import javax.swing.*;

public class ProgrammeDA {

    private String host = "jdbc:derby://localhost:1527/ProgrammeDB";
    private String user = "ProgrammeUser";
    private String password = "123";
    private String tableName = "Programme";
    private Connection conn;
    private PreparedStatement stmt;

    public ProgrammeDA() {
        createConnection();
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Boolean compareSameInDB(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Code = ?";
        Programme programme = null;

        if (code.equals(""))
            return false;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

              
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;

    }

    public Programme createRecord(String code, String name, String faculty) {

        //Check if entered code is null
        if (code.equals("")
                || name.equals("")
                || faculty.equals("")) {
            JOptionPane.showMessageDialog(null, "Code,Name and Facutly should not be null!!");
            return null;
        }

        //Check if entered code already existed in DB
        Boolean sameRecord = compareSameInDB(code);

        //If db dont exist then procced
        if (!sameRecord) {
            //SQL query
            String queryStr = "INSERT INTO PROGRAMME VALUES (?, ?, ?) ";

            Programme programme = null;
            try {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, code);
                stmt.setString(2, name);
                stmt.setString(3, faculty);

                int rs = stmt.executeUpdate();

                //if row result > 0 successfully insert into db
                if (rs > 0)
                    programme = new Programme(code, name, faculty);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "Successfully Create record");
            return programme;
        } else {
            JOptionPane.showMessageDialog(null, "Database already exist");
            return null;
        }

    }

    public Programme getRecord(String code) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE Code = ?";
        Programme programme = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, code);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
                programme = new Programme(code, rs.getString("Name"), rs.getString("Faculty"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return programme;
    }
    
    public Programme updateRecord(String code, String name, String faculty) {
       
         //Check if entered code is null
        if (code.equals("")
                || name.equals("")
                || faculty.equals("")) {
            JOptionPane.showMessageDialog(null, "Code,Name and Facutly should not be null!!");
            return null;
        }

        //Check if entered code already existed in DB
        Boolean sameRecord = compareSameInDB(code);

        //If db dont exist then procced
        if (sameRecord) {
            //SQL query
            String queryStr = "UPDATE PROGRAMME SET NAME = ?, FACULTY = ?"
                    + "WHERE CODE = ?";

            Programme programme = null;
            try {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(3, code);
                stmt.setString(1, name);
                stmt.setString(2, faculty);

                int rs = stmt.executeUpdate();

                //if row result > 0 successfully insert into db
                if (rs > 0)
                    programme = new Programme(code, name, faculty);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "Successfully Create record");
            return programme;
        } else {
            JOptionPane.showMessageDialog(null, "Database dont exist");
            return null;
        }
    }
    
    public Programme deleteRecord (String code) {
         //Check if entered code is null
        if (code.equals("")) {
            JOptionPane.showMessageDialog(null, "Code should not be null!!");
            return null;
        }

        //Check if entered code already existed in DB
        Boolean sameRecord = compareSameInDB(code);
        
          if (sameRecord) {
            //SQL query
            String queryStr = "DELETE FROM PROGRAMME "
                    + "WHERE CODE = ?";

            Programme programme = null;
            try {
                stmt = conn.prepareStatement(queryStr);
                stmt.setString(1, code);
                

                int rs = stmt.executeUpdate();

                //if row result > 0 successfully insert into db
                if (rs > 0)
                    programme = new Programme();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "Successfully Delete record");
            return programme;
        } else {
            JOptionPane.showMessageDialog(null, "Database dont exist");
            return null;
        }
    }
    

    private void shutDown() {
        if (conn != null)
            try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}

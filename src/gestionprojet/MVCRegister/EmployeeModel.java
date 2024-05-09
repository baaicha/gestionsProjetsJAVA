/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionprojet.MVCRegister;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author User
 */
public class EmployeeModel {
  
    private final String SURL = "jdbc:MySQL://localhost:3306/gestionprojets";
    private final String Suser = "root";
    private final String SPass = "";

    public boolean registerEmployee(String matricule, String prenom, String nom, String email, String motDePasse) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SURL, Suser, SPass);
            Statement st = con.createStatement();
          
             String checkQuery = "SELECT matricule FROM Employees WHERE matricule = '" + matricule + "'";
             ResultSet rs = st.executeQuery(checkQuery);
        if (rs.next()) {
             String insertQuery = "INSERT INTO Comptes(first_name, last_name, email, password, matriculeEMP) " +
                    "VALUES('" + prenom + "','" + nom + "' , '" + email + "','" + motDePasse + "','" + matricule + "')";
            st.execute(insertQuery);
            return true;
        } else {           
             System.out.println("Le matricule existe déjà.");
            return false;
        }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error! " + e.getMessage());
            return false;
        }
    }
}



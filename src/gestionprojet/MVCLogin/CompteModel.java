/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
package gestionprojet.MVCLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompteModel {
    private final String SURL;
    private final String Suser;
    private final String SPass;

    public CompteModel() {
        SURL = "jdbc:mysql://localhost:3306/gestionprojets";
        Suser = "root";
        SPass = "";
    }

    public boolean verifierUtilisateur(String email, String motDePasse) {
        boolean utilisateurExiste = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(SURL, Suser, SPass);
            Statement st = con.createStatement();

            String query = "SELECT * FROM Comptes WHERE email= '" + email + "'";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                String passDb = rs.getString("password");
                if (motDePasse.equals(passDb)) {
                    utilisateurExiste = true;
                }
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error!" + e.getMessage());
        }
        return utilisateurExiste;
    }
}

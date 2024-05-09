package com.raven.form;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
// hi
public class Form_Home extends javax.swing.JPanel {
 Connection con;
    public Form_Home() {
        initComponents();
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Stock Total", "$200000", "Increased by 60%"));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")), "Total Profit", "$15000", "Increased by 25%"));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")), "Unique Visitors", "$300000", "Increased by 70%"));
//      jTable1.setVerticalScrollBar(new ScrollBar());
//        jTable1.getVerticalScrollBar().setBackground(Color.WHITE);
//        jTable1.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
//        jTable1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
//        jTable1.addRow(new Object[]{"Mike Bhand", "mikebhand@gmail.com", "Admin", "25 Apr,2018", StatusType.PENDING});
//        jTable1.addRow(new Object[]{"Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018", StatusType.APPROVED});
//        jTable1.addRow(new Object[]{"Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018", StatusType.APPROVED});
//        jTable1.addRow(new Object[]{"Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018", StatusType.REJECT});
//        jTable1.addRow(new Object[]{"Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018", StatusType.PENDING});
//        jTable1.addRow(new Object[]{"Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018", StatusType.APPROVED});
//        jTable1.addRow(new Object[]{"Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018", StatusType.APPROVED});
//        table.addRow(new Object[]{"Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018", StatusType.REJECT});
//        table.addRow(new Object[]{"Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018", StatusType.PENDING});
//        table.addRow(new Object[]{"Kevin Pietersen", "kevinpietersen@gmail.com", "Admin", "25 Apr,2018", StatusType.PENDING});
//        table.addRow(new Object[]{"Andrew Strauss", "andrewstrauss@gmail.com", "Editor", "25 Apr,2018", StatusType.APPROVED});
//        table.addRow(new Object[]{"Ross Kopelman", "rosskopelman@gmail.com", "Subscriber", "25 Apr,2018", StatusType.APPROVED});
//        table.addRow(new Object[]{"Mike Hussy", "mikehussy@gmail.com", "Admin", "25 Apr,2018", StatusType.REJECT});
//    

String url="jdbc:MySQL://localhost:3306/gestionprojets";
String user="root";
String pass="";
try{
 Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection(url, user, pass);
    System.out.println("Connexion à la base de données établie avec succès.");
 

show_prj();
        } catch (Exception ex) {
    System.out.println("Erreur lors de la connexion à la base de données : " + ex.getMessage());
        }

    }  
    
    public ArrayList<Projet> lstProjets(){
    ArrayList<Projet> lstProjet = new ArrayList<>();
    String sql = "SELECT * FROM projets";
    
    try{
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery(sql);
        int rowCount = 0; // Compteur pour le nombre de lignes récupérées
        while (rs.next()) {
            rowCount++; // Incrémentez le compteur
            Projet pr = new Projet(
                rs.getInt("projet_id"),
                rs.getString("project_name"),
                rs.getDate("dateDebut"),
                rs.getDate("dateFin"),
                rs.getString("MembresEquipe"),
                rs.getString("etat"),
                rs.getInt("project_manager_id")
            );
            lstProjet.add(pr);
        }
          System.out.println("Nombre de lignes récupérées : " + rowCount); // Imprimez le nombre de lignes récupérées
    } catch(Exception e) {
        System.out.println("Error:" + e.getMessage());
    }
    return lstProjet;
}
    public void show_prj(){
    ArrayList<Projet> list = lstProjets();
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // Clear table
    
    for(Projet pr : list) {
        Object[] row = {
            pr.getID(),
            pr.getName(),
            pr.getDB(),
            pr.getDF(),
            pr.getMembresEquipe(),
            pr.getEtat(),
            pr.getProjet_manager_id()
        };
        // Ajout d'une impression des données récupérées
        System.out.println("Données récupérées : " + Arrays.toString(row));
        model.addRow(row);
    }
}
       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(242, 242, 242));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "DB", "DF", "MembresEquipe", "Etat", "Projet_manager_id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAlignmentX(8.0F);
        jTable1.setAlignmentY(8.0F);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(1, 2));
        jTable1.setRowHeight(35);
        jTable1.setSelectionBackground(new java.awt.Color(51, 51, 255));
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLayeredPane panel;
    private com.raven.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}

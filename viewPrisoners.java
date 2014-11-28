package view;


import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gazer
 */
public class viewPrisoners extends javax.swing.JFrame {
    static String[] names = {"FirstName","LastName","Gender","Address","DOB","Death Row","Imprison Date","Release Date"};
    DefaultTableModel prisonList;

    /**
     * Creates new form viewPrisoners
     */
     java.sql.Statement q;
    java.sql.ResultSet p;
DefaultTableModel tb1;
    public viewPrisoners() {
        
         prisonList = new DefaultTableModel(names, 0);
        initComponents();
    }
    
    public void show2(){
        AddPrisoner p1 = new AddPrisoner();
        p1.setVisible(true);
    }
    
    
    public void editprisoner(){
//      record = (DefaultTableModel) jTable1.getModel();

        int row = jTable1.getSelectedRow();
        int column = jTable1.getSelectedColumn();
        int code = column - column;
        int dataCode = Integer.parseInt((String) jTable1.getValueAt(row, code));

        if (column == 1) {
            String msg = JOptionPane.showInputDialog(null, "Please Enter First Name:");
            try {
                java.sql.Connection conn = null;
                PreparedStatement p = conn.prepareStatement("UPDATE prisoner SET first_name=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, dataCode);
                p.execute();
                jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
                return;
            }
        
         } else if (column == 2) {
            String msg = JOptionPane.showInputDialog(null, "Please Enter Last Name: ");
            try {
                java.sql.Connection conn = null;
            
                PreparedStatement p = conn.prepareStatement("UPDATE prsoner SET last_name=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, dataCode);
                p.execute();
                jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
                return;
            }
    }
          else if (column == 3) {
            String msg = JOptionPane.showInputDialog(null, "Please Enter Address: ");
            try {
                java.sql.Connection conn = null;
            
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET address=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, dataCode);
                p.execute();
                jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
                return;
            } 
        }else if (column == 4) {
            String msg = JOptionPane.showInputDialog(null, "Please Enter Date of Birth: ");
            try {
                java.sql.Connection conn = null;
           
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET date_of_birth=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, dataCode);
                p.execute();
                jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
                return;
            } 
        }else if (column == 5) {
            String[] list = {"m", "f"};
            String msg = (String) JOptionPane.showInputDialog(null, "Choose Gender", "Nice", JOptionPane.QUESTION_MESSAGE, null, list, list[0]);
            try {
                java.sql.Connection conn = null;
           
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET gender=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, dataCode);
                p.execute();
                jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
                return;
            }
        }
    }
        
public void showData(){
    try{
              java.sql.Connection conn = null;
    
         Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/prisonbreak?user=root&password=root");

        } catch (Exception e) {
            System.out.println(e);
            //System.exit(0);
        }
    try {
        java.sql.Connection conn = null;
            q = conn.createStatement();
            p = q.executeQuery("SELECT * FROM prisoner");
            ResultSetMetaData j = p.getMetaData();
        } catch (Exception e) {
        }
}
    public void display(){
   try {
//            if (r.isLast()) {
//                JOptionPane.showMessageDialog(null, "No More products in Database");
//            }
           while(p.next()){
            tb1.addRow(new Object[]{p.getString("ID"), p.getString("first_name"), p.getString("last_name"),
             p.getString("address"), p.getString("gender"),p.getString("date_of_birth"),p.getString("death_row"),
             p.getString("crime"),p.getString("date_imprisoned"),p.getString("release_date"),p.getString("other_crimes")});
   
           }
        } catch (SQLException ex) {
        }
    } 
     public void delete(){
         
        int row = jTable1.getSelectedRow();
        int Code = Integer.parseInt((String) jTable1.getValueAt(row, 0));
        try {
             java.sql.Connection conn = null;
            PreparedStatement p = conn.prepareStatement("DELETE FROM prisoner WHERE ID = ?;");
            p.setInt(1, Code);
            ((DefaultTableModel) jTable1.getModel()).removeRow(row);
            p.execute();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            return;
        }
    }

        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(prisonList);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Previous");

        jButton2.setText("Next");

        jButton3.setText("View Prionser Details");

        jButton4.setText("Update Prisoner Info");

        jButton5.setText("Remove Prisoner");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Back to Menu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Sign Out");

        jButton8.setText("Add New Prisoner");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setText("                  NSAWAM PRISONERS");

        jTextField1.setFont(new java.awt.Font("Ubuntu", 2, 15)); // NOI18N
        jTextField1.setText("Search here");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton9.setText("GO");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(144, 144, 144)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButton7)))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new PrisonMenu().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
delete();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
 show2();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewPrisoners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewPrisoners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewPrisoners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewPrisoners.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewPrisoners().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

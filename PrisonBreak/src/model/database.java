/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import javax.swing.JButton;
//import static view.ListGuard.tb1;

/**
 *
 * @author salifu
 */
public class database {
    java.sql.Statement s;
    java.sql.ResultSet r;
    java.sql.Connection conn = null;
    /**
     * Creates new form Guards
     */
    
    public database() {

        initialize();
    }

    
        private void initialize() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/prisonbreak?user=root&password=");

        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        System.out.println("Connection established");
    }
      
        public boolean logIn(String firstname, String pass){
            boolean result = true;
            try{   
            s = conn.createStatement();
            r = s.executeQuery("SELECT * FROM guard WHERE first_name='"+firstname+"' AND password = '"+pass+"'");
            
            int rowCount = 0;  
            while (r.next())  
            { rowCount++;  }
            if(rowCount < 1) result = false;
            }catch (Exception e){
                System.out.println(e);
                //System.exit(0);
                result =  false;
            }
            return result;
            }
        
public void addGuard(String one, String two, String three, String four, String five, String six, String seven, String eight, 
        String nine, String ten, String eleven) {
        try {
            PreparedStatement p = conn.prepareStatement("Insert Into guard set first_name =?, last_name=?, address = ?, date_of_birth = ?, gender=?, role = ?, shift_start=?, shift_end=?,password = ?, status = ?, station = ?");
            p.setString(1,one);
            p.setString(2,two);
            p.setString(3,three);
            p.setString(4,four);
            p.setString(5,five);
            p.setString(6,six);
            p.setString(7,seven);
            p.setString(8,eight);
            p.setString(9,nine);
            p.setString(10,ten);
            p.setString(11,eleven);
            p.execute();  //use execute if no results expected back
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            return;
        }
}

public java.sql.ResultSet showGuards(){
        try {
            s = conn.createStatement();
            r = s.executeQuery("SELECT * FROM guard");
            ResultSetMetaData j = r.getMetaData();
        } catch (Exception e) {
        System.out.println(e);
    }
    return r;
}


 public void delete(int id) {
       // int row = jTable1.getSelectedRow();
       // int Code = Integer.parseInt((String) jTable1.getValueAt(row, 0));
        try {
            PreparedStatement p = conn.prepareStatement("DELETE FROM guard WHERE ID = ?;");
            p.setInt(1, id);
            //((DefaultTableModel) jTable1.getModel()).removeRow(row);
            p.execute();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            return;
        }
    }
 
     String msg;
     public String getmsg(){
         return msg;
     }
     public void editGuard(int column,int id){
       //String msg;
         
        if (column == 1) {
            msg = JOptionPane.showInputDialog(null, "Please Enter First Name:");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET first_name=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        } else if (column == 2) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Last Name: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET last_name=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        } else if (column == 3) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Address: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET address=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            } 
        }else if (column == 4) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Date of Birth: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET date_of_birth=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            } 
        }else if (column == 5) {
            String[] list = {"m", "f"};
            msg = (String) JOptionPane.showInputDialog(null, "Choose Gender", "Nice", JOptionPane.QUESTION_MESSAGE, null, list, list[0]);
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET gender=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }else if (column == 7) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Role: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET role=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            } 
        }
        else if (column == 8) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Starting Shift Time: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET shift_start=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }else if (column == 9) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Ending Shift Time: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET shift_end=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }else if (column == 10) {
            String[] list = {"Admin", "Ordinary"};
            msg = (String) JOptionPane.showInputDialog(null, "Choose Status", "Nice", JOptionPane.QUESTION_MESSAGE, null, list, list[0]);
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET status=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }
else if (column == 11) {
            String[] list = {"Block1", "Block2", "Block3","Block4","Block5"};
            msg = (String) JOptionPane.showInputDialog(null, "Choose Station", "Nice", JOptionPane.QUESTION_MESSAGE, null, list, list[0]);
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE guard SET station=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }
    }

public void editPrisoner(int column, int id){


        if (column == 1) {
            msg = JOptionPane.showInputDialog(null, "Please Enter First Name:");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE prisoners SET first_name=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
               // jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        } else if (column == 2) {
           msg = JOptionPane.showInputDialog(null, "Please Enter Last Name: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE prisoners SET last_name=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        } else if (column == 3) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Address: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE prisoners SET address=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            } 
        }else if (column == 4) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Date of Birth: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE prisoners SET date_of_birth=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            } 
        }else if (column == 5) {
            String[] list = {"m", "f"};
            msg = (String) JOptionPane.showInputDialog(null, "Choose Gender", "Nice", JOptionPane.QUESTION_MESSAGE, null, list, list[0]);
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE prisoners SET gender=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
               // jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }else if (column == 6) {
            msg = JOptionPane.showInputDialog(null, "Please Update Crime: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE prisoners SET crime=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            } 
        }
        else if (column == 7) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Date Imprisoned: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE prisoners SET date_imprisoned=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }else if (column == 8) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Release date: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE prisoners SET release_date=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }else if (column == 9) {
            msg = JOptionPane.showInputDialog(null, "Please Enter Other Crimes Committed: ");
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE prisoners SET other_crimes=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }else if (column == 10) {
            String[] list = {"Block1", "Block2","Block3","Block4","Block5"};
            msg = (String) JOptionPane.showInputDialog(null, "Choose Cell Block", "Nice", JOptionPane.QUESTION_MESSAGE, null, list, list[0]);
            try {
                PreparedStatement p = conn.prepareStatement("UPDATE prisoners SET cell_block=? WHERE ID=?;");
                p.setString(1, msg);
                p.setInt(2, id);
                p.execute();
                //jTable1.setValueAt(msg, row, column);
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }
     }
     
    public void deleteGuard(int row, int code) {
        try {
            PreparedStatement p = conn.prepareStatement("DELETE FROM guard WHERE ID = ?;");
            p.setInt(1, code);
            p.execute();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
}
        public void deletePrisoner(int row, int code) {
        try {
            PreparedStatement p = conn.prepareStatement("DELETE FROM prisoners WHERE ID = ?;");
            p.setInt(1, code);
            p.execute();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
}
    public boolean addPrisoner(String one, String two, String three, String four, String five, String six, String seven, String eight, String nine){
    boolean result = true;
 try{

    PreparedStatement p=conn.prepareStatement("Insert Into prisoners set first_name=?, last_name=?,  address=?, gender=?,date_of_birth =?,crime=?,date_imprisoned=?,release_date=?,other_crimes=?");
   
     p.setString(1,one);
     p.setString(2,two);
     p.setString(3,three);
     p.setString(4,four);
     p.setString(5,five);
     p.setString(6, six);
     p.setString(7, seven);
     p.setString(8,eight);
     p.setString(9,nine);
     p.execute();  //use execute if no results
    }catch(Exception e){
        System.out.println("Error"+e.toString()); 
        result = false;
    }
     return result;
   }
    
    public java.sql.ResultSet showPrisoners(){
        try {
            s = conn.createStatement();
            r = s.executeQuery("SELECT * FROM prisoners");
            ResultSetMetaData j = r.getMetaData();
        } catch (Exception e) {
        System.out.println(e);
    }
    return r;
}
}
     


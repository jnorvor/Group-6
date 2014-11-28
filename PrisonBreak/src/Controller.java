/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author salifu
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.*;
import model.*;

public class Controller implements ActionListener {
    java.sql.Connection conn = null;
    java.sql.Statement s;
    java.sql.ResultSet r;

    private static final view.menu themenu = new view.menu();
    private static final view.LogIN login = new view.LogIN();
    private static final ViewPrisoner vp = new ViewPrisoner();
    private static final AddPrisoner addP = new AddPrisoner();
    private static final prisonerdetails detailsP = new prisonerdetails();
    private static final log thelog = new log();
    private static final Guards theguard = new Guards();
    private static final ListGuard listguard = new ListGuard();
    private static final database dbc = new database();
    static int counter = 0;
    JFrame frame = new JFrame();
    
    String username;
    String password;
    String status;
    
    
    public Controller(){
        listeners();
    }
    
    
    private void listeners(){

        //menu -- sign out
        themenu.signOut((ActionEvent evt) -> {
            signout(themenu);
        });
        
        //login
        login.addLogButtonActionListener(new ActionListenerImpl3()
    );
        //menu view prisoners
         themenu.viewPrisoners((ActionEvent evt) -> {
             themenu.setVisible(false);
             vp.setVisible(true);
        });
         
             //menu log file
         /*themenu.log((ActionEvent evt) -> {
             themenu.setVisible(false);
             thelog.setVisible(true);
        });*/
         //menu -- add Prisoner
     themenu.addPrisonerButtonActionListener((ActionEvent evt) -> {
         themenu.setVisible(false);
         addP.setVisible(true);
        });
        //add prisoner --- view prisoners
         addP.viewprisoners(new ActionListenerImpl2()
    );

        //add prisoner, add a prisoner
        addP.addP((ActionEvent evt) -> {
            //put add code
            addPrisoner(addP.getfn(), addP.getln(), addP.getaddress(), addP.getCombo(), addP.getdob(), addP.getCrime(), addP.getimpd(), addP.getdbf(), addP.getCrimes());
        });
        //add prisoner -- menu
         addP.menu((ActionEvent evt) -> {
             addP.setVisible(false);
             themenu.setVisible(true);
        });
         
        //View prisoners -- add prisoner
         vp.addP((ActionEvent evt) -> {
             vp.setVisible(false);
             addP.setVisible(true);
        });
 
         //add prisoner -- menu
         vp.menu((ActionEvent evt) -> {
             vp.setVisible(false);
             themenu.setVisible(true);
        });
                //add prisoner -- menu
         vp.deleteprisoner((ActionEvent evt) -> {
             deletePrisoner();
        });
         
        //listguard-- delete
        vp.editprisoner(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         editPrisoner();
        }
      }
    );

        //menu -- add guard
         themenu.addguard((ActionEvent evt) -> {
             themenu.setVisible(false);
             theguard.setVisible(true);
        });
         
        //guard -- add guard
         theguard.newGuard((ActionEvent evt) -> {
             addGuard();
        });
               //guard -- signout
         theguard.exit((ActionEvent evt) -> {
             signout(theguard);
        });
      
         //guard -- view guards
        theguard.viewguards((ActionEvent evt) -> {
            theguard.setVisible(false);
            listguard.setVisible(true);
            displayGuards(dbc.showGuards());
        });
 
         //guard -- view prisoners
        theguard.viewprisoners((ActionEvent evt) -> {
            theguard.setVisible(false);
            vp.setVisible(true);
        });
    
              //menu-- view guards
        themenu.viewguards(new ActionListenerImpl()
    );
                      //menu-- view prisoners
        themenu.viewPrisoners((ActionEvent evt) -> {
            themenu.setVisible(false);
            vp.setVisible(true);
            displayPrisoners(dbc.showPrisoners());
        });
        
        //listguard-- signout
        listguard.signOut(new ActionListenerImpl1()
    );
        
        //listguard-- EDIT
        listguard.edit((ActionEvent evt) -> {
            editGuard();
        });
        
       //listguard-- delete
        listguard.delete(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         deleteGuard();
        }
      }
    );
        
        listguard.menu(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         listguard.setVisible(false);
         themenu.setVisible(true);
        }
      }
    );
        
        vp.addP(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         vp.setVisible(false);
         addP.setVisible(true);
        }
      }
    );
         vp.menu(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         vp.setVisible(false);
         themenu.setVisible(true);
        }
      }
    );
         
         vp.signout(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
         signout(vp);
        }
      }
    );
       
       
    
    }
    
    public void addPrisoner(String one, String two, String three, String four, String five, String six, String seven, String eight, String nine){
        if(!one.equals("") && !two.equals("") && !three.equals("") && !five.equals("") && !six.equals("")&& !seven.equals("") && !eight.equals("")){
        if(nine.equals(""))JOptionPane.showMessageDialog(addP,"Are you sure"+one+" "+two+" has not committed other crimes?");
        if(dbc.addPrisoner(one, two, three, four, five, six, seven, eight, nine) == true){
          JOptionPane.showMessageDialog(addP, one+" "+two+" has been added!");
          addP.clear();
        }else{
            JOptionPane.showMessageDialog(addP, one+" "+two+" has not been added, please try again!");
        }
        }
        else{
           JOptionPane.showMessageDialog(addP, "Fill all fields appropriately!"); 
        }
        
    }

    
    public void addGuard() {
           if(theguard.getField2().equals("")==false && theguard.getField3().equals("")==false && theguard.getField4().equals("")==false){
            dbc.addGuard(theguard.getField2(),theguard.getField3(),theguard.getField4(),theguard.getField8(),
                    theguard.getCombo(),theguard.getField8(), theguard.getField10(), theguard.getField11(), theguard.getField9(), theguard.getCombo2(), theguard.getCombo3());
            JOptionPane.showMessageDialog(theguard, theguard.getField2()+" "+theguard.getField3()+" has been added!");
            theguard.reset();
           }
           else{
               JOptionPane.showMessageDialog(theguard,"Please enter new guard information");
           }
    }
    
    public void displayGuards(java.sql.ResultSet r){
         try {
           while(r.next()){
            listguard.display(r.getString("ID"), r.getString("first_name"), r.getString("last_name"), r.getString("address"), r.getString("date_of_birth"), r.getString("gender"), r.getString("year_employed"), r.getString("role") ,r.getString("shift_start"), r.getString("shift_end"), r.getString("status"), r.getString("station"));
           }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
public void displayPrisoners(java.sql.ResultSet r){

   try {
           while(r.next()){
            System.out.println(counter++);
            vp.display(r.getString("ID"), r.getString("first_name"), r.getString("last_name"), r.getString("address"), r.getString("date_of_birth"), r.getString("gender"), r.getString("crime"), r.getString("date_imprisoned") ,r.getString("release_date"), r.getString("other_crimes"), r.getString("cell_block"));
           }
        } catch (SQLException ex) {
        }
    } 
        public void deleteGuard() {
        int row = listguard.getRow();
        int Code = listguard.getCode();
        try {
           dbc.deleteGuard(row, Code);
           listguard.deleteRow(row);
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            JOptionPane.showMessageDialog(listguard,"Could not delete guard, try again.");
        }
  }
        
       public void deletePrisoner() {
        int row = vp.getRow();
        int Code = vp.getCode();
        try {
           dbc.deleteGuard(row, Code);
           vp.deleteRow(row);
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
            JOptionPane.showMessageDialog(vp,"Could not delete guard, try again.");
        }
  }

    
       public void signout(JFrame oldframe){
           this.username = "";
           this.password = "";
           oldframe.setVisible(false);
           login.clear();
           //listguard.clear();
           login.setVisible(true);
           System.exit(0);
       }
       
       public static void start(){
           login.setVisible(true);
       }
    
     //invoked when a button is pressed
       @Override
 public void actionPerformed(ActionEvent e){
  
 }
        
        public void editGuard(){
        //String 
        
        dbc.editGuard(listguard.getCol(), dataCode());
        listguard.setVal(dbc.getmsg(), listguard.getRow(), listguard.getCol());
    }
        public void editPrisoner(){
        
        dbc.editPrisoner(vp.getCol(), dataCodeP());
        vp.setVal(dbc.getmsg(), vp.getRow(), vp.getCol());
    }
    
    public int dataCode(){
        int dataCode = listguard.getdataCode();
        return dataCode;
    }
       public int dataCodeP(){
        int dataCode = vp.getdataCode();
        return dataCode;
    }
    
    private static Controller control; 
    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(ViewPrisoner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrisoner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrisoner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrisoner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            //login.setVisible(true);
            control = new Controller();
            control.start();
    }
    
    
   public void logfile(String filename){
       //log logfile = new log();
       
       File thelog = new File(filename);
       try{
       Scanner reader = new Scanner(thelog);
       
       String line;
       while(reader.hasNext()){
           line = reader.next();
           System.out.println(line);
       }
       }catch(FileNotFoundException e){
           JOptionPane.showMessageDialog(frame,"The Log file is missing from your system. See your administrator.");
       }
    }

    private class ActionListenerImpl implements ActionListener {

        public ActionListenerImpl() {
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            themenu.setVisible(false);
            listguard.setVisible(true);
            displayGuards(dbc.showGuards());
        }
    }

    private class ActionListenerImpl1 implements ActionListener {

        public ActionListenerImpl1() {
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            signout(listguard);
        }
    }

    private static class ActionListenerImpl2 implements ActionListener {

        public ActionListenerImpl2() {
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            addP.setVisible(false);
            vp.setVisible(true);
        }
    }

    private class ActionListenerImpl3 implements ActionListener {

        public ActionListenerImpl3() {
        }

        @Override
        public void actionPerformed(ActionEvent evt) {
            if((dbc.logIn(login.getusername(), login.getpassword())) == false){
                JOptionPane.showMessageDialog(login, "Your login details are not recognized by the system.");
            }
            else{
                username = login.getusername();
                password = login.getpassword();
                login.setVisible(false);
                themenu.setVisible(true);
            }
            
        }
    }
    
}
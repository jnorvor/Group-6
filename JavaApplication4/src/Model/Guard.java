package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jude
 */
public class Guard extends Person {
    String fname;
    String lname;
    int yrEmployed;
    String address;
    String dateOfBirth;
    enum gender{M,F};
    int yearEmployed;
    String role;
    String shiftStart;
    String shiftEnd;
    enum status{Admin,Ordinary};
    String password;
    
    public String getfname(){
        return fname;
    }
    
    public String getlname(){
        return lname;
    }
    
    public int getYrEmployed(){
        return yrEmployed;
    }
     
    public String getAddress(){
        return address;
    }
      
    public String getDateOfBirth(){
        return  dateOfBirth;

    }
       
    public int getYearEmployed(){
        return yearEmployed;
    }
        
    public String getRole(){
        return role;
    }
         
    public String getShiftStart(){
        return shiftStart;
    }
          
    public String getShiftEnd(){
        return shiftEnd;
    }
    public void setfname(String temp){
        fname = temp;
    }
    
    public void setlname(String temp){
        lname = temp;
    }
    
    public void setYrEmployed(int temp){
        yrEmployed = temp;
    }
     
    public void setAddress(String temp){
        address = temp;
    }
      
    public void setDateOfBirth(String temp){
        dateOfBirth = temp;

    }
       
    public void setYearEmployed(int temp){
        yearEmployed = temp;
    }
        
    public void setRole(String temp){
        role = temp;
    }
         
    public void setShiftStart(String temp){
        shiftStart = temp;
    }
          
    public void setShiftEnd(String temp){
        shiftEnd = temp;
    }
}

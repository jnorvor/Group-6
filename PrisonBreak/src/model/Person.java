package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author salifu
 */
public class Person {
    
    String firstname;
    String lastname;
    String houseAddress;
    String date_of_birth;
    final int prisonMax = 10000;
    
    enum gender{Male, Female};
    String theGender;
    
    public Person(String fn, String ln, String hA,String dob, String g){
       firstname = fn;
       lastname = ln;
       houseAddress = hA;
       date_of_birth = dob;
       setGender(g);
        
    }
    
    public void setGender(String gen){
       if(gen.equals("F")|| gen.equals("M")){
       theGender = gen;
       }
       else theGender = "not stated";
       
    }
    
    public String getFn(){
        return firstname;
    }
    
    
    public String getLn(){
        return lastname;
    }
    
    public void setFn(String newFn){
        firstname = newFn;
    }
    
    public void setLn(String newLn){
        lastname = newLn;
    }
    
    public String getHA(){
        return houseAddress;
    }
    
    public void setHA(String newHA){
        houseAddress = newHA;
    }
    
    public String getDOB(){
        return date_of_birth;
    }
    
    public void setDOB(String newDOB){
        date_of_birth = newDOB;
    }


    
}

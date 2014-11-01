
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author salifu
 */
public class Prisoner extends Person{
   String dealth_roll_date;
   String crime;
   ArrayList<String> otherCrimes;
   String date_imprisoned;
   String date_to_be_freed;
   String fname;
   String lname;
   String hAddress;
   String birthdate;
   final int prisonersMax = 8000;
   
   
   public Prisoner(String fn, String ln, String hA,String dob, String g, String dRoll, String crime, ArrayList<String> others, String dateImp, String dateFree){
       super(fn, ln, hA, dob, g);
       dealth_roll_date = dRoll;
       otherCrimes = others;
       date_imprisoned = dateImp;
       date_to_be_freed =  dateFree;
   }
   
   public String getfn(){
       return super.getFn();
   }
   
   public void setfn(String newFn){
       super.setFn(newFn);
   }
   
   public String getln(){
       return super.getLn();
   }
   
   public void setln(String newln){
       super.setLn(newln);
   }
   
   public void setAddress(String newAddress){
       super.setHA(newAddress);
   }
   
   public String getAddress(){
       return super.getHA();
   }
   
   public String getbirthdate(){
       return super.getDOB();
   }
   
   public void setbirthdate(String newbirthdate){
       super.setDOB(newbirthdate);
   }
   
   public void setgender(String newGender){
       super.setGender(newGender);
   }
   
   public void addPastCrimes(String oldCrime){
       otherCrimes.add(oldCrime);
   }
   
   public ArrayList<String> getOldCrimes(){
       return otherCrimes;
   }
   
   public String getDateImprisoned(){
       return date_imprisoned;
   }
   
   public String getDateFree(){
       return date_to_be_freed;
   }
   
   public void setDateFree(String newDate){
       date_to_be_freed = newDate;
   }
   
   
}

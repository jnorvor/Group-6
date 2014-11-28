package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author salifu
 */
public class Prisoner{
    int ID;
    String firstname;
    String lastname;
    String houseAddress;
    String date_of_birth;
   String crime;
   String otherCrimes;
   String date_imprisoned;
   String date_to_be_freed;
   String fname;
   String lname;
   String hAddress;
   String birthdate;
//    enum gender{M,F};
    String theGender;
   final int prisonersMax = 8000;
   
   
   public Prisoner(int code,String fn, String ln, String hA,String dob, String g, String crime, String others, String dateImp, String dateFree){
       ID = code;
       firstname = fn;
       lastname = ln;
       houseAddress = hA;
       date_of_birth = dob;
       setGender(g);
       this. crime = crime;
       otherCrimes = others;
       date_imprisoned = dateImp;
       date_to_be_freed =  dateFree;
   }
    public void setGender(String gen){
//       if(gen.equals("F")|| gen.equals("M")){
       theGender = gen;
//       }
//       else theGender = "not stated";
       
    }
    public int getID(){
       return ID;
   }
   public String getfn(){
       return firstname;
   }
   
   public void setfn(String newFn){
       firstname = newFn;
   }
   
   public String getln(){
       return lname;
   }
   
   public void setln(String newln){
       lname = newln;
   }
   
   public void setAddress(String newAddress){
       houseAddress = newAddress;
   }
   
   public String getAddress(){
       return houseAddress;
   }
   
   public String getbirthdate(){
       return date_of_birth;
   }
   
   public void setbirthdate(String newbirthdate){
       date_of_birth = newbirthdate;
   }
   
   public String getGender(){
       return theGender;
   }
   
   public void setgender(String newGender){
       setGender(newGender);
   }
   
   public void setCrimes(String oldCrime){
       crime = oldCrime;
   }
   
    public String getCrimes(){
       return crime;
   }
   
   public void addPastCrimes(String oldCrime){
       otherCrimes = oldCrime;
   }
   
   public String getOldCrimes(){
       return otherCrimes;
   }
   
   public String getDateImprisoned(){
       return date_imprisoned;
   }
   
   public void setDateImprisoned(String temp){
       date_imprisoned = temp;
   }
   
   public String getDateFree(){
       return date_to_be_freed;
   }
   
   public void setDateFree(String newDate){
       date_to_be_freed = newDate;
   }
   
   
}

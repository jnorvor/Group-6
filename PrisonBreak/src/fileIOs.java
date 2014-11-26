//import static fileIOs.writefile;
//import static fileIOs.writefile;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mulbah
 */
public class fileIOs {
 
    public static void writefile() throws Exception 
    {
        FileWriter file = new FileWriter("prisonbreak.txt");
      BufferedWriter bw = new BufferedWriter(file);
      bw.write("Julate");
      bw.close();
    }
    
    public static void Readfile() throws Exception 
    {
        System.out.println("Reading prisonsbreak.java");
      BufferedReader in1 =
          new BufferedReader(   new InputStreamReader(new FileInputStream("Datapb.txt"))); 
     String x=null;
     while ((x=in1.readLine()) !=null)
   {
    System.out.println(x);
   }
        
        
    }
   public static void main (String agrs[]) throws Exception{
       try{
               writefile();
               Readfile();
               
       }catch (Exception e){
                  System.out.println(e.toString());
              }
     }
   }



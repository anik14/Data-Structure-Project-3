/*
File: RunwayDriver.java
Author: Mohammad Islam
Date: 10/25/16
HW: 3 Question 2
Description: RunwayDriver class.
Worked with ZJ Zhang, TJ Cui
*/

import java.util.*;

public class RunwayDriver
{
   public static void main(String args[]){
     
      
      int ltTime = 15;  
         
           
      Queue<AirLine> planeLanding = new LinkedList<AirLine>(); 
      Queue<AirLine> planeTakingOff = new LinkedList<AirLine>(); 
   
   
      RunwaySimulation sim1 =new RunwaySimulation(1, true); 
      RunwaySimulation sim2 =new RunwaySimulation(2, true);
      int countTakeOff = 0;
      int countLand = 0;
      int k = 0;
      
      while (k<120)
      {     
         double ranNum =Math.random();
         double probabilityOfLan = 0.1;
         
         if(ranNum < probabilityOfLan){ 
            planeLanding.add(new AirLine(true,1));
         }
         double ranNum2 = Math.random();
         double probabilityOfTak = 0.1;
         if(ranNum2 < probabilityOfTak)
         {
            planeTakingOff.add(new AirLine(false,1));
         }
         
         int flyTime=0;   
         int lanTime=0;
       
      
         if(k == flyTime)
         {
            sim1.setRunwayPlane(true);
         }
         else if(k ==lanTime)
         {
            sim2.setRunwayPlane(true);
         }
        
         
         if(!planeLanding.isEmpty())
         {
            if(sim1.getRunwayPlane())
            {
               sim1.setRunwayPlane(false);
               flyTime = ltTime+k;  
               planeLanding.remove(); 
               countLand++;
               
                     
            }
            
            else if(sim2.getRunwayPlane())
            {
               sim2.setRunwayPlane(false);
               lanTime = ltTime+k;
               planeLanding.remove();
               countLand++;
               
               
            }
         }
         
         
         else if(!planeTakingOff.isEmpty())
         {
            if(sim1.getRunwayPlane())
            {
               sim1.setRunwayPlane(false);
               flyTime = ltTime+k;

               planeTakingOff.remove();
               countTakeOff++;
                           }
            else if(sim2.getRunwayPlane())
            {
               sim2.setRunwayPlane(false);
               lanTime = ltTime+k;

               planeTakingOff.remove();
               countTakeOff++;
                           }
         }
        
         k++;
      }
       
     

      System.out.println("Number of planes are in line to take off is: "+planeTakingOff.size());
      System.out.println("The planes that are in line to take off: "+planeTakingOff);
      System.out.println("Number of planes that took off: "+countTakeOff);
      if(countTakeOff > 0)
      {
      double waitingTime = 120/countTakeOff;
      System.out.println("Average waiting time for take off: " + waitingTime);
      }
      
      System.out.println("Number of planes are in line to land is: "+planeLanding.size());
      System.out.println("The planes are in line to land: "+planeLanding);
      System.out.println("Number of Planes that landed: "+countLand);

      if(countLand > 0)
      {   double landingTime = 120/countLand;
         System.out.println("Average waiting time for landing: " + landingTime);
            }
      
     
   }
}

/*
File: RunwayDriver.java
Author: Mohammad Islam
Date: 10/25/16
HW: 3 Question 2
Description: RunwayDriver class.
Worked with ZJ Zhang, TJ Cui
*/


public class RunwaySimulation
{
  
      
   private int countRun;
   private boolean runwayPlane;


   public RunwaySimulation(){
   }
   public RunwaySimulation(int newCountRun, boolean newRunwayPlane ){
     countRun = newCountRun;
     runwayPlane = newRunwayPlane;
   }

   public void setRunwayPlane(boolean theRunwayPlane)
   {
      runwayPlane = theRunwayPlane;
   }
   
   public boolean getRunwayPlane()
   {
      return runwayPlane;
   }
   
   public void setCountRun(int theCountRun)
   {
      countRun = theCountRun;
   }
   
   public int getCountRun()
   {
      return countRun;
   }
  }
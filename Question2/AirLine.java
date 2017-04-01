/*
File: AirLine.java
Author: Mohammad Islam
Date: 10/25/16
HW: 3 Question 2
Description: AirLine class.
Worked with ZJ Zhang, TJ Cui
*/

public class AirLine
{

   
   private boolean takingOffOrLanding;
   private int countPlanes;
   
 
   public AirLine(){
   
   }
   
   public AirLine (boolean theTakingOffOrLanding,int theCountPlanes)
   {
      takingOffOrLanding = theTakingOffOrLanding;
      countPlanes = theCountPlanes;
   }


   public void setTakingOffOrLanding(boolean theTakingOffOrLanding)
   {
      takingOffOrLanding = theTakingOffOrLanding;
   }
   
   public boolean getTakingOffOrLanding()
   {
      return takingOffOrLanding;
   }
   
   public void setCountPlanes(int theCountPlanes)
   {
      countPlanes = theCountPlanes;
   }
   
   public int getCountPlanes()
   {
      return countPlanes;
   }
   
}

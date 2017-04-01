/*
File: Expression.java
Author: Mohammad Islam
Date: 10/25/16
HW: 3 Question 1
Description: Driver class using all the classes.
Worked with ZJ Zhang, TJ Cui
*/

 
import javax.swing.JOptionPane; 
import java.util.InputMismatchException;
import java.util.Scanner;

public class Expression {


   public static void main(String[] args) {
        
      boolean done = false;
        
      
      while (!done) {
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Select an operation (Enter 1,2,3,4,5)"
                    + "\n\t1. Balanced Symbols Check"
                    + "\n\t2. Infix to Postfix Conversion"
                    + "\n\t3. Postfix to Infix Conversion"
                    + "\n\t4. Evaluating a Postfix Expression"
                    + "\n\t5. Quit");
         try {
               
            int choice = keyboard.nextInt();
                
                // call appropriate method based on choice
            switch (choice) {
               case 1: // Balanced Symbols Check
                  checkParens();
                  break;
               case 2: // Infix to Postfix Conversion
                  infixToPostfix();
                  break;
               case 3: // Postfix to Infix Conversion
                  postfixToInfix();
                  break;
               case 4: // Evaluating a Postfix Expression
                  evalPostfix();
                  break;
               case 5: // Quit
                  done = true;
                  break;
               default:
                  System.out.println("Innvalid selection, please try again.");
                  break;
            }
         } 
         catch (InputMismatchException e) {    
            System.out.println("Innvalid selection, please try again.");
         }
         System.out.println();
      }
   }

   
   private static void checkParens() {
      String chekpar =JOptionPane.showInputDialog(
               "Enter an expression with paretheses");
      if(ParenChecker.isBalanced(chekpar)){
         JOptionPane.showMessageDialog(null,chekpar
                                          +"is balanced");
      }
      else {
         JOptionPane.showMessageDialog(null,chekpar
                                          +"is not balanced");
      }
      System.exit(0);
   }
    
   private static void infixToPostfix() {
      InfixToPostfix inPo =new InfixToPostfix();
      String infix = JOptionPane.showInputDialog
                     ("Enter an infix expression");
      try{
         String postfix=inPo.convert(infix);
         JOptionPane.showMessageDialog(null,
                  "Infix expression "+infix+
                  "\nconverts to "+postfix);
      }
      catch (SyntaxErrorException e){
         JOptionPane.showMessageDialog(null,e.getMessage());
      }
      System.exit(0);        
      }    
   
      private static void postfixToInfix() {
      PostfixToInfix poIn =new PostfixToInfix();
      String postfix = JOptionPane.showInputDialog
                     ("Enter an postfix expression");
      try{
         String infix= poIn.convert(postfix);
         JOptionPane.showMessageDialog(null,
                  "Infix expression "+postfix+
                  "\nconverts to "+infix);
      }
      catch (SyntaxErrorException e){
         JOptionPane.showMessageDialog(null,e.getMessage());
      }
      System.exit(0);
   }
    
       private static void evalPostfix() {
      PostfixEvaluator evalPo =new PostfixEvaluator();
      String postfix = JOptionPane.showInputDialog
                     ("Enter an postfix expression");
                   
      try{
         int result= evalPo.eval(postfix);
         JOptionPane.showMessageDialog(null,
                  "Infix expression "+postfix+
                  "\nconverts to "+result);
      }
      catch (SyntaxErrorException e){
         JOptionPane.showMessageDialog(null,e.getMessage());
      }
      System.exit(0);
   }
}
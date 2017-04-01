/*
File: PostfixToInfix.java
Author: Mohammad Islam
Date: 10/25/16
HW: 3 Question 1
Description: PostfixToInfix class.
Worked with ZJ Zhang, TJ Cui
*/

import javax.swing.JOptionPane;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;


public class PostfixToInfix {

    
   private static final String[] OPERATORS = {"+", "-", "*", "/", "%"};
   private static Stack<String> stack;
    
       public static String convert(String postfix) throws SyntaxErrorException {
        
      stack = new Stack<String>();
      try {
            
         StringTokenizer sToke = new StringTokenizer(postfix);   
         String next;    
            
         while (sToke.hasMoreTokens()) {
            next = sToke.nextToken();
                
            try {   
               stack.push(Integer.parseInt(next) + "");
               continue;
            } 
            catch (NumberFormatException e) {}
            try {   
               stack.push(Double.parseDouble(next) + "");
               continue;
            } 
            catch (NumberFormatException e) {}
                
                
            if (isOp(next)) {  
               processOp(next);
            } 
            else if (next.matches("\\w+")) {  
               stack.push(next);
            } 
            else { 
                   
               throw new SyntaxErrorException("Unexpected Token Encountered: " + next);
            }
         }
        
         String infix = stack.pop(); 
            
         if (!stack.empty()) {  
            throw new SyntaxErrorException("Elements left on stack");
         }
            
          
         return infix.substring(1, infix.length() - 1).trim();
            
      } 
      catch (EmptyStackException e) {   
         throw new SyntaxErrorException("Attempt to pop from an empty stack");
      }
        
        
   }
    
       public static void processOp(String op) throws EmptyStackException {
     
      String operand2 = stack.pop();
      String operand1 = stack.pop();
        
             stack.push("(" + operand1 + " " + op + " " + operand2 + ")");
   }
    
      private static boolean isOp(String op) {
      for (String s : OPERATORS) {
         if (op.equals(s)) {
            return true;    
         }
      }
      return false; 
   }
}

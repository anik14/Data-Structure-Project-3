/*
File: PostfixEvaluator.java
Author: Mohammad Islam
Date: 10/25/16
HW: 3 Question 1
Description: PostfixEvaluator class.
Worked with ZJ Zhang, TJ Cui
*/

import java.util.Scanner;
import java.util.Stack;
import javax.swing.JOptionPane;

public class PostfixEvaluator {
	
   private static final String OPERATORS = "+-*/";
	
	
   private Stack<Integer> operandStack;

	   public int eval(String expression) throws SyntaxErrorException {
      operandStack = new Stack<Integer>();
   
   	
      processTokens(expression);
   
      return getFinalResult();
   }

	   private int getFinalResult() throws SyntaxErrorException {
      if (operandStack.isEmpty()) {
         throw new SyntaxErrorException ("No value to return!");	
      }
   
      if (operandStack.size() > 1) {
         throw new SyntaxErrorException ("Too many operands!");
      }
   
      return operandStack.pop();
   }

	   private void processTokens(String expression) throws SyntaxErrorException {
      Scanner tokens = new Scanner(expression);
      String nextToken;
      while (tokens.hasNext()) {
         nextToken = tokens.next();
      	
      	
         if (Character.isDigit(nextToken.charAt(0))) {
            int value = Integer.parseInt(nextToken);
            operandStack.push(value);
         } 
         
         
         else if (isOperator(nextToken)) {
            int result = evalOp(nextToken);
            operandStack.push(result);
         } 
         
         
         else {
            throw new SyntaxErrorException("Invalid character encountered");
         }
      }
      tokens.close();
   }

	   private boolean isOperator(String str) {
   	      if (str.length() > 1) {
         return false;
      }
   	
   	      return OPERATORS.indexOf(str.charAt(0)) != -1;
   }

	   private int evalOp(String op) throws SyntaxErrorException {
   	      if (operandStack.empty()) {
         throw new SyntaxErrorException("Stack is empty");
      }
      int rhs = operandStack.pop();
   	
      if (operandStack.empty()) {
         throw new SyntaxErrorException("Stack is empty");
      }
      int lhs = operandStack.pop();
   	
   	
      switch (op.charAt(0)) {
         case '+':
            return lhs + rhs;
         case '-':
            return lhs - rhs;
         case '*':
            return lhs * rhs;
         case '/':
            return lhs / rhs;
      }
   
   	      assert false;
      return 0;
   }
	
	   public static void main(String[] args) {
      PostfixEvaluator postCal =new PostfixEvaluator();
      String expression = JOptionPane.showInputDialog
                     ("Enter an postfix expression");
                     
      try{
         int result=postCal.eval(expression);
         JOptionPane.showMessageDialog(null,
                  "Infix expression "+expression+
                  "\nconverts to "+result);
      }
      catch (SyntaxErrorException e){
         JOptionPane.showMessageDialog(null,e.getMessage());
      }
      System.exit(0);
   }
   
}
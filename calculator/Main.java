
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends Pic{

  // for claculation
  static int myFunc(int num1, int num2, String opr){
    int res;
    if (opr.equals("add")){
      res = num1 + num2;
      System.out.println(num1 + " + " + num2 + " = " + res);
    }else if(opr.equals("subtract")){
      res = num1 - num2;
      System.out.println(num1 + " - " + num2 + " = " + res);
    }else if(opr.equals("multiply")){
      res = num1 * num2;
      System.out.println(num1 + " * " + num2 + " = " + res);
    } else {
      res = num1 / num2;
      System.out.println(num1 + " / " + num2 + " = " + res);
    }
    return res;
  }
  
  public static void main(String[] args){
    System.out.println(logo);

    // declare
    int result;
    String operation, con_cal;
    char bullet = '\u2022';
    int int1 = 0, int2 = 0;
    Scanner input = new Scanner (System.in);
    boolean off_do1, off_do2, go_while;
    go_while = true;
    off_do1 = off_do2 = false;

    do {
      try{
        System.out.println("\nEnter the first integer: ");
        int1 = Integer.parseInt(input.nextLine());
        off_do1 = true; // Exit if valid
      } catch (Exception e){
        System.out.println("Wrong data type. Please enter an integer.");
      }
    } while (!off_do1);

    while (go_while){
      do {
        try{
          System.out.println("\nEnter the second integer: ");
          int2 = Integer.parseInt(input.nextLine());
          off_do2 = true; // Exit if valid
        } catch (Exception e){
          System.out.println("Wrong data type. Please enter an integer.");
          input.next(); // Consume invalid
        }
      } while (!off_do2);

      // operation
      System.out.println("\n" + bullet + "Add\n" + bullet + "Subtract\n" + bullet + "Multiply\n" + bullet + "Divide\n" + "Pick one operation from above");
      operation = input.nextLine();
      result = myFunc(int1, int2, operation.toLowerCase());
      System.out.println("\ntype \"y\" to continue calculating with " + result + ", type \"n\" to exit: ");
      con_cal = input.nextLine();
      if (con_cal.equalsIgnoreCase("n")){
        go_while = false;
      } else {
        int1 = result;
      }
    }
    }
  }

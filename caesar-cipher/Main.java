
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;


public class Main extends Objects {
  
  static ArrayList<Integer> encode(char[] plain_txt, int shifter){
    ArrayList<Integer> en_idx = new ArrayList<Integer>();
    shifter %= 26;
      for (char txt: plain_txt){
        for(int i = 0; i < alp.length; i++){
          if (txt == alp[i]){ 
            en_idx.add(i + shifter); 
          }
        }
      }
    return en_idx;
  }

  static ArrayList<Integer> decode(char[] plain_txt, int shifter){
    ArrayList<Integer> de_idx = new ArrayList<Integer>();
    shifter %= 26;
      for (char txt: plain_txt){
        for(int i = 0; i < alp.length; i++){
          if (txt == alp[i]){ 
            de_idx.add(i - shifter); 
          }
        }
      }
    return de_idx;
  }

  static String code_reader(ArrayList<Integer> list_idx){
    String res = "";
    for (int ele: list_idx){
          res += alp[ele];;
        }
    return res;
    }

  
  public static void main (String[] args) {

    // print logo
    System.out.println(logo);
    
    // declare
    int shift;
    char[] array_txt;
    Scanner obj = new Scanner(System.in);
    String direction, input_txt, res_txt, go_again;
    ArrayList<Integer> res_idx = new ArrayList<Integer>();

    while (true){
      // input
      System.out.println("\n\nType 'encode' to encrypt, type 'decode' to decrypt: ");
      direction = obj.nextLine();
      
      System.out.println("Type your message: ");
      input_txt = obj.nextLine();
      
      System.out.println("Type the shift number: ");
      shift = Integer.parseInt(obj.nextLine());

      // case
      if (direction.equals("encode")){
        array_txt = input_txt.toCharArray();

        res_idx = encode(array_txt, shift);   
        res_txt = code_reader(res_idx);
        System.out.println("Here's the encoded result: " + res_txt);
      } else {
        array_txt = input_txt.toCharArray();

        res_idx = decode(array_txt, shift);   
        res_txt = code_reader(res_idx);
        System.out.println("Here's the decoded result: " + res_txt);
      }

      // go again or not
      System.out.println("Type 'yes' if you want to go again. Otherwise type 'no'.");
      go_again = obj.nextLine();
      if(go_again.equals("no")){
        break;
      }
    }
  }
}

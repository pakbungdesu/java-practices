
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;


public class Main extends Details {
  static ArrayList<Integer> check_guess(char[] arr, char user_guess){
    ArrayList<Integer> indices = new ArrayList<Integer>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == user_guess){
        indices.add(i);// right guess
      } 
    }
    return indices;
  }

static String update_dis(char[] arr, ArrayList<Integer> all_idx){
  String return_value = "";
  for (int i = 0; i < arr.length; i++){
      if (all_idx.contains(i)) {
        return_value += arr[i] + " ";
    } else {
        return_value += "_ ";
    }
  }
  return return_value;
}
  
  public static void main(String[] args) {
    System.out.println(logo);

    // declare
    String choose, new_display;
    char guess;
    int lives = 6;
    int rand_w, rand_l;
    char[] array_l;
    ArrayList<Integer> dis_idx = new ArrayList<Integer>();
    ArrayList<Integer> check_idx = new ArrayList<Integer>();

    // random a word
    rand_w = (int)(Math.random() * words.length);
    choose = words[rand_w];
    array_l = choose.toCharArray();

    // display
    rand_l = (int)(Math.random() * array_l.length);
    dis_idx.add(rand_l);
    new_display = update_dis(array_l, dis_idx);
    System.out.println(new_display);
    

    while (lives > 0){
      // make a guess
      System.out.print("\n\nYour lives: " + lives + "\nGuess a letter: ");
      Scanner obj = new Scanner(System.in);
      guess = obj.next().charAt(0);

      // check a guess
      check_idx = check_guess(array_l, guess);

      if (check_idx.size() != 0){
        System.out.println("You guessed " + guess + ", That's correct.");
        System.out.println(stages[lives]);
        
        // add new correct item and update display
        for (int i: check_idx){
          dis_idx.add(i);
        }
      } else {
        // no new correct item, same display
        System.out.println("You guessed " + guess + ", that's not in the word. You lose a life.");
        lives -= 1;
        System.out.println(stages[lives]);
      }
      new_display = update_dis(array_l, dis_idx);
      System.out.println(new_display);

      if (new_display.replaceAll(" ","").equals(choose)){
        System.out.println("You win. Congratulation ✨");
        break;
      } 
    }
    if (lives == 0){
      System.out.println("\nYour lives: " + lives + "\nThe word is " + choose + ".\nYou lose. Wanna give another try? 🔥");
    }
  }
}

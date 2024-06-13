
import java.util.Scanner;
import java.util.HashMap;
import java.io.*;

public class Main extends Pics{
  public static void main(String[] args) {

    // greeting
    System.out.println(welcome);  
    System.out.println("\n\nIt's a rock-paper-scissor game!\nWIN +2\nTIED +1\nLOSE 0\n");

    // declare
    int user_hand, bot_hand, user_score, bot_score;
    int[][] score = {{1, 0, 2}, {2, 1, 0}, {0, 2, 1}};
    int sum_user = 0, sum_bot = 0, i = 1;
    String[] hands_bot = {"rock", "paper", "scissor"};
    HashMap<String, String> hands_user = new HashMap<String, String>();
    hands_user.put("rock", "0");
    hands_user.put("paper", "1");
    hands_user.put("scissor", "2");
    
    // continue or stop
    System.out.println("Do you want to continue or stop?");
    Scanner input = new Scanner(System.in);
    String user_con = input.nextLine();

    // loop
    while(true){
      // user
      System.out.println("\nRound " + i);
      System.out.println("What do you choose?");
      String user_choose = (input.nextLine()).toLowerCase();
      user_hand = Integer.parseInt(hands_user.get(user_choose));
      System.out.println(all_pics[user_hand]);

      // computer
      bot_hand = (int)(Math.random() * 3);
      System.out.println("Bot chose " + hands_bot[bot_hand]);
      System.out.println(all_pics[bot_hand]);

      // score
      user_score = score[user_hand][bot_hand];
      System.out.println("You got +" + user_score);
      sum_user += user_score;
      
      bot_score = score[bot_hand][user_hand];
      sum_bot += bot_score;

      // continue or stop
      System.out.println("Do you want to continue or stop?");
      user_con = input.nextLine();
      if ("stop".equalsIgnoreCase(user_con)){
          break;
      }
      i++;
    }

    System.out.println("\nYour total score: " + sum_user);
    System.out.println("Bot's total score: " + sum_bot);
    if (sum_user > sum_bot){
      System.out.println("You win! Congratulation ✨");
    } else if (sum_user == sum_bot) {
      System.out.println("It's a tied match 🥊");
    } else {
      System.out.println("You lost. Wanna give another try? 🔥");
    }
  }
}

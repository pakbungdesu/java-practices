
import java.util.Scanner;
import java.io.*;


public class Main extends Pic{
  public static void main(String[] args) {

    // greeting
    System.out.println(welcome + "\n");  
    System.out.println("It's a rock-paper-scissor game!\nWIN +2\nTIED +1\nLOSE 0\n");

    // score
    int user_hand;
    int bot_hand;
    int user_score;
    int bot_score;
    int[][] score = {{1, 0, 2}, {2, 1, 0}, {0, 2, 1}};
    int sum_user = 0;
    int sum_bot = 0;

    // continue or stop
    System.out.println("Do you want to continue or stop?");
    Scanner input = new Scanner(System.in);
    String user_con = input.nextLine();
    int i = 1;

    // loop
    while(true){
      // user
      System.out.println("\nRound " + i);
      System.out.println("What do you choose?");
      String user_choose = input.nextLine();

      if ("rock".equalsIgnoreCase(user_choose)){
        user_hand = 0;
        System.out.println(rock_pic);
      } else if ("paper".equalsIgnoreCase(user_choose)){
        user_hand = 1;
        System.out.println(paper_pic);
      } else {
        user_hand = 2;
        System.out.println(scissor_pic);
      }

      // computer
      bot_hand = (int)(Math.random() * 3);
      if (bot_hand == 0){
        System.out.println("Bot chose rock.");
        System.out.println(rock_pic);
      } else if (bot_hand == 1){
        System.out.println("Bot chose paper.");
        System.out.println(paper_pic);
      } else {
        System.out.println("Bot chose scissor.");
        System.out.println(scissor_pic);
      }

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
    } else if (sum_user < sum_bot) {
      System.out.println("You lost. Wanna give another try? 🔥");
    } else {
      System.out.println("It's a tied match 🥊");
    }
  }
}

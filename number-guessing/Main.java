
import java.util.Random;
import java.util.Scanner;

public class Main extends Pic{

  static int Check_guess(int answer, int guess, int turn) {
      int res;
      if (guess == answer) {
        System.out.println("You got it! The answer was " + answer);
        res = 1; // game end
      } else {
          res = 0; // game on
          if (guess > answer) {
              System.out.println("Too high. Guess again.");
          } else {
              System.out.println("Too low. Guess again.");
          }
      }
      return res;
  }
  
  public static void main(String[] args) {

    // declare
    String diff;
    int lives, ans, make_guess, check;
    Random rand = new Random();
    Scanner sc = new Scanner (System.in);
    
    System.out.println(logo);
    System.out.println("\nI'm thinking of a number between 1 and 100.\nChoose a difficulty. Type 'easy' or 'hard'");
    diff = sc.nextLine().toLowerCase();

    if (diff.equals("easy")){
      lives = 10;
    } else {
      lives = 7;
    }

    ans = rand.nextInt(100) + 1;
    check = 0; // game on

    // game loop
    while (lives > 0 && check == 0){
      System.out.println("You have " + lives + " attempts remaining to guess the number.\nMake a guess");
      make_guess = sc.nextInt();
      check = Check_guess(ans, make_guess, lives);
      if (check == 0){
        lives -= 1;
      }

    if (lives == 0){
      System.out.println("Pssst, the correct answer is " + ans + "\nYou've run out of guesses, you lose.");
    }
    }
  }
}


import java.util.HashMap;
import java.util.Scanner;

public class Main {

  static HashMap<String, String> Quiz(){
    HashMap<String, String> quizs = new HashMap<String, String>();
    quizs.put("A slug's blood is green.", "false");
    quizs.put("The loudest animal is the African Elephant.", "false");
    quizs.put("Approximately one quarter of human bones are in the feet.", "true");
    quizs.put("The total surface area of a human lungs is the size of a football pitch.", "true");
    quizs.put("In West Virginia, USA, if you accidentally hit an animal with your car, you are free to take it home to eat.", "true");
    quizs.put("In London, UK, if you happen to die in the House of Parliament, you are entitled to a state funeral.", "false");
    quizs.put("It is illegal to pee in the Ocean in Portugal.", "true");
    quizs.put("You can lead a cow down stairs but not up stairs.", "false");
    quizs.put("Google was originally called 'Backrub'.", "true");
    quizs.put("Buzz Aldrin's mother's maiden name was 'Moon'.", "true");
    quizs.put("No piece of square dry paper can be folded in half more than 7 times.", "false");
    quizs.put("A few ounces of chocolate can to kill a small dog.", "true");

    return quizs;
  }

  static void Logo(){
    String logo = """
       ██████╗ ██╗   ██╗██╗███████╗     ██████╗  █████╗ ███╗   ███╗███████╗
      ██╔═══██╗██║   ██║██║╚══███╔╝    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝
      ██║   ██║██║   ██║██║  ███╔╝     ██║  ███╗███████║██╔████╔██║█████╗  
      ██║▄▄ ██║██║   ██║██║ ███╔╝      ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  
      ╚██████╔╝╚██████╔╝██║███████╗    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗
       ╚══▀▀═╝  ╚═════╝ ╚═╝╚══════╝     ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝
      """;
    
    System.out.println(logo);
  }

  
  public static void main(String[] args) {

    // declare
    Scanner sc = new Scanner(System.in);
    HashMap<String, String> allq;
    int question = 1, total = 0;
    String answer, check;

    // function
    Logo();
    allq = Quiz();

    for (String ele: allq.keySet()){
      // question
      System.out.print("\nQ." + question + "\n");
      System.out.println(ele + "(true/false)");

      // answer
      answer = sc.nextLine();
      check = allq.get(ele);
      if (answer.equalsIgnoreCase(check)){
        System.out.println("Correct answer. Great job 🥊");
        total += 1;
      } else {
        System.out.println("Wrong! The correct answer is " + check + " 🔥");
      }

      // score
      if (question == allq.size()){
        System.out.println("Your final score: " + total + "/" + question + "✨");  
      } else {
        System.out.println("Your total score: " + total + "/" + question);
      }

      // next question
      question += 1;
    }
  }
}

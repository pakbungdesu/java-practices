
import java.util.Scanner;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {

    // logo
    String logo = """
                             ___________
                             \\         /
                              )_______(
                              |'''''''|_.-._,.---------.,_.-._
                              |       | | |               | | ''-.
                              |       |_| |_             _| |_..-'
                              |_______| '-' `'---------'` '-'
                              )'''''''(
                             /_________\\
                           .-------------.
                         /_______________\\
            """;
    System.out.println(logo);
      
    // declare
    int bit_int, max_bit = 0;
    String name, bit_txt, other, max_name = "";
    Scanner sc = new Scanner(System.in);
    HashMap<String, String> bid_info = new HashMap<String, String>();

    while (true){
      System.out.print("\nWhat is your name?: ");
      name = sc.nextLine();
      System.out.print("What is your bit?: $");
      bit_txt = sc.nextLine();

      for (int i = 0; i < 2; i++){
        bid_info.put(name, bit_txt);
      }

      System.out.print("Are there any other bidders? Type 'yes or 'no': ");
      other = sc.nextLine();
      if (other.equals("no")){
        break;
      }
    }

    
    for (String ele: bid_info.keySet()){
      bit_int = Integer.parseInt(bid_info.get(ele));
      if (bit_int > max_bit){
        max_bit = bit_int;
        max_name = ele;
      }
    }

    System.out.print("\nThe winner is " + max_name + " with a bit of $" + max_bit);
  }
}

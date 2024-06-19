
import java.util.HashMap;
import java.util.Scanner;


public class CoffeeMaker extends Pic {
    Scanner sc = new Scanner(System.in);

    public Double[] Resources(){
        // index 0 = water, 1 = milk, 2 = coffee
        Double[] allres = {300.0, 200.0, 100.0};
        return allres;
    }

    public double Profit(){
        double Myprofit = 0.0;
        return Myprofit;
    }

    public boolean CheckMenu(String input_menu){
        HashMap<String, Double[]> all_menu = MenuItem();

        for (String ele : all_menu.keySet()) {
            if (input_menu.equalsIgnoreCase(ele)){
                return true;
            }
          }
        return false;
    }

    public boolean Sufficient(String menu_name, Double[] curr_res){
        Double[] curr_menu = MenuItem().get(menu_name);

        for (int i = 0; i < curr_menu.length - 1; i ++){
            if (curr_menu[i] > curr_res[i]){
                System.out.println("Sorry, there are not sufficient resources.");
                return false;
            }
        }
        return true;
    }

    public HashMap<String, Double[]> MenuItem(){
        HashMap<String, Double[]> menu = new HashMap<String, Double[]>();

        // index 0 = water, 1 = milk, 2 = coffee, 3 = cost
        Double[] lat = {200.0, 150.0, 24.0, 2.5};
        Double[] esp = {50.0, 0.0, 18.0, 1.5};
        Double[] cap = {250.0, 50.0, 24.0, 3.0};

        menu.put("latte", lat);
        menu.put("espresso", esp);
        menu.put("cappuccino", cap);

        return menu;
    }

    public Double[] MakePayment(double user_money, String name_menu){

        Double[] result = new Double[2];
        int q, d, n, p;
        Double[] curr_menu = MenuItem().get(name_menu);

        System.out.println("Please insert coins.");
        System.out.println("How many quarters?");
        q = sc.nextInt();
        System.out.println("How many dimes?");
        d = sc.nextInt();
        System.out.println("How many nickles?");
        n = sc.nextInt();
        System.out.println("How many pennies?");
        p = sc.nextInt();

        user_money += (q*0.25)+(d*0.1)+(n*0.05)+(p*0.01);
        if (user_money != curr_menu[3]){
            result[0] = user_money;
            result[1] = user_money - curr_menu[3]; // change
        } else{
            result[0] = user_money;
            result[1] = 0.0; // change
        }
        return result;
    }

    public double InsertMore(double user_change){
        double more;
        if (user_change >= 0.0){
            more = 0.0;
            if (user_change > 0.0){
                System.out.println("There is $" + user_change + " in change.");
            } else{
                System.out.println("There is no change.");
            }
        } else {
            more =  Math.abs(user_change);
            System.out.println("Insert more " + more);
        }
        return more;
    }

    public Double[] UpdateResources(String name_menu, Double[] myres){
        Double[] curr_menu = MenuItem().get(name_menu);
        for (int i = 0; i < curr_menu.length - 2; i++){ // exclude cost
            myres[i] -= curr_menu[i];
        }
        return myres;
    }

    public double UpdateProfit(String name_menu, double profit_curr){
        Double[] menu_curr = MenuItem().get(name_menu);
        return profit_curr + menu_curr[3];
    }


    public static void main(String[] args){
        System.out.println(logo);
  
        // declare
        String want;
        Double[] myresource, res;
        boolean check, enough;
        double insert_more, myProfit;
        Scanner sc = new Scanner(System.in);
        CoffeeMaker obj = new CoffeeMaker();
  
        myresource = obj.Resources();
        myProfit = obj.Profit();
  
        while (true){
                    
          System.out.println("What would you like? (espresso/latte/cappuccino)");
          want = sc.nextLine();
  
          if (want.equals("off")){
              break;
          } else if(want.equals("report")){
              System.out.println("Water: " + myresource[0]);
              System.out.println("Milk: " + myresource[1]);
              System.out.println("Coffee: " + myresource[2]);
              System.out.println("Total profit: " + myProfit);
  
          } else {
              check = obj.CheckMenu(want);
              if (check == true) {
                  enough = obj.Sufficient(want, myresource);
                  if (enough == true){
                      res = obj.MakePayment(0.0, want);
                      insert_more = obj.InsertMore(res[1]);
  
                      while (insert_more != 0.0){
                          res = obj.MakePayment(res[0], want);
                          insert_more = obj.InsertMore(res[1]);
                      }
  
                      myresource = obj.UpdateResources(want, myresource);
                      myProfit = obj.UpdateProfit(want, myProfit);
  
                  }
              } else {
                  System.out.println("Sorry, the item is not avaliable.");
            }
          }
        }
        sc.close();
    }
}

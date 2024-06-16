
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Blackjack extends Pic{


    public ArrayList<Integer> Deck(){
        ArrayList<Integer> cards = new ArrayList<Integer>();
        cards.add(11); cards.add(2); cards.add(3);
        cards.add(4); cards.add(5); cards.add(6);
        cards.add(7); cards.add(8); cards.add(9);
        cards.add(10); cards.add(10); cards.add(10);
        cards.add(10);
        return cards;
    }

    public ArrayList<Integer> Update_deck(ArrayList<Integer> alldeck, int remove_idx){
        alldeck.remove(remove_idx);
        return alldeck;
    }


    public int Draw(ArrayList<Integer> alldeck){
        // draw
        Random rand = new Random();
        int n = rand.nextInt(alldeck.size()-1);
        // remove this idx from deck
        return n;
    }

    // update deck hold
    // and check if sum of score > 21 and there is 11, replace with 1
    public ArrayList<Integer> Deck_hold(ArrayList<Integer> curr_deck, ArrayList<Integer> alldeck, int remove_idx){
        curr_deck.add(alldeck.get(remove_idx));
        if (Sum(curr_deck) > 21){
            for (int i = 0; i < curr_deck.size(); i++){
                if (curr_deck.get(i) == 11){
                    curr_deck.set(i, 1);
                }
            }
        }
        return curr_deck;
    }

    public int Sum(ArrayList<Integer> curr_deck){
        int sum = 0;
        for(int i : curr_deck) {
            sum += i;
        }
        return sum;
    }

    public void Compare(int sum_player, int sum_dealer){
        if (sum_player == 21){
            System.out.println("You win with a Blackjack 😎");
        } else if (sum_dealer == 21){
            System.out.println("Opponent got a Blackjack. You lose 😱");
        } else if (sum_player < 21 && sum_dealer < 21){
            if (sum_player > sum_dealer){
                System.out.println("You win 😁");
            }else if (sum_player < sum_dealer){
                System.out.println("You lose 😭");
            }else{
                System.out.println("It is a push 🥊");
            }
        } else if (sum_player < 21){
            System.out.println("Opponent went over. You win 😁");
        } else {
            System.out.println("You went over. You lose 😭");
        }
    }

    public static void main(String[] args){

        System.out.println(logo);
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to play Blackjack? Type 'y' or 'n'");
        String play = sc.nextLine();

        while (play.equals("y")) {

            // declare
            boolean finish = false;
            String another_card = "";
            Blackjack obj = new Blackjack();
            ArrayList<Integer> alldeck = obj.Deck();
            ArrayList<Integer> player_curr = new ArrayList<Integer>();
            ArrayList<Integer> bot_curr = new ArrayList<Integer>();

            // first round
            // player
            for (int i = 0; i < 2; i++){
                int player_idx = obj.Draw(alldeck);
                obj.Deck_hold(player_curr, alldeck, player_idx);
                obj.Update_deck(alldeck, player_idx);
            }
            System.out.println("\n\nYour card: " + player_curr + ", current score: " + obj.Sum(player_curr));

            // bot
            int bot_idx = obj.Draw(alldeck);
            obj.Deck_hold(bot_curr, alldeck, bot_idx);
            obj.Update_deck(alldeck, bot_idx);
            System.out.println("Bot's card: " + bot_curr + ", current score: " + obj.Sum(bot_curr));

            if (obj.Sum(player_curr) == 21){
                finish = true;
            } else {
                System.out.println("Type 'y' to get another card, type 'n' to pass: ");
                another_card = sc.nextLine();
            }

            while (another_card.equals("y") && obj.Sum(player_curr) < 21 && finish == false){

                int player_idx = obj.Draw(alldeck);
                obj.Deck_hold(player_curr, alldeck, player_idx);
                obj.Update_deck(alldeck, player_idx);

                if (obj.Sum(player_curr) == 21){
                    finish = true;
                } else if (obj.Sum(player_curr) < 21){
                    System.out.println("Your card: " + player_curr + ", current score: " + obj.Sum(player_curr));
                    System.out.println("Type 'y' to get another card, type 'n' to pass: ");
                    another_card = sc.nextLine();
                }

            }

            System.out.println("Your final hand: " + player_curr + ", final score: " + obj.Sum(player_curr));

            while (obj.Sum(bot_curr) < 17 && finish == false){
                bot_idx = obj.Draw(alldeck);
                obj.Deck_hold(bot_curr, alldeck, bot_idx);
                obj.Update_deck(alldeck, bot_idx);
            }

            System.out.println("Bot's final hand: " + bot_curr + ", final score: " + obj.Sum(bot_curr));
            obj.Compare(obj.Sum(player_curr), obj.Sum(bot_curr));
            System.out.println(alldeck);
            System.out.println("Do you want to go over again? Type 'y' or 'n'");
            play = sc.nextLine();

        }
    }
}


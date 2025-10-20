import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Run {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String action;

        Deck deck = new Deck();
        Dealer dealer_player = new Dealer();
        ArrayList<Player> player_array = new ArrayList<Player>();


        BigSpace.create_space();
        // Player Creation
        while(true)
        {

            System.out.println("Players = " + player_array.size() + "/4");
            System.out.println("(Create a new player? y/n) or (Type start to Start)");
            action = input.nextLine();

            if(action.equals("y") && player_array.size() < 4)
            {
                BigSpace.create_space();
                System.out.print("What's your name?  (Enter * to return) ");
                action = input.nextLine();

                if (action.equals("*"))
                {
                    System.out.println("Returning..");
                }
                else
                {
                    player_array.add(new Player(action, 100));
                }
                BigSpace.create_space();
            }
            else if((action.equals("start") && player_array.size() > 0) || player_array.size() == 4)
            {
                BigSpace.create_space();
                System.out.println("Starting Game..");
                break;
            }
         
        }

        for(int t = 0; t < player_array.size(); t++)
        {

            Player current_player = player_array.get(t);

            input = new Scanner(System.in);


            dealer_player.clear_hand();
            dealer_player.hit(deck);

            dealer_player.silent_hit(deck);
            dealer_player.silent_hit(deck);

            System.out.println(current_player.getName() + "'s turn");
            System.out.println("-----------------------");

            System.out.println(current_player.getName() + ", how much would you like to bet?");
            double bet = input.nextDouble();
            input.nextLine();

            if(current_player.getMoney() - bet <= 0)
            {
                System.out.println("You ran out of money, oh no!");
                System.out.println("I gave you 10 dollars and set your bet to 5 just so you can keep playing, yay!");
                bet = 5;
            }




            current_player.playTurn(deck);

            // BigSpace.create_space();
            System.out.println("Dealers Turn ");
            System.out.println("-----------------------");
            dealer_player.dealer_turn(deck);
            System.out.println("-----------------------");
            if (current_player.getHandValue() > dealer_player.getHandValue() && current_player.has_busted(current_player.getHandValue()) == false)
            {
                System.out.println(current_player.getName() + " Won!");
            }
            else
            {
                System.out.println(dealer_player.getName() + " Won!");
            }
            return;

        }

        BigSpace.create_space();
        System.out.println("-----------------");
        System.out.println("WINNERS:");
        for(int p = 0; p < player_array.size(); p++)
        {
            Player current_player = player_array.get(p);
            if(current_player.has_busted(current_player.getHandValue()) == false)
            {
                System.out.println(current_player.getName());
            }
        }


    }
}

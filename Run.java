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

            current_player.silent_hit(deck);
            current_player.silent_hit(deck);

            System.out.println(current_player.getName() + "'s turn");
            System.out.println("-----------------------");

            System.out.println(current_player.getName() + "'s balance: " + current_player.getMoney());
            System.out.println(current_player.getName() + ", how much would you like to bet?");
            double bet = input.nextDouble();
            input.nextLine();

            // if(current_player.getMoney() > 0)
            // {

            // }

            BigSpace.create_space();
            current_player.setMoney(current_player.getMoney() - bet);
            System.out.println("Your balance is now " + current_player.getMoney() + " dollars");
            System.out.println("-----------------------");


            dealer_player.hit(deck);
            current_player.playTurn(deck);

            System.out.println("Dealers Turn ");
            System.out.println("-----------------------");
            dealer_player.dealer_turn(deck);
            if (current_player.getHandValue() > dealer_player.getHandValue() && current_player.has_busted(current_player.getHandValue()) == false)
            {
                System.out.println(current_player.getName() + " Won!");
                if(current_player.getMoney() == 21)
                {
                    current_player.setMoney(current_player.getMoney() * 2);
                }
                else
                {
                    current_player.setMoney(current_player.getMoney() + bet);
                }
                System.out.println("-----------------------");

            }
            else
            {
                System.out.println(dealer_player.getName() + " Won!");
                current_player.setMoney(current_player.getMoney() - bet);
            }

        }

        System.out.println("-----------------");
        action = input.nextLine();
        System.out.println("New Game?");

    }
}


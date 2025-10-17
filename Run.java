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
                System.out.print("What will you decree them?  (Enter * to return) ");
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
            System.out.println(current_player.getName() + "'s turn");
            System.out.println("-----------------------");
            current_player.playTurn(deck);

            BigSpace.create_space();
            System.out.println("Dealers Turn ");
            System.out.println("-----------------------");
            dealer_player.dealer_turn(deck);
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

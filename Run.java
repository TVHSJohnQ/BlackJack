import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String action;

        Deck deck = new Deck();
        ArrayList<Player> player_array = new ArrayList<Player>();


        BigSpace.create_space();
        // Player Creation
        while(true)
        {

            System.out.println("Players = " + player_array.size() + "/4");
            System.out.println("(Create a new player? y/n) or (Type start to Start)");
            action = input.nextLine();

            if(action.equals("y"))
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
            System.out.println("ABA");
        }

    }
}

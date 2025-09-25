import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String action;

        Deck deck = new Deck();
        ArrayList<Player> player_array = new ArrayList<>();

        while(true)
        {

            System.out.println("Players = " + player_array.size() + "/4");
            System.out.println("Create a new player? y/n");
            action = input.nextLine();

            if(action.equals("y"))
            {
                System.out.print("What will you decree them? ");
                action = input.nextLine();

                if (action.equals("*"))
                {
                    System.out.println("Returning..");
                }
                else
                {
                    player_array.add(new Player(action, 100));
                }
            }
        }

    }
}

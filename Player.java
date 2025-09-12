import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private int money;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name, int money)
    {
        this.name = name;
        this.money = money;
    }

    public void playTurn(Deck deck)
    {
        while(true)
        {
            Scanner input = new Scanner(System.in);
            String action;
            System.out.println("Hit or Stand?");
            action = input.nextLine();
            if(action == "h")
            {
                hit(deck);
            }
            else if(action == "s")
            {
                return;
            }
            else
            {
                System.out.println("Press h to hit and press s to stand!");
            }

        }
    }

    public void hit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.hand.add(newCard);
    }

    public int getHandValue()
    {
        //do stuff
        return 1;
    }

    public void getCard(Deck deck)
    {
        //do stuff
    }

    public String getName()
    {
        return name;
    }
    
    public int getMoney()
    {
        return money;
    }
}
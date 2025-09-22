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
            if(action.equals("h"))
            {
                hit(deck);
                System.out.println(getHandValue());
            }
            else if(action.equals("s"))
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
        int hand_value = 0;
        for(int c = 0; c < hand.size(); c++)
        {
            Card current_card = hand.get(c);
            if(current_card.get_face().equals("A"))
            {
                //!!!!!!!!!!!!!!!!!!!!!!!
            }
            else
            {
                hand_value += current_card.get_value();
            }
        }
        return hand_value;
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
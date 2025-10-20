import java.util.ArrayList;
import java.util.Scanner;


public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name, int money)
    {
        this.name = name;
        this.money = money;
    }

    //-----------------------PLAY TURN--------------------------

    public void playTurn(Deck deck)
    {
        while(true)
        {
            Scanner hit_input = new Scanner(System.in);
            String action;

            System.out.println(name + "'s Hand: " + getHandValue());
            System.out.println("Hit or Stand?");
            action = hit_input.nextLine();
            if(action.equals("h") || action.equals("hit"))
            {
                BigSpace.create_space();
                hit(deck);
                // check if busted
                if(has_busted(getHandValue()))
                {
                    BigSpace.create_space();
                    System.out.println(name + " busted");
                    System.out.println("-------------------");
                    break;
                }
            }
            else if(action.equals("s") || action.equals("stand"))
            {
                BigSpace.create_space();
                System.out.println(name + " stood with a hand of " + getHandValue());
                System.out.println("-------------------");
                break;
            }
            else
            {
                BigSpace.create_space();
                System.out.println("Press h to hit and press s to stand!");
            }

        }
    }

    //-----------------------PLAY TURN END--------------------------

    public void hit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.hand.add(newCard);
        System.out.println(this.name + " pulled a "  + get_top_card());
    }

    public void silent_hit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.hand.add(newCard);
    }

    //-----------------------GET HAND VALUE--------------------------

    public int getHandValue()
    {
        int hand_value = 0;
        int ace_count = 0;

        for(int c = 0; c < hand.size(); c++)
        {
            Card current_card = hand.get(c);
            if(current_card.get_face().equals("A"))
            {
                hand_value += 11;
                ace_count += 1;
            }
            else
            {
                hand_value += current_card.get_value();
            }
        }
        while(hand_value > 21 && ace_count > 0)
        {
            hand_value -= 10;
            ace_count -= 1;
        }
        return hand_value;
    }

    //-----------------------GET HAND VALUE END--------------------------

    public boolean has_busted(int hand_value)
    {
        if(hand_value > 21)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String get_top_card()
    {
        Card top_card = this.hand.get(this.hand.size() - 1);
        // return top_card.get_value() + " of " + top_card.get_face();
        return top_card.toString();
    }

    public void clear_hand()
    {
        hand.clear();
    }

    public String getName()
    {
        return name;
    }
    
    public double getMoney()
    {
        return money;
    }

    public void setMoney(double set_money)
    {
        money = set_money;
    }
}
public class Dealer extends Player
{
    public Dealer()
    {
        super("Dealer Danny",1000000);


    }

    public void dealer_turn(Deck deck)
        {
            while(getHandValue() < 17)
            {
                this.hit(deck);
                System.out.println(getHandValue());

            }
        }

}
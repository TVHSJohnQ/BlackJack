import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player("Griffin",100);

        player.hit(deck);
        player.hit(deck);
        player.hit(deck);
        player.hit(deck);
        player.hit(deck);
        player.hit(deck);
        player.hit(deck);
        player.hit(deck);
        player.hit(deck);
        player.hit(deck);
        System.out.println(player.getHandValue());
        player.playTurn(deck);

        // for(Card card : deck.getCards())
        // {
            
        // }
    }
}

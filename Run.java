import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player("Griffin",100);
        ArrayList<Player> player_array = new ArrayList<>();
        
        

        


        player.playTurn(deck);
        
    }
}

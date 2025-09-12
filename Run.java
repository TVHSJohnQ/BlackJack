public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Player player = new Player("Griffin",100);

        player.playTurn(deck);

        // for(Card card : deck.getCards())
        // {
            
        // }
    }
}

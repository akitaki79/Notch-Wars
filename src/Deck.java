import java.util.*;

public class Deck {
    private HashSet<Card> myCards = new HashSet<>();
    private static final char[] suits = { 'S', 'H', 'C', 'D' };
    private static final char[] ranks = { 'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2' };
    private Iterator<Card> cardGetter; 

    public Deck() {
        init(); 
    }

    private void init() {
        for (char suit : suits) {
            for (char rank : ranks) {
                myCards.add(new Card(rank, suit));
            }
        }
        shuffle(); 
    }

    public void shuffle() {
        ArrayList<Card> cardList = new ArrayList<>(myCards);
        Collections.shuffle(cardList);
        cardGetter = cardList.iterator();
    }

    public Card getCard() {
        return cardGetter.hasNext() ? cardGetter.next() : null;
    }

    public boolean isEmpty() {
        return !cardGetter.hasNext();
    }
}

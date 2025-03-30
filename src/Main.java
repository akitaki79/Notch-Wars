import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        PlayerQueue<Card> player1 = new PlayerQueue<>();
        PlayerQueue<Card> player2 = new PlayerQueue<>();
        Deck deck = new Deck(); 
        deck.shuffle();

        deal(player1, player2, deck); 

        while (!player1.isEmpty() && !player2.isEmpty()) {
            playRound(player1, player2); 
            System.out.println("Player 0 has " + player1.size() + ", Player 1 has " + player2.size());
        }

        String winner = player1.isEmpty() ? "Player 1" : "Player 0";
        System.out.println("The winner is... " + winner + "!");
    }

    private static void deal(PlayerQueue<Card> player1, PlayerQueue<Card> player2, Deck deck) {
        // Deals 26 cards to each player.
        for (int i = 0; i < 26; i++) {
            player1.put(deck.getCard());
            player2.put(deck.getCard());
        }
    }

    private static void playRound(PlayerQueue<Card> player1, PlayerQueue<Card> player2) {
        Card card1 = player1.get();
        Card card2 = player2.get();

        boolean notch = Math.abs(card1.getRank() - card2.getRank()) == 1;
        String result = notch ? " (Notched!)" : "";

        System.out.println(card1 + " versus " + card2 + result);

        if (card1.compareTo(card2) == 0) {
            System.out.println("WAR!");
            war(player1, player2, card1, card2);
        } else {
            if ((notch && card1.getRank() < card2.getRank()) || (!notch && card1.getRank() > card2.getRank())) {
                player1.put(card1);
                player1.put(card2);
            } else {
                player2.put(card2);
                player2.put(card1);
            }
        }
    }

    private static void war(PlayerQueue<Card> player1, PlayerQueue<Card> player2, Card tieCard1, Card tieCard2) {
     
        ArrayList<Card> warCards1 = new ArrayList<>();
        ArrayList<Card> warCards2 = new ArrayList<>();

        warCards1.add(tieCard1);
        warCards2.add(tieCard2);

        for (int i = 0; i < 3; i++) { 
            if (!player1.isEmpty()) warCards1.add(player1.get());
            if (!player2.isEmpty()) warCards2.add(player2.get());
        }

        Card faceUp1 = player1.isEmpty() ? null : player1.get();
        Card faceUp2 = player2.isEmpty() ? null : player2.get();

        if (faceUp1 != null) warCards1.add(faceUp1);
        if (faceUp2 != null) warCards2.add(faceUp2);

        if (faceUp1 == null || faceUp2 == null) {
            if (faceUp1 == null && faceUp2 != null) {
                transferCards(player2, warCards1);
                transferCards(player2, warCards2);
                System.out.println("Player 1 wins the war by default!");
            } else if (faceUp2 == null && faceUp1 != null) {
                transferCards(player1, warCards1);
                transferCards(player1, warCards2);
                System.out.println("Player 0 wins the war by default!");
            }
            return;
        }

        System.out.println(faceUp1 + " versus " + faceUp2 + " in WAR!");
        if (faceUp1.compareTo(faceUp2) == 0) {
            war(player1, player2, faceUp1, faceUp2);
        } else {
            boolean notch = Math.abs(faceUp1.getRank() - faceUp2.getRank()) == 1;
            if ((notch && faceUp1.getRank() < faceUp2.getRank()) || (!notch && faceUp1.getRank() > faceUp2.getRank())) {
                transferCards(player1, warCards1);
                transferCards(player1, warCards2);
                System.out.println("Player 0 wins the war round");
            } else {
                transferCards(player2, warCards1);
                transferCards(player2, warCards2);
                System.out.println("Player 1 wins the war round");
            }
        }
    }

    private static void transferCards(PlayerQueue<Card> winner, ArrayList<Card> cards) {
        for (Card card : cards) {
            winner.put(card);
        }
    }
}


public class Card implements Comparable<Card> {
    private String mySymbol; 
    private int myRank;     
    private char mySuit;   

    public Card(char rank, char suit) {
        
        switch (rank) {
            case 'A': myRank = 14; break;
            case 'K': myRank = 13; break;
            case 'Q': myRank = 12; break;
            case 'J': myRank = 11; break;
            case 'T': myRank = 10; break;
            default: myRank = rank - '0'; 
        }
        mySuit = suit;
        mySymbol = "" + rank + suit;
    }

 
    public int getRank() { return myRank; }
    public char getSuit() { return mySuit; }
    public String getSymbol() { return mySymbol; }

    // Implements Comparable for sorting and comparing cards based on rank.
    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.myRank, other.myRank);
    }

  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return myRank == card.myRank && mySuit == card.mySuit;
    }

    // Returns the card's display symbol.
    @Override
    public String toString() {
        return mySymbol;
    }
}

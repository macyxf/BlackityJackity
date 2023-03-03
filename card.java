
public class card {
    public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5",
                            "6", "7", "8", "9", "10",
                            "Jack", "Queen", "King"};
    public static final int[] Value = {0,  10, 2, 3, 4, 5,
                            6, 7, 8, 9, 10,
                            10, 10, 10};
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    private final int rank;
    private final int suit;

    public card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return Value[this.rank];
    }

    public String toString() {
        String s =  RANKS[this.rank] + " of " + SUITS[this.suit];
        return s;
    }
}

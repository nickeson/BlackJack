package com.nickeson.games.cardgames;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Card.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A class to define a Playing Card<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/
public class CardVO 
{
    private String suit = null;
    private String rank = null;
    private int value = 0;
    
    /**
     * constructor requires Card suit, rank, value to be passed (at minimum)
     * @param suit
     * @param rank
     * @param value
     */
    public CardVO(String suit, String rank, int value)
    {
        this.suit = suit; 
        this.rank = rank;
        this.value = value;
    }

	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}
	
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return boolean suit comparison
	 */
	public boolean isSuit(String suit) {
		if (this.suit == null || this.suit.length() == 0) return false;
		return this.suit.equalsIgnoreCase(suit);
	}
	
	/**
	 * @return boolean rank comparison
	 */
	public boolean isRank(String rank) {
		if (this.rank == null || this.rank.length() == 0) return false;
		return this.rank.equalsIgnoreCase(rank);
	}
	
	/**
	 * @return boolean value comparison
	 */
	public boolean isValue(int value) {
		if (this.value == 0) return false;
		return true;
	}
	
	/**
     * print card suits and values, rather than hashcode
     */
    @Override
    public String toString() {
    	String currCard = rank + " of " + suit;
        return currCard;
    }

    // unit test
    public static void main(String[] args) {
    	CardVO card = new CardVO("Spades", "Ace", 11);
    	System.out.println(card);
    }
}
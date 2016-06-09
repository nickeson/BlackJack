package com.nickeson.game.cardgame;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Card.java <p/>
 * <b>Project</b>: Card Games <p/>
 * <b>Description: </b> A class to define a Playing Card<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Card {

    private String suit = null;
    private String rank = null;
    private int value = 0;
    boolean faceUp = false;
    
    /**
     * constructor requires Card suit, rank, value to be passed (at minimum)
     * @param suit the Card's suit
     * @param rank the Card's rank
     * @param value the Card's value
     */
    public Card(String suit, String rank, int value) {
        this.suit = suit; 
        this.rank = rank;
        this.value = value;
    }
    
    /**
     * constructor allows Card suit, rank, value and faceUp to be passed
     * @param suit the Card's suit
     * @param rank the Card's rank
     * @param value the Card's value
     * @param faceUp the Card's faceUp value (true = Face Up, false = Face Down)
     */
    public Card(String suit, String rank, int value, boolean faceUp) {
    	this.suit = suit;
    	this.rank = rank;
    	this.value = value;
    	this.faceUp = faceUp;
    }

	/**
	 * @return Card - the Card's suit
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * @param suit the Card suit to set
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * @return Card - the Card's rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @param rank the Card rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	/**
	 * @return Card - the Card's value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the Card value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * faceUp value: true = Face Up, false = Face Down
	 * @return the faceUp value
	 */
	public boolean isFaceUp() {
		return faceUp;
	}

	/**
	 * faceUp value: true = Face Up, false = Face Down
	 * @param faceUp the faceUp value to set
	 */
	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

	/**
	 * @return boolean - a Card suit comparison
	 */
	public boolean isSuit(String suit) {
		if (this.suit == null || this.suit.length() == 0) return false;
		return this.suit.equalsIgnoreCase(suit);
	}
	
	/**
	 * @return boolean - a Card rank comparison
	 */
	public boolean isRank(String rank) {
		if (this.rank == null || this.rank.length() == 0) return false;
		return this.rank.equalsIgnoreCase(rank);
	}
	
	/**
	 * @return boolean - a Card value comparison
	 */
	public boolean isValue(int value) {
		if (this.value == 0) {
			return false;
		} else {
			if (this.value == value) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	/**
     * print Card suit and rank, rather than hashcode
     */
    @Override
    public String toString() {
    	String currCard = null;
    	
    	if (suit != null && suit != "") {
			currCard = rank + " of " + suit;
    	} else {
    		// don't print suit if it doesn't exist (i.e., Jokers)
    		currCard = rank;
    	}
        return currCard;
    }
}
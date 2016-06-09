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
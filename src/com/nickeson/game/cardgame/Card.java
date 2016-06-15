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
    private int indexValue = 0;
    
    /**
     * constructor requires Card suit, rank, indexValue to be passed (at minimum)
     * @param suit the Card's suit
     * @param rank the Card's rank
     * @param indexValue the Card's indexValue
     */
    public Card(String suit, String rank, int indexValue) {
        this.suit = suit; 
        this.rank = rank;
        this.indexValue = indexValue;
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
	 * @return Card - the Card's indexValue
	 */
	public int getIndexValue() {
		return indexValue;
	}

	/**
	 * @param indexValue the Card indexValue to set
	 */
	public void setIndexValue(int indexValue) {
		this.indexValue = indexValue;
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
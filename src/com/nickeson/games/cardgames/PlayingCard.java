package com.nickeson.games.cardgames;

//JDK 1.8.0
/*
 * Next up is to subclass card to StandardCard and CrazyCard so we can build
 * a shoe from either card type, using generics.
 */

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
public class PlayingCard 
{
    private String suit, value;
    private boolean isFaceUp, isJoker;
    
    /**
     * constructor requires Card suit, value to be passed (at minimum)
     * @param suit
     * @param value
     * @param isFaceUp
     */
    public PlayingCard(String suit, String value, boolean isJoker, boolean isFaceUp)
    {
        this.suit = suit; 
        this.value = value;
        this.isJoker = isJoker;
        this.isFaceUp = isFaceUp;
    }

	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return isFaceUp returns true/false based on Card's isFaceUp value
	 */
	public boolean isFaceUp() {
		return isFaceUp;
	}

	/**
	 * @param isFaceUp - sets whether or not the card is face up
	 */
	public void setFaceUp(boolean isFaceUp) {
		this.isFaceUp = isFaceUp;
	}
	
	/**
	 * @return the isJoker
	 */
	public boolean isJoker() {
		return isJoker;
	}

	/**
	 * @param isJoker set the boolean isJoker
	 */
	public void setJoker(boolean isJoker) {
		this.isJoker = isJoker;
	}
	
	/**
     * print card suits and values, rather than hashcode
     */
    @Override
    public String toString() {
    	String currCard;
    	String faceDirection;
    	
    	if (isFaceUp) {
    		faceDirection = "(FU)";
    	} else {
    		faceDirection = "(FD)";
    	}
    	
    	if (isJoker()) {
    		currCard = "" + value + faceDirection;
		} else {
	       currCard = value + " of " + suit + faceDirection;
    	}
        return currCard;
    }
}
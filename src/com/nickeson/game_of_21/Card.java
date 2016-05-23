package com.nickeson.game_of_21;

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
public class Card 
{
    private String suit, value, jokerName;
    
    
    /**
     * 
     * constructor requires Card suit, value to be passed (at minimum)
     * @param suit
     * @param value
     */
    public Card(String suit, String value)
    {
        this.suit = suit; 
        this.value = value;
    }
    
    /**
     * 
     * @param suit
     * @param value
     * @param jokerName
     */
    public Card(String suit, String value, String jokerName)
    {
        this.suit = suit; 
        this.value = value;
        this.jokerName = jokerName;
    }
    
    /**
     * print card suits and values, rather than hashcode
     */
    @Override
    public String toString()
    {  
    	if (!value.equals(jokerName)) {
	    	String currCard = value + " of " + suit;
	    	return currCard;
    	} else {
    		// don't print suit for Jokers
    		return jokerName;
		}
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
	public String getVal() {
		return value;
	}

	/**
	 * @return the custom jokerName
	 */
	public String getJokerName() {
		return jokerName;
	}
}
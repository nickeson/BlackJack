package com.nickeson.game_of_21;

//JDK 1.8.0
//import java.util.Arrays;

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
    private String suit, val, jokerName;
    
    // constructor requires Card suit, val to be passed (at minimum)
    public Card(String suit, String val)
    {
        this.suit = suit; 
        this.val = val;
    }
    
    // overloaded constructor also allows jokerName to be passed
    public Card(String suit, String val, String jokerName)
    {
        this.suit = suit; 
        this.val = val;
        this.jokerName = jokerName;
    }
    
    // override toString method for Card to print values as Strings
    @Override
    public String toString()
    {  
    	if (!val.equals(jokerName)) {
	    	String currCard = val + " of " + suit;
	    	return currCard;
    	} else {
    		// don't print suit for Jokers
    		return jokerName;
		}
	}
    
    // unit test main method
//    public static void main (String[] args) {
//    	System.out.println(Arrays.toString(StandardDeck.getSuits()));
//    	System.out.println(Arrays.toString(StandardDeck.getCardVals()));
//	}
}
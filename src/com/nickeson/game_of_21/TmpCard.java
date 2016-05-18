package com.nickeson.game_of_21;

import java.util.Arrays;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: TmpCard.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A class to define a Playing TmpCard<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/
public class TmpCard 
{
    private String suit, val;
    private static String[] cardSuits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    private static String[] cardValues = {"Ace", "King", "Queen", "Jack", "10",
                                   "9", "8", "7", "6", "5", "4", "3", "2", "Joker"};

    // constructor requires TmpCard suit & val to be passed
    public TmpCard(String suit, String val)
    {
        this.suit = suit; 
        this.val = val;
    }
    
    // override toString method for TmpCard to print values as Strings
    public String toString()
    {  
    	if (!val.equals("Joker")) {
	    	String currCard = val + " of " + suit;
	    	return currCard;
    	} else {
    		// don't print suit for Jokers
    		return "Joker";
		}
	}
    
    public static String[] getSuits() {
    	return cardSuits;
	}
    
    public static String[] getCardVals() {
    	return cardValues;
    }
    
    // unit test main method
    public static void main (String[] args) {
    	System.out.println(Arrays.toString(TmpCard.getSuits()));
    	System.out.println(Arrays.toString(TmpCard.getCardVals()));
	}
}
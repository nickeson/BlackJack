package com.nickeson.game_of_21;

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
public class Card 
{
    private int suit, val;
    private String[] cardSuit = {"Hearts", "Diamonds", "Spades", "Clubs", "NoSuit"};
    private String[] cardValue = {"Ace", "King", "Queen", "Jack", "10",
                                   "9", "8", "7", "6", "5", "4", "3", "2", "Joker"};

    public Card(int suit, int val)
    {
        this.suit = suit; 
        this.val = val;
    }
    
    // override toString method for Card to print values as Strings
    public String toString()
    {  
    	if (cardValue[val] != "Joker") {
			String currCard = cardValue[val] + " of " + cardSuit[suit];
	        return currCard;
    	} else {
    		// Jokers don't need suit printed
    		return "Joker";
    	}
    }
    
//    public static void main (String[] args) {
//   	}
}
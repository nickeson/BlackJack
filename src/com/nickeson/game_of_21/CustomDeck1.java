package com.nickeson.game_of_21;

//JDK 1.8.0
import java.util.ArrayList;

/****************************************************************************
 * <b>Title</b>: CustomDeck1.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A custom deck<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class CustomDeck1 implements Deck {
	boolean hasJokers;
	private ArrayList<Card> custDeck1;
	private static String[] cardSuits = {"Hearts", "Diamonds", "Spades", "Clubs"};
    private static String[] cardValues = {"Ace", "King", "Queen", "Jack", "10",
                                   "9", "8", "7", "6", "5", "4", "3", "2", "Joker"};
	
	public CustomDeck1(boolean hasJokers) {
		custDeck1 = new ArrayList<Card>();
	
		/* loop through the suits and values arrays in Card, building new cards
		 * for each value of each suit (no jokers)
		 */
		for (String ol : getSuits())
		{
			for (String il : getCardVals())
			{
				if (!il.equals("Joker")) {
					custDeck1.add(new Card(ol,il));
				}
			}
		}
		
		if (hasJokers == true) {
			// add 2 Jokers (NoSuit)
			custDeck1.add(new Card("Hearts","Joker"));
			custDeck1.add(new Card("Hearts","Joker"));	
		}
	}
	
	public static String[] getSuits() {
    	return cardSuits;
	}
    
    public static String[] getCardVals() {
    	return cardValues;
    }
	
 	// override toString to return Deck as String instead of hashcode
 	public String toString()
 	{
	 	String result = "" + custDeck1;
	 	return result;
 	}
 	 
	// unit test method for CustomDeck1 class
	public static void main(String[] args) {
		CustomDeck1 myDeck = new CustomDeck1(true);
		CustomDeck1 my2ndDeck = new CustomDeck1(false);	
		System.out.println("Deck with Jokers: " + myDeck);
		System.out.println("Deck without Jokers: " + my2ndDeck);	
	 }
}
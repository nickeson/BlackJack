package com.nickeson.game_of_21;

//JDK 1.8.0
import java.util.ArrayList;

/****************************************************************************
 * <b>Title</b>: StandardDeck.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A standard 52 card deck + 2 jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class StandardDeck implements Deck {
	boolean hasJokers;
	private ArrayList<Card> stdDeck;
	
	public StandardDeck(boolean hasJokers) {
		// build a deck with 52 cards (no jokers)
		stdDeck = new ArrayList<Card>();
	
		/* loop through the suits and values arrays in Card, building new cards
		 * for each value of each suit 
		 */
		for(int a = 0; a <= 3; a++)
		{
			// make sure to include Jokers (b <= 13)
			for (int b = 0; b <= 12; b++)
			{
				// add cards using all values from Ace through 2
				stdDeck.add(new Card(a,b));
			}
		}
		
		if (hasJokers == true) {
			// add 2 Jokers (NoSuit)
			stdDeck.add(new Card(4,13));
			stdDeck.add(new Card(4,13));	
		}
	}
	
	// override toString to return Deck's ArrayList values as String instead of heap address
	public String toString()
	{
		String result = "" + stdDeck;
		return result;
	}
	
	// unit test method for StandardDeck class
	public static void main(String[] args) {
		// create a new standard deck with Jokers named 'myDeck'
		StandardDeck myDeck = new StandardDeck(true);
		StandardDeck my2ndDeck = new StandardDeck(false);	
		
		// print out deck contents
		System.out.println("Deck with Jokers: " + myDeck);
		System.out.println("Deck without Jokers: " + my2ndDeck);	
	}
}
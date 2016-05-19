package com.nickeson.game_of_21;

//JDK 1.8.0
import java.util.ArrayList;
import java.util.Collections;

/****************************************************************************
 * <b>Title</b>: StandardDeck.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A standard card deck with and without Jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class StandardDeck implements Deck {
	// Build String Arrays sized by number of Enums defined
	private String[] cardSuits = new String[StandardCardSuits.values().length];	
	private String[] cardValues = new String[StandardCardValues.values().length];		
	
	// use 'Object', not 'Card' --> polymorphism for other Object types in deck
	private ArrayList<Object> stdDeck = new ArrayList<Object>();
	
	// setup joker location
	private int jokerIndex = (StandardCardValues.values().length -1);
	
    // constructor to build a deck with or without jokers if arg is passed
	public StandardDeck(boolean hasJokers) {
		buildDeck();
		
		// add jokers
		if (hasJokers == true) {
			String jokerName = cardValues[jokerIndex];
			
			/* pass jokerName as card value, and as key for toString() override
			 * so Jokers don't print with suit listed (they don't have one)
			*/
			stdDeck.add(new Card("", jokerName, jokerName));
			stdDeck.add(new Card("", jokerName, jokerName));	
		}
	}
	
	// constructor to build a deck with no jokers if no arg is passed
	public StandardDeck(){
		buildDeck();
	}
	
	public void buildDeck() {
		// fill String Arrays with Enum values from StdCardSuits.values()
		for (StandardCardSuits itr : StandardCardSuits.values()) {
			int ord = itr.ordinal();
			cardSuits[ord] = "" + itr;			
		}
				
		for (StandardCardValues ir : StandardCardValues.values()) {
			int odl = ir.ordinal();
			cardValues[odl] = "" + ir;				
		}	
		
		/* loop through the suits and values string arrays, building new cards
		 * for each value of each suit (no jokers)
		 */
		for (String ol : cardSuits)
		{
			for (String il : cardValues)
			{
				if (!il.equals(cardValues[jokerIndex])) {
					stdDeck.add(new Card(ol,il));
				}
			}
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(stdDeck);
	}
	
 	// override toString to return Deck as String instead of hashcode
    @Override
 	public String toString()
 	{
	 	String result = "" + stdDeck;
	 	return result;
 	}
 	 
	// unit test method
	public static void main(String[] args) {
		StandardDeck myDeck = new StandardDeck(true);
		System.out.println("Deck with Jokers: " + myDeck);
		
		StandardDeck my2ndDeck = new StandardDeck(false);	
		my2ndDeck.shuffleDeck();
		System.out.println("Shuffled Deck without Jokers: " + my2ndDeck);	
	 }
}
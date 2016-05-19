package com.nickeson.game_of_21;

//JDK 1.8.0
import java.util.ArrayList;
import java.util.Collections;

/****************************************************************************
 * <b>Title</b>: CustomDeck1.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A custom card deck with and without Jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class CustomDeck1 implements Deck {
	// Build String Arrays sized by number of Enums defined
	private String[] cardSuits = new String[CustomCardSuits1.values().length];	
	private String[] cardValues = new String[CustomCardValues1.values().length];		
	
	// use 'Object', not 'Card' --> polymorphism for other Object types in deck
	private ArrayList<Object> custDeck1 = new ArrayList<Object>();
	
	// setup joker location
	private int jokerIndex = (CustomCardValues1.values().length -1);
	
    // constructor to build a deck with or without jokers if arg is passed
	public CustomDeck1(boolean hasJokers) {
		buildDeck();
		
		// add jokers
		if (hasJokers == true) {
			String jokerName = cardValues[jokerIndex];
			
			/* pass jokerName as card value, and as key for toString() override
			 * so Jokers don't print with suit listed (they don't have one)
			*/
			custDeck1.add(new Card("", jokerName, jokerName));
			custDeck1.add(new Card("", jokerName, jokerName));	
		}
	}
	
	// constructor to build a deck with no jokers if no arg is passed
	public CustomDeck1(){
		buildDeck();
	}
	
	public void buildDeck() {
		// fill String Arrays with Enum values from CustomCardSuits.values()
		for (CustomCardSuits1 itr : CustomCardSuits1.values()) {
			int ord = itr.ordinal();
			cardSuits[ord] = "" + itr;			
		}
				
		for (CustomCardValues1 ir : CustomCardValues1.values()) {
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
					custDeck1.add(new Card(ol,il));
				}
			}
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(custDeck1);
	}
	
 	// override toString to return Deck as String instead of hashcode
    @Override
 	public String toString()
 	{
	 	String result = "" + custDeck1;
	 	return result;
 	}
 	 
	// unit test method
	public static void main(String[] args) {
		CustomDeck1 myDeck = new CustomDeck1(true);
		System.out.println("Deck with Jokers: " + myDeck);
		
		CustomDeck1 my2ndDeck = new CustomDeck1(false);	
		my2ndDeck.shuffleDeck();
		System.out.println("Shuffled Deck without Jokers: " + my2ndDeck);	
	 }
}
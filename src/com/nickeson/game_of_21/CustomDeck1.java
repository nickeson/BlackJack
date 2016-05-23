package com.nickeson.game_of_21;
/*
 * Next up is to set this up to build a deck from standard cards (subtype of card)
 */

//JDK 1.8.0
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: CustomDeck1.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A standard card deck with and without Jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class CustomDeck1 implements Deck<Card> {
	private List<Card> custDeck1 = new ArrayList<Card>();
	// initialize empty string arrays for card suits & values to correct sizes
	private String[] cardSuits = new String[CustomCardSuits1.values().length];	 
	private static String[] cardValues = new String[CustomCardValues1.values().length];
	// setup location index for Joker
	private static int jokerIndex = (CustomCardValues1.values().length -1);
	
	/**
	 * constructor to build a deck with no jokers if no arg is passed 
	 */
	public CustomDeck1(){
		buildDeck();
	}
	
	/**
	 * constructor to build a deck with or without jokers if arg is passed     
	 * @param hasJokers
	 */
	public CustomDeck1(boolean hasJokers) {
		buildDeck();
		if (hasJokers == true) {
			addJoker();
			addJoker();	
		}
	}
	
	/**
	 * build a Standard Deck of cards with suits and values defined in
	 * CustomCardSuits1.java and CustomCardValues1.java
	 */
	public void buildDeck() {
		// fill String Arrays with Enum values from StdCardSuits.values()
		for (CustomCardSuits1 itr : CustomCardSuits1.values()) {
			int ord = itr.ordinal();
			cardSuits[ord] = "" + itr;			
		}
				
		for (CustomCardValues1 ir : CustomCardValues1.values()) {
			int odl = ir.ordinal();
			cardValues[odl] = "" + ir;				
		}	
		
		/* loop through the suits and values string arrays, building new cards
		 * for each value of each suit
		 */
		for (String ol : cardSuits)
		{
			for (String il : cardValues)
			{
				if (!il.equals(cardValues[jokerIndex])) {
					custDeck1.add(new Card(ol,il,false));
				}
			}
		}
	}
	
	/**
	 * @return the custom Joker name for this deckType
	 */
	public static String getJokerName() {
		String jokerName = cardValues[jokerIndex];
		return jokerName;
	}
	
	/**
	 * add a face down Joker to deck with custom Joker name for this deck (no suit)
	 */
	public void addJoker() {
		String jokerName = getJokerName();
		custDeck1.add(new Card("", jokerName, false));
	}
	
	/**
	 * a method to shuffle this deckType
	 */
	public void shuffleDeck() {
		Collections.shuffle(custDeck1);
	}
	
	/**
	 * prints deck suits and values rather than deck's hashcode
	 */
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

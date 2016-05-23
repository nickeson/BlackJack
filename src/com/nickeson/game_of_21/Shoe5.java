package com.nickeson.game_of_21;
/*
 * Next up is to set this up to build a deck from standard cards (subtype of card)
 */

//JDK 1.8.0
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: Shoe5.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A standard card deck with and without Jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Shoe5 implements Deck<Card> {
	private List<Card> shoe = new ArrayList<Card>();
	// initialize empty string arrays for card suits & values to correct sizes
	private String[] cardSuits = new String[StandardCardSuits.values().length];	 
	private static String[] cardValues = new String[StandardCardValues.values().length];
	// setup location index for Joker
	private static int jokerIndex = (StandardCardValues.values().length -1);
	
	/**
	 * constructor to build a deck with no jokers if no arg is passed 
	 */
	public Shoe5(){
		buildDeck();
	}
	
	/**
	 * constructor to build a deck with or without jokers if arg is passed     
	 * @param hasJokers
	 */
	public Shoe5(boolean hasJokers) {
		buildDeck();
		if (hasJokers == true) {
			addJoker();
			addJoker();	
		}
	}
	
	/**
	 * build a Standard Deck of cards with suits and values defined in
	 * StandardCardSuits.java and StandardCardValues.java
	 */
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
		 * for each value of each suit
		 */
		for (String ol : cardSuits)
		{
			for (String il : cardValues)
			{
				if (!il.equals(cardValues[jokerIndex])) {
					shoe.add(new Card(ol,il,false));
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
		shoe.add(new Card("", jokerName, false));
	}
	
	/**
	 * a method to shuffle this deckType
	 */
	public void shuffleDeck() {
		Collections.shuffle(shoe);
	}
	
	/**
	 * prints deck suits and values rather than deck's hashcode
	 */
    @Override
 	public String toString()
 	{
	 	String result = "" + shoe;
	 	return result;
 	}
 	 
	// unit test method
	public static void main(String[] args) {
		Shoe5 myDeck = new Shoe5(true);
		System.out.println("Deck with Jokers: " + myDeck);
		
		Shoe5 my2ndDeck = new Shoe5(false);	
		my2ndDeck.shuffleDeck();
		System.out.println("Shuffled Deck without Jokers: " + my2ndDeck);	
	 }
}

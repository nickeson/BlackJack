package com.nickeson.game_of_21;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Shoe.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A shoe of playing cards, accepts params for number and
 * types of decks in Shoe<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 19, 2016<p/>
 * updates:
 ****************************************************************************/

public class Shoe {
	private int numOfDecks;
	private String deckType;
	private Deck myDeck;
	
	// default constructor builds a single deck shoe when called with no args
	public Shoe() {
		buildShoe();
	}
	
	// overloaded constructor to build a shoe with a specific number of decks
	public Shoe(int numOfDecks) {
		this.numOfDecks = numOfDecks;
		buildShoe(numOfDecks);
	}

	// default shoe size is 1 deck
	public Deck buildShoe() {
		myDeck = new StandardDeck();
//		System.out.println(myDeck);
		return myDeck;
	}
	
	// Overloaded method to allow number of decks to be passed as param
	public Deck buildShoe(int numDecks) {	
	
		// minimum number of decks in shoe is 1 (add first deck)
		myDeck = new StandardDeck();

		// add additional decks to match numOfDecks
		if (numDecks >= 2) {
			for (int i = 0; i <= (numDecks - 2); i++) {
				myDeck.buildDeck();
			}
		}
//		System.out.println(myDeck);
		return myDeck;
	}
	
	/**
	 * @return the numOfDecks
	 */
	public int getNumOfDecks() {
		return numOfDecks;
	}

	/**
	 * @param numOfDecks the numOfDecks to set
	 */
	public void setNumOfDecks(int numOfDecks) {
		this.numOfDecks = numOfDecks;
	}

	/**
	 * @return the deckType
	 */
	public String getDeckType() {
		return deckType;
	}

	/**
	 * @param deckType the deckType to set
	 */
	public void setDeckType(String deckType) {
		this.deckType = deckType;
	}
	
	// Override toString() to print Shoe contents instead of hashcode for Shoe
	@Override
	public String toString() {
		return "" + myDeck;
	}
	
	public static void main(String[] args) {
		Shoe myShoe = new Shoe(2);
		System.out.println(myShoe);
	}
}
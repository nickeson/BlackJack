package com.nickeson.game_of_21;

//import java.util.Collections;

/* NEXT STEP IS TO MAKE THIS ABLE TO PASS A PARAM TO INDICATE WHETHER TO INCLUDE
 * JOKERS IN SHOE OR NOT
 * ALSO INCLUDE SHUFFLE METHOD AND WAY TO SET/CHECK SHUFFLE MARKER
 */

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Shoe2.java <p/>
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

public class Shoe2 {
	private int numOfDecks;
	private int deckType;
	private Deck myDeck;
	private boolean hasJokers;
	
	// a shoe can contain no more than 8 decks
	public static final int MAX_DECKS = 8;
	
	// default no-arg constructor builds a 6 deck shoe of StandardDeck type
	public Shoe2() {
		buildShoe(1, 6);
	}
	
	// overloaded constructor to build a 6 deck shoe of specified deck type
	public Shoe2(int deckType) {
		buildShoe(deckType, 6);
	}
	
	// overloaded constructor to build shoe with set number of decks and deckType
	public Shoe2(int deckType, int numOfDecks) {
		this.numOfDecks = numOfDecks;
		this.deckType = deckType;
		buildShoe(deckType, numOfDecks);
	}

	// overloaded constructor to build shoe with Jokers and specific number of decks and deckType
	public Shoe2(int deckType, int numOfDecks, boolean hasJokers) {
		this.numOfDecks = numOfDecks;
		this.deckType = deckType;
		this.hasJokers = hasJokers;
		if (hasJokers == true) {
			buildShoe(deckType, numOfDecks, true);
		} else {
			buildShoe(deckType, numOfDecks);	
		}
	}
	
	// method to build a single deck shoe of cards of specific deckType
	// *** change to switch statement to allow 5 deck types ***
	public Deck buildShoe(int deckType) {
		if ((deckType >=1) && (deckType <= 5)) {
			if (deckType == 1) {
				myDeck = new StandardDeck();
			} else {
				myDeck = new CustomDeck1();
			}
		} else {
			System.out.println("Only a deckType between 1 and 5 is allowed");
		}
		return myDeck;
	}
	
	// overloaded method allows number and type of decks to be passed as params
	// *** change to switch statement to allow 5 deck types ***
	public Deck buildShoe(int deckType, int numOfDecks) {	
		if (numOfDecks >= MAX_DECKS) {
			System.out.println("A maximum of 8 Decks is allowed in a Shoe");
		} else {
			if ((deckType >= 1) && (deckType <=5)) {
				// minimum number of decks in shoe is 1 (add first deck)
				if (deckType == 1) {
					myDeck = new StandardDeck();
				} else {
					myDeck = new CustomDeck1();
				}
				// add additional decks to match numOfDecks
				if (numOfDecks >= 2) {
					for (int i = 0; i <= (numOfDecks - 2); i++) {
						myDeck.buildDeck();
					}
				}
			} else {
				System.out.println("Only a deckType between 1 and 5 is allowed");
			}
		}
		return myDeck;
	}
	
	// overloaded method allows number and type of decks & joker boolean to be passed as params
	// *** change to switch statement to allow 5 deck types ***
	public Deck buildShoe(int deckType, int numOfDecks, boolean hasJoker) {	
		if (numOfDecks >= MAX_DECKS) {
			System.out.println("A maximum of 8 Decks is allowed in a Shoe");
		} else {
			if ((deckType >= 1) && (deckType <=5)) {
				if (deckType == 1) {
					// minimum number of decks in shoe is 1 (add first deck)
					if (hasJoker == true) {
						myDeck = new StandardDeck(true);
					} else {
						myDeck = new StandardDeck();	
					}
				} else {
					if (hasJoker == true) {
						myDeck = new CustomDeck1(true);
					} else {
						myDeck = new CustomDeck1();
					}
				}
				// add additional decks to match numOfDecks
				if (numOfDecks >= 2) {
					for (int i = 0; i <= (numOfDecks - 2); i++) {
						if (hasJoker == true) {
							myDeck.buildDeck();
							myDeck.addJoker();
							myDeck.addJoker();
						} else {
							myDeck.buildDeck();
						}
					}
				}
			} else {
				System.out.println("Only a deckType between 1 and 5 is allowed");
			}
		}
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
	public int getDeckType() {
		return deckType;
	}

	/**
	 * @param deckType the deckType to set
	 */
	public void setDeckType(int deckType) {
		this.deckType = deckType;
	}
	
	/**
	 * 
	 * @return Does Shoe have Jokers?
	 */
	public boolean hasJokers() {
		return hasJokers;
	}
	
	/**
	 * 
	 * @return the Deck(s) used to build this Shoe
	 */
	public Deck getDeck() {
		return myDeck;
	}
	
	public void shuffleShoe() {
		
	}
	
	// Override toString() to print Shoe2 contents instead of hashcode for Shoe2
	@Override
	public String toString() {
		return "" + myDeck;
	}
	
	/**
	 * List proper int values to pass for each deck type available
	 */
	public static void listDeckTypesAvailable() {
		System.out.println("Available Deck Types (pass int value to constructor):\n"
			+ "StandardDeck = 1\n" + "CustomDeck1 = 2");
	}
	
	// unit test method
	public static void main(String[] args) {
		// show us the int values to use for different deck types available
		// listDeckTypesAvailable();
		
		// shoe constructor uses (int deckType, int numOfDecks, boolean hasJokers)
		Shoe2 myShoe = new Shoe2(2,2,true);
//		Deck thisDeck = getDeck();
//		Collections.shuffle(myShoe);
		System.out.println(myShoe);
	}
}

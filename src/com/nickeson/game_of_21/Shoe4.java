package com.nickeson.game_of_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
 * NEXT: ADD SHUFFLE METHOD AND WAY TO SET/CHECK SHUFFLE MARKER
 * TO DO THIS, IMPLEMENT SHOE AS A VERY LARGE DECK WITH NUMBER OF CARDS IN SHOE
 *  BASED ON FORMULAS FOR NUMBER OF CARDS IN DECK.  THIS WAY SHOE GETS BUILT AS
 *  A LARGE DECK (AN ARRAYLIST OF CARDS), RATHER THAN A COLLECTION OF DECKS.  WE
 *  WANT A COLLECTION OF CARDS, NOT A COLLECTION OF DECKS FOR SHUFFLE TO WORK
 */

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Shoe4.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A Shoe of playing cards, accepts int params for number
 * and types of decks in Shoe, boolean for adding jokers or not<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 19, 2016<p/>
 * updates:
 ****************************************************************************/

public class Shoe4 {
	private int deckType;
	private int numOfDecks;
//	private Deck myDeck;
//	private Deck<Card> myDeck;
	private ArrayList<Card> myDeck = new Deck<Card>();
//	private Deck<StandardDeck> myDeck = new Deck<Card>();
//	private Deck<Card> myDeck = new Deck<Card>();
	private boolean hasJokers;
	ArrayList<? extends Card> myShoe;
	
	// default number of Decks in a Shoe is 6, Shoe can contain no more than 8 decks
	public static final int STD_SHOE_SIZE = 6;
	public static final int MAX_DECKS = 8;
	
	// default no-arg constructor builds a default size deck Shoe of StandardDeck type
	public Shoe4() {
		buildShoe(1, STD_SHOE_SIZE);
	}
	
	// overloaded constructor to build a default size deck Shoe of specified deck type
	public Shoe4(int deckType) {
		buildShoe(deckType, STD_SHOE_SIZE);
	}
	
	// overloaded constructor to build Shoe with specific number of decks and deckType
	public Shoe4(int deckType, int numOfDecks) {
		this.numOfDecks = numOfDecks;
		this.deckType = deckType;
		buildShoe(deckType, numOfDecks);
	}
	
	// overloaded constructor to build Shoe of specific deckType, with or without Jokers
	public Shoe4(int deckType, boolean hasJokers) {
		this.deckType = deckType;
		this.hasJokers = hasJokers;
		if (hasJokers == true) {
			buildShoe(deckType, STD_SHOE_SIZE, true);
		} else {
			buildShoe(deckType, STD_SHOE_SIZE, false);
		}
	}

	// overloaded constructor to build Shoe with Jokers and specific number of decks and deckType
	public Shoe4(int deckType, int numOfDecks, boolean hasJokers) {
		this.numOfDecks = numOfDecks;
		this.deckType = deckType;
		this.hasJokers = hasJokers;
		if (hasJokers == true) {
			buildShoe(deckType, numOfDecks, true);
		} else {
			buildShoe(deckType, numOfDecks);	
		}
	}
	
	// method to build a single deck of cards of specified deckType (no Jokers)
	public void buildDeck(int deckType) {
		if ((deckType >= 1) && (deckType <= 2)) {
			if (deckType == 1) {
				myDeck = new StandardDeck();
			} else {
				myDeck = new CustomDeck1();
			}
		} else {
			System.out.println("Only a deckType of 1 or 2 is allowed");
		}
	}
	
	// method to build a single deck of cards of specified deckType with or without Jokers
	public void buildDeck(int deckType, boolean hasJokers) {
		if ((deckType >= 1) && (deckType <= 2)) {
			if (deckType == 1) {
				if (hasJokers == true) {
					myDeck = new StandardDeck(true);
				} else {
					myDeck = new StandardDeck();
				}
			} else {
				if (hasJokers == true) {
					myDeck = new CustomDeck1(true);
				} else {
					myDeck = new CustomDeck1();
				}
			}
		} else {
			System.out.println("Only a deckType of 1 or 2 is allowed");
		}
	}
	
	// method to build a single deck Shoe of cards of specific deckType (noJokers)
	public Deck<Card> buildShoe(int deckType) {
		buildDeck(deckType);
		return myDeck;
	}
	
	// overloaded method allows number and type of decks to be passed as params (noJokers)
	public Deck<Card> buildShoe(int deckType, int numOfDecks) {	
		if ((numOfDecks >= MAX_DECKS) || (numOfDecks <= 0)) {
			System.out.println("Please specify an int between 1 and 8 for "
					+ "number of decks in this Shoe");
		} else {
			// build first deck of specified type
			buildDeck(deckType);
			// add additional decks to match numOfDecks
			if (numOfDecks >= 2) {
				for (int i = 0; i <= (numOfDecks - 2); i++) {
					myDeck.buildDeck();
				}
			}
		}
		return myDeck;
	}
	
	// allows number and type of decks to be passed as params (with or without Jokers)
	public Deck<Card> buildShoe(int deckType, int numOfDecks, boolean hasJokers) {	
		if ((numOfDecks >= MAX_DECKS) || (numOfDecks <= 0)) {
			System.out.println("Please specify an int between 1 and 8 for "
					+ "number of decks in this Shoe");
		} else {
			// build first deck of specified type)
			if (hasJokers == true) {
				buildDeck(deckType, true);
			} else {
				buildDeck(deckType);
			}
			// add additional decks to match numOfDecks
			if (hasJokers == true) {
				if (numOfDecks >= 2) {
					for (int i = 0; i <= (numOfDecks - 2); i++) {
						myDeck.buildDeck();
						myDeck.addJoker();
						myDeck.addJoker();
					}
				}
			} else {
				if (numOfDecks >= 2) {
					for (int i = 0; i <= (numOfDecks - 2); i++) {
						myDeck.buildDeck();
					}
				}
			}
		}
		return myDeck;
	}
	
	// custom method to shuffle all decks in Shoe as a group
	// (rather than shuffling each deck individually and then combining)
	public void shuffleShoe() {
//		ArrayList comboDeck = (ArrayList)myDeck;
		if (myDeck instanceof Deck) {
			System.out.println("TEST");
		}
//		Collections.shuffle(myDeck);
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
	 * 
	 * @return type of Deck(s) in this Shoe
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

	// Override toString() to print Shoe4 contents instead of hashcode for Shoe4
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
		
		// int deckType, int numOfDecks, boolean hasJokers
		// numOfDecks defaults to STD_SHOE_SIZE and can be skipped
		Shoe4 testShoe = new Shoe4(1, true);
		System.out.println(testShoe);
		testShoe.shuffleShoe();
	}
}
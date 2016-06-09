package com.nickeson.game.cardgame;

import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Shoe.java <p/>
 * <b>Project</b>: cardgames <p/>
 * <b>Description: </b> A Shoe of Cards for use in card games<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Shoe {

	private StdDeck gameDeck = new StdDeck();
	
	/**
	 * default constructor
	 */
	public Shoe() {
	}
	
	/**
	 * returns the Shoe as a List of Cards
	 * @return the Shoe as a List of Cards
	 */
	public List<Card> getShoe() {
		return gameDeck.getDeck();
	}

	/**
	 * adds a StdDeck of Cards to the Shoe
	 * @param deck the Deck of Cards to add to the Shoe
	 */
	public void addDeck(StdDeck deck) {
		gameDeck.addCards(deck.getDeck());
	}

	/**
	 * returns the number of Cards in the Shoe
	 * @return the number of Cards in the Shoe
	 */
	public int size() {
		return gameDeck.size();
	}
	
	/**
	 * Override toString() method to print the Shoe's String value instead of hashcode
	 */
	@Override
	public String toString() {
		return "" + gameDeck;
	}

	// unit test method
//	public static void main(String[] args) {
//		Shoe shoe = new Shoe();
//		Map<String, Object> deckOpt = new HashMap<String, Object>();
//		deckOpt.put("stdDeckNumJokers", new Integer(0));
//		StdDeck testDeck = new StdDeck(deckOpt);
//		shoe.addDeck(testDeck);	
//		shoe.addDeck(testDeck);		
//		System.out.println(shoe);
//		System.out.println(shoe.size());
//		Collections.shuffle(shoe.getShoe());
//		System.out.println(shoe);	
//	}
}
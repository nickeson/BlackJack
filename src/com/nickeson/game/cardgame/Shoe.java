package com.nickeson.game.cardgame;

import java.util.List;
import java.util.ArrayList;
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

	private DeckIntfc gameDeck = null;
	public static final String DECKTYPE = "typeOfDeck";
	
	/**
	 * default constructor builds a single Deck Shoe using Decks of type 'deckType'
	 */
	public Shoe(Map<String, DeckIntfc> deckType) {
//	public Shoe() {
//		gameDeck = new StdDeck();
		if (deckType.containsKey(DECKTYPE) && deckType.get(DECKTYPE) != null) {
			gameDeck = deckType.get(DECKTYPE);
		}
	}
	
	/**
	 * returns the Shoe as a List of Cards
	 * @return the Shoe as a List of Cards
	 */
	public List<Card> getShoe() {
		return gameDeck.getDeck();
	}

	/**
	 * add a Deck of Cards to the Shoe
	 * @param deck the Deck of Cards to add to the Shoe
	 */
	public void addDeck(DeckIntfc deck) {
		gameDeck.addCards(deck.getDeck());
	}

	/**
	 * returns the number of Cards in the Shoe
	 * @return the number of Cards in the Shoe
	 */
	public int size() {
		if (gameDeck == null) {
			return 0;
		} else {
			return gameDeck.size();
		}
	}
	
	/**
	 * Override toString() method to print the Shoe's String value instead of hashcode
	 */
	@Override
	public String toString() {
		return "" + gameDeck;
	}

	// unit test method
	public static void main(String[] args) {
		// we specify Deck type by passing it a Map during construction
		Map<String, DeckIntfc> deckType = new HashMap<>();
		deckType.put("typeOfDeck", (new TestDeck())); 
		
		// builds first Deck in Shoe using Deck of deckType	
		Shoe gameShoe = new Shoe(deckType); 
		System.out.println(gameShoe);

		Map<String, Object> deckOpt = new HashMap<String, Object>();
		deckOpt.put("stdDeckNumJokers", new Integer(0));
		StdDeck stdDeck = new StdDeck(deckOpt);
		System.out.println(stdDeck);

		gameShoe.addDeck(stdDeck);
//		gameShoe.addDeck(testDeck);		
///		System.out.println(gameShoe);
		System.out.println(gameShoe.size());
		Collections.shuffle(gameShoe.getShoe());
		System.out.println(gameShoe);	
	}
}
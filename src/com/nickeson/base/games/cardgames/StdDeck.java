package com.nickeson.base.games.cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.nickeson.base.games.cardgames.Deck;
import com.nickeson.base.games.cardgames.PlayingCard;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: StdDeck.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A standard card deck with and without Jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class StdDeck implements Deck {
	private List<PlayingCard> stdDeck = new ArrayList<PlayingCard>();	
//	private String[] cardSuits = new String[4];	 
//	private static String[] cardRanks = new String[13];
//	private static String[] cardValues = new String[13];
	
	/**
	 * constructor to build a deck with no jokers if no arg is passed 
	 */
	public StdDeck(){
		build();
	}
	
	/**
	 * constructor to build a deck with or without jokers if arg is passed     
	 * @param numOfJokers
	 */
	public StdDeck(int numOfJokers) {
		build();
		for (int j = 0; j < numOfJokers; j++) {
			addCard();
		}
	}

	/**
	 * build a Standard Deck of cards
	 */
	public void build() {
	}
	
	/**
	 * 
	 */
	public void addCard() {
	}
	
	public void discard(){
	}
	
	public void reset(){
	}
	
	public PlayingCard getTopCard(){
		return null;
	}
	
	/**
	 * shuffle the Deck
	 */
	public void shuffle() {
		Collections.shuffle(stdDeck);
	}
	
	/**
	 * @return the List of PlayingCards in the Deck
	 */
	public List<PlayingCard> getDeck(){
        return stdDeck;
    }
	
	/**
	 * Override toString method to print Deck's String values instead of hashcode
	 */
	@Override
	public String toString() {
		String printDeck = "" + stdDeck;
		return printDeck;
	}
 	 
	// unit test method
	public static void main(String[] args) {
	}
}
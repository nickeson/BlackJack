package com.nickeson.games.cardgames;

//JDK 1.8.0
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: Shoe.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A Shoe of Standard PlayingCards of specified number of
 * Decks, with and without Jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Shoe {

	private List<Card> shoe = new ArrayList<Card>();
//	private static String[] cardSuits = new String[4];	 
//	private static String[] cardRanks = new String[13];
//	private static String[] cardValues = new String[13];
//	private int numOfDecks = 1;
//	private static final int MAX_DECKS = 8;
	
	/**
	 * default constructor to build a 6-Deck Standard Shoe with no Jokers
	 */
	public Shoe(){
		build(6, 0);
	}
	
	/**
	 * convenience constructor to build a Shoe with a specific number of Decks
	 * @param numJokers
	 */
	public Shoe(int numDecks, int numJokers) {
		build(numDecks, numJokers);
	}

	/**
	 * build a shoe of Decks with a specific number of Jokers (per Deck)
	 */
	protected void build(int numDecks, int numJokers) {
	}
	
	/**
	 * @return the next Card in the Shoe (starting with top card[0])
	 */
	public Card getCard() {
		Card result = null;
		return result;
	}
	
	/**
	 * @param shoeLoc
	 * @return the Card from specific location (shoeLoc) in Shoe 
	 */
	public Card getCard(int shoeLoc) {
		Card result = null;
		return result;
	}
	
	/**
	 * @return the List of Playing Cards in the Shoe
	 */
	public List<Card> getShoe() {
        return shoe;
    }
	
	/**
	 * @return a Card from a random location in the Shoe
	 */
	public Card getRandom() {
		Card result = null;
		return result;
	}
	
	/**
	 * remove a specific card from the Shoe at location cardLoc
	 * @param cardLoc
	 */
	public void removeCard(int cardLoc) {
	}
	
	/**
	 * reset the Shoe: add all cards from inUse and discards piles, shuffle Shoe
	 */
	public void reInitialize(){
	}

	/**
	 * a method to shuffle this StdShoe
	 */
	public void shuffle() {
		Collections.shuffle(shoe);
	}
	
	/**
	 * print Shoe String values instead of hashcode
	 */
	@Override
	public String toString() {
		String printDeck = "" + shoe;
		return printDeck;
	}
 	 
	// unit test method
	public static void main(String[] args) {
	}
}
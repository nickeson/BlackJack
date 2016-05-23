package com.nickeson.game_of_21;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Deck.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A class to hold a collection of cards for use in various games<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

// this allows us to build a collection of cards, or any subtypes of cards (standard or crazy)
public interface Deck<T extends Card> {
//public interface Deck { // worked for Shoe.3 with everything but Shuffle method - casting problems from deck to arraylist of cards
	/**
	 * 
	 */
	public void buildDeck();
	/**
	 * 
	 */
	public void shuffleDeck();
	/**
	 * 
	 */
	public void addJoker();
}
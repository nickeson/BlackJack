package com.nickeson.games.cardgames;

import java.util.List;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Deck.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A generic interface for collections of Playing Cards
 * for use in various games.<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

// a collection of cards, or any subtypes of cards (standard or crazy)
public interface Deck<T extends PlayingCard> {
	/**
	 * must be implemented by concrete class
	 * build a new Deck
	 */
	public void buildDeck();
	
	/**
	 * must be implemented by concrete class 
	 * shuffle the Deck
	 */
	public void shuffleDeck();
	
	/**
	 * must be implemented by concrete class 
	 * add a Joker to the Deck
	 */
	public void addJoker();
	
	/**
	 * must be implemented by concrete class 
	 * @return list the Playing Cards in the Deck
	 */
	public List<PlayingCard> getCards();
}
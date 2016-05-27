package com.nickeson.base.games.cardgames;

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
 * @version 2.0
 * @since May 27, 2016<p/>
 * updates:
 ****************************************************************************/

public interface Deck {
	/**
	 * build a new Deck
	 */
	public void build();

	/**
	 * add a Card to the Deck
	 */
	public void addCard();

	/**
	 * remove a Card from the Deck and put in discard pile
	 */
	public void discard();
	
	/**
	 * reset the Deck to new
	 */
	public void reset();
	
	/**
	 * shuffle the Deck
	 */
	public void shuffle();
	
	/**
	 * returns the Deck's Top PlayingCard
	 * @return
	 */
	public PlayingCard getTopCard();
	
	/**
	 * returns a list of the PlayingCards in the Deck
	 * @return
	 */
	public List<PlayingCard> getDeck();
}
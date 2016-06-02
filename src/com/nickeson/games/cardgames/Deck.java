package com.nickeson.games.cardgames;

import java.util.List;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Deck.java <p/>
 * <b>Project</b>: Blackjack <p/>
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
	 * add a Card to the Deck
	 */
	public void addCard(Card card);
	
	/**
	 * add multiple Card to the Deck
	 */
	public void addCards(List<Card> cards);
	
	/**
	 * @return the next Card in the Deck
	 */
	public Card getCard();
	
	/**
	 * @param deckLoc
	 * @return the Card at the location specified by deckLoc
	 */
	public Card getCard(int deckLoc);
	
	/**
	 * @return the specific Card referenced by card, remove from deck and add
	 * to inUse pile
	 */
	public Card getCard(Card card);
	
	/**
	 * @return List of the Card in the Deck
	 */
	public List<Card> getDeck();
	
	/**
	 * @return a Card from a random location in the Deck
	 */
	public Card getRandom();
	
	/**
	 * remove a specific Card from the Deck
	 */
	public void removeCard(Card card);
	
	/**
	 * add all Card from discard pile back to Deck
	 */
	public void addDiscards();
	
	/**
	 * shuffle the Deck
	 */
	public void shuffle();
	
	/**
	 * sort the Deck
	 */
	public void sort();
	
	/**
	 * @return the number of Card in the Deck
	 */
	public int size();
	
	/**
	 * remove all Card from discard and inUse piles and add back to Deck
	 */
	public void reInitialize();
}
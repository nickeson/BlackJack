package com.nickeson.game.cardgame;

import java.util.List;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Deck.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> An interface for a collection of Playing Cards (Deck)
 * for use in various card games.<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since May 27, 2016<p/>
 * updates:
 ****************************************************************************/

public interface Deck {

	/**
	 * @param card a Card to add to the Deck
	 */
	public void addCard(Card card);
	
	/**
	 * @param cards a List of one or more Cards to add to the Deck
	 */
	public void addCards(List<Card> cards);
	
	/**
	 * remove next Card from the Deck and add to inUse pile
	 * @return the next Card in the Deck
	 */
	public Card getCard();
	
	/**
	 * remove Card from the Deck at 'deckLoc' and add to inUse pile
	 * @param deckLoc the location in the Deck from which to remove the Card
	 * @return the Card from the Deck at 'deckLoc'
	 */
	public Card getCard(int deckLoc);
	
	/**
	 * remove a specific Card from the Deck and add to inUse pile
	 * @param card the specific Card to get from the Deck
	 * @return the specific Card from the Deck
	 */
	public Card getCard(Card card);
	
	/**
	 * (Does not remove cards from the Deck or move to inUse or discards)
	 * @return a List of Cards in the Deck
	 */
	public List<Card> getDeck();
	
	/**
	 * remove Card at random from the Deck and add to inUse pile
	 * @return a randomly drawn Card from the Deck
	 */
	public Card getRandom();
	
	/**
	 * remove a specific Card from the Deck, inUse and discards piles 
	 * @param card the specific Card to remove from the Deck
	 */
	public void removeCard(Card card);
	
	/**
	 * remove a specific Card from the Deck or inUse pile and add to discards pile
	 * @param card the card to put in the discards pile
	 */
	public void discard(Card card);

	/**
	 * add all Cards from discard pile to the Deck
	 */
	public void addDiscards();
	
	/**
	 * shuffle the Deck
	 */
	public void shuffle();
	
	/**
	 * @return the number of Cards in the Deck
	 */
	public int size();
	
	/**
	 * remove all Cards from discard and inUse piles and add to the Deck, shuffle
	 */
	public void reInitialize();
}
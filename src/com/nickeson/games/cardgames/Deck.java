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
	 * @param card a Card to add to the Deck
	 */
	public void addCard(Card card);
	
	/**
	 * add multiple Cards to the Deck
	 * @param cards a List of one or more Cards to add to the Deck
	 */
	public void addCards(List<Card> cards);
	
	/**
	 * remove next Card from Deck and add to inUse pile
	 * @return Card
	 */
	public Card getCard();
	
	/**
	 * remove Card from Deck at 'deckLoc' and add to inUse pile
	 * @param deckLoc the location in the deck from which to remove the Card
	 * @return Card
	 */
	public Card getCard(int deckLoc);
	
	/**
	 * remove a specific Card from Deck and add to inUse pile
	 * @param card the specific Card to get from the Deck
	 * @return Card
	 */
	public Card getCard(Card card);
	
	/**
	 * return a List of the Cards in the Deck - 
	 * (Does not remove cards from Deck or move to inUse or discards)
	 * @return List<Card>
	 */
	public List<Card> getDeck();
	
	/**
	 * remove Card from Deck and add to inUse pile
	 * @return Card
	 */
	public Card getRandom();
	
	/**
	 * remove a specific Card from the Deck, inUse and discards piles 
	 * @param card the specific Card to remove from the Deck
	 */
	public void removeCard(Card card);
	
	/**
	 * add all Cards from discard pile back to Deck
	 */
	public void addDiscards();
	
	/**
	 * shuffle the Deck
	 */
	public void shuffle();
	
	/**
	 * return the number of Cards in the deck
	 * @return size
	 */
	public int size();
	
	/**
	 * remove all Cards from discard and inUse piles and add back to Deck, shuffle
	 */
	public void reInitialize();
}
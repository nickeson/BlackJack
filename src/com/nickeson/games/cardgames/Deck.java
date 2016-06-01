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
	 * add a CardVO to the Deck
	 */
	public void addCard(CardVO card);
	
	/**
	 * add multiple CardVO to the Deck
	 */
	public void addCards(List<CardVO> cards);
	
	/**
	 * @return the next CardVO in the Deck
	 */
	public CardVO getCard();
	
	/**
	 * @param cardLoc
	 * @return the CardVO at the location specified by deckLoc
	 */
	public CardVO getCard(int deckLoc);
	
	/**
	 * @return the specific CardVO referenced by card, remove from deck and add
	 * to inUse pile
	 */
	public CardVO getCard(CardVO card);
	
	/**
	 * @return List of the CardVO in the Deck
	 */
	public List<CardVO> getDeck();
	
	/**
	 * @return a CardVO from a random location in the Deck
	 */
	public CardVO getRandom();
	
	/**
	 * remove a specific CardVO from the Deck
	 */
	public void removeCard(CardVO card);
	
	/**
	 * add all CardVO from discard pile back to Deck
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
	 * @return the number of CardVO in the Deck
	 */
	public int size();
	
	/**
	 * remove all CardVO from discard and inUse piles and add back to Deck
	 */
	public void reInitialize();
}
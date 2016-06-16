package com.nickeson.game.cardgame;

//JDK 1.8.0
import java.util.List;

/****************************************************************************
 * <b>Title</b>: DeckIntfc.java <p/>
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

public interface DeckIntfc {
	/**
	 * @param card a Card to add to the Deck
	 */
	public void addCard(Card card);
	
	/**
	 * @param cards a List of one or more Cards to add to the Deck
	 */
	public void addCards(List<Card> cards);

	/**
	 * add all Cards from discard pile to the Deck
	 */
	public void addDiscards();
	
	/**
	 * remove next Card from the Deck and add to inUse pile
	 * @return the next Card in the Deck
	 * @throws EmptyDeckException
	 */
	public Card getCard() throws EmptyDeckException;
	
	/**
	 * remove Card from the Deck at 'deckLoc' and add to inUse pile
	 * @param deckLoc the location in the Deck from which to remove the Card
	 * @return the Card from the Deck at 'deckLoc'
	 * @throws EmptyDeckException
	 */
	public Card getCard(int deckLoc) throws EmptyDeckException;

	/**
	 * remove Card at random from the Deck and add to inUse pile
	 * @return a randomly drawn Card from the Deck
	 * @throws EmptyDeckException
	 */
	public Card getRandomCard() throws EmptyDeckException;
	
	/**
	 * remove a specific Card from the Deck, inUse and discards piles 
	 * @param card the specific Card to remove from the Deck
	 * @throws EmptyDeckException
	 */
	public void removeCard(Card card) throws EmptyDeckException;
	
	/**
	 * move a specified number of Cards (qty) from the Deck to the discards pile, 
	 * starting at location (pos)
	 * @param qty the Quantity of Cards to move to the discards pile
	 * @param pos the Position in the Deck from which to move Cards
	 * @throws EmptyDeckException
	 */
	public void burnCard(int qty, int pos) throws EmptyDeckException;
	
	/**
	 * remove a specific Card from the Deck or inUse pile and add to discards pile
	 * @param card the card to put in the discards pile
	 * @throws EmptyDeckException
	 */
	public void discard(Card card) throws EmptyDeckException;
	
	/**
	 * Does not remove cards from the Deck or move to inUse or discards
	 * @return a List of Cards in the Deck
	 */
	public List<Card> getDeck();
	
	/**
	 * Does not remove Cards from the discards pile
	 * @return the Cards in the discards pile
	 */
	public List<Card> getDiscards();
	
	/**
	 * Does not remove Cards from inUse pile
	 * @return the Cards in the inUse pile
	 */
	public List<Card> getInUse();
	
	/**
	 * Displays the Card at a specific location (pos) in the Deck
	 * Does not getCard or move Card from Deck to inUse or discards piles
	 * @param pos the Position in the Deck of the Card to be viewed
	 * @return the Card from the Deck at Position 'pos'
	 */
	public Card peek(int pos);
	
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
	 * @throws EmptyDeckException
	 */
	public void reInitialize() throws EmptyDeckException;
}
package com.nickeson.game.cardgame;

//JDK 1.8.0
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

/****************************************************************************
 * <b>Title</b>: StdDeck.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A Standard Playing Card Deck built with options from
 * an options Map<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 3.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class StdDeck implements DeckIntfc {
	private List<Card> deck = new ArrayList<Card>();	
	private List<Card> discards = new ArrayList<>();
	private List<Card> inUse = new ArrayList<>();
	private static final String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs" };
	public static final String OPT_NUM_JOKERS = "stdDeckNumJokers";

	/**
	 * default constructor builds a StdDeck with no Jokers
	 */
	public StdDeck() {
		build(0);
	}
	
	/**
	 * convenience constructor allows us to pass an options Map and build Deck
	 * using options from the Map
	 * @param options the Map of options to use when building the Deck
	 */
	public StdDeck(Map<String, Object> options) {
		int numJokers = 0;
		if (options.containsKey(OPT_NUM_JOKERS) && options.get(OPT_NUM_JOKERS) != null) 
			numJokers = Integer.valueOf(options.get(OPT_NUM_JOKERS) + "");
		build(numJokers);
	}
	
	/**
	 * build a Standard Deck of cards
	 * @param numJokers the number of Jokers to use when building the StdDeck
	 */
	private void build(int numJokers) {
		// add specific number of joker(s) so they're on the top of the Deck
		for (int i=0; i < numJokers; i++) {
			deck.add(new Card("", "Joker", 0)); // Joker indexValue = 0 
		}
		// add the rest of the Cards
		for(int i=0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				String rank = "";
				switch(j) {
					case 0:
						rank = "Ace";
						break;
					case 10:
						rank = "Jack";
						break;
					case 11:
						rank = "Queen";
						break;
					case 12:
						rank = "King";
						break;
					default:
						rank = "" + (j+1);
				}
				deck.add(new Card(suits[i], rank, j+1)); // suit, rank, indexValue 
			}
		}
	}
	
	/**
	 * add a specific Card to the Deck
	 * @param card a Card to add to the Deck
	 */
	public void addCard(Card card) {
		deck.add(card);
	}
	
	/**
	 * add a List of Cards to the Deck
	 * @param cards a List of one or more Cards to add to the Deck
	 */
	public void addCards(List<Card> cards) {
		for (Card card : cards) {
			deck.add(card);
		}
	}
	
	/**
	 * move all Cards from discard pile back to the Deck
	 */
	public void addDiscards() {
		if (!discards.isEmpty()) {
			for (Card c : discards) {
				deck.add(c);
			}
				discards.clear();
		} else {
			System.out.println("The discard pile is empty");
		}
	}
	
	/**
	 * Get the next Card in the Deck (starting with top Card [0]), move card to
	 * inUse pile and remove from Deck
	 * @return the next Card from the Deck
	 * @throws EmptyDeckException
	 */
	public Card getCard() throws EmptyDeckException {
		Card nextCard = null;
		if (deck.isEmpty()) throw new EmptyDeckException("The Deck is Empty "
				+ "- you cannot get a Card");
		nextCard = deck.get(0);
		deck.remove(nextCard);
		inUse.add(nextCard);
		return nextCard;
	}
	
	/**
	 * remove Card from Deck at 'deckLoc' and add to inUse pile
	 * @param deckLoc the location in the Deck from which to remove the Card
	 * @return the Card from the Deck at 'deckLoc'
	 * @throws EmptyDeckException
	 */
	public Card getCard(int deckLoc) throws EmptyDeckException {
		Card card = null;
		if (deck.isEmpty()) throw new EmptyDeckException("The Deck is Empty "
				+ "- you cannot get a Card");
		card = deck.get(deckLoc);
		deck.remove(card);
		inUse.add(card);
		return card;
	}
	
	/**
	 * return a Card from a random location in the Deck, remove from the Deck and 
	 * add to inUse pile
	 * @return a randomly drawn Card from the Deck
	 * @throws EmptyDeckException
	 */
	public Card getRandomCard() throws EmptyDeckException {
		Card card = null;
		if (deck.isEmpty()) throw new EmptyDeckException("The Deck is Empty "
				+ "- you cannot get a Card");
		Random rand = new Random();
		int rNum = rand.nextInt(deck.size());
		card = deck.get(rNum);
		deck.remove(card);
		inUse.add(card);
		return card;
	}
	
	/**
	 * remove a specific Card from the Deck (remove from Deck, inUse and discards)
	 * @param card the specific Card to remove from the Deck
	 * @throws EmptyDeckException
	 */
	public void removeCard(Card card) throws EmptyDeckException {
		if (deck.isEmpty()) { throw new EmptyDeckException("The Deck is Empty "
				+ "- you cannot check for a Card to remove");
		} else {
			if (deck.contains(card) || inUse.contains(card) || discards.contains(card)) {
				if (deck.contains(card)) {
					deck.remove(card);
				}
				if (inUse.contains(card)) {
					inUse.remove(card);
				}
				if (discards.contains(card)) {
					discards.remove(card);
				}
			} else {
				System.out.println("The Deck does not contain your Card");
			}
		}
	}

	/**
	 * discard the specified 'qty' of Cards, starting from 'pos' position of Deck
	 * @param qty the number of Cards to discard
	 * @param pos the position in the Deck from which to discard (top of Deck = 0)
	 * @throws EmptyDeckException
	 */
	public void burnCard(int qty, int pos) throws EmptyDeckException {
		if (deck.isEmpty()) { throw new EmptyDeckException("The Deck is Empty "
				+ "- you cannot burn Cards");
		} else {
			for (int i = 0; i < qty; i++) {
				discards.add(deck.get(pos));
				deck.remove(pos);
			}
		}
	}

	/**
	 * remove specified Card from the Deck or inUse pile to the discards pile
	 * @param card the specific Card to discard
	 * @throws EmptyDeckException
	 */
	public void discard(Card card) throws EmptyDeckException {
		if (deck.isEmpty()) { throw new EmptyDeckException("The Deck is Empty "
				+ "- you cannot discard");
		} else {
			if (deck.contains(card) || inUse.contains(card)) {
			discards.add(card);
				if (deck.contains(card)) {
					deck.remove(card);
				} else {
					inUse.remove(card);
				}
			} else {
				System.out.println("The Deck does not contain your Card");
			}
		}
	}	
	/** 
	 * Does not remove Cards from the Deck (or move to inUse or discards)
	 * returns the Deck as a List of Cards
	 * @return the Deck as a List of Cards
	 */
	public List<Card> getDeck() {
		return deck;
	}
	
	/**
	 * Does not remove Cards from the discards pile
	 * @return the Cards in the discards pile
	 */
	public List<Card> getDiscards() {
		return discards;
	}
	
	/**
	 * Does not remove Cards from inUse pile
	 * @return the Cards in the inUse pile
	 */
	public List<Card> getInUse() {
		return inUse;
	}
	
	/**
	 * Does not remove Card from Deck - returns Card at position 'pos' in Deck
	 * @param pos the Card position in the Deck at which to 'peek'
	 * @return the Card at position 'pos' in the Deck
	 */
	public Card peek(int pos) {
		return deck.get(pos);
	}
	
	/**
	 * shuffle the Deck - Does NOT include Cards from discards pile - 
	 * run addDiscards() first to include discarded Cards in shuffle
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	/**
	 * returns the number of Cards in the Deck
	 * @return the number of Cards in the Deck
	 */
	public int size() {
		return deck.size();
	}
	
	/**
	 * remove all Cards from discard and inUse piles and add back to the Deck, shuffle the Deck
	 * @throws EmptyDeckException
	 */
	public void reInitialize() throws EmptyDeckException {
		for (Card c : inUse) {
			deck.add(c);
		}
		for (Card c : discards) {
			deck.add(c);
		}
		inUse.clear();
		discards.clear();
		Collections.shuffle(deck);
	}

	/**
	 * Override toString() method to print the Deck's String value instead of hashcode
	 * @return the String value of the StdDeck
	 */
	@Override
	public String toString() {
		String printDeck = "" + deck;
		return printDeck;
	}
}
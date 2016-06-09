package com.nickeson.game.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: StdDeck.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A Standard Playing Card DeckIntfc using options from DeckOptions<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
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
	 * default constructor builds a Standard DeckIntfc with 0 Jokers
	 */
	public StdDeck() {
		build(0);
	}
	
	/**
	 * convenience constructor allows us to pass an options Map and build DeckIntfc
	 * using options from the Map
	 */
	public StdDeck(Map<String, Object> options) {
		int numJokers = 0;
		if (options.containsKey(OPT_NUM_JOKERS) && options.get(OPT_NUM_JOKERS) != null) 
			numJokers = Integer.valueOf(options.get(OPT_NUM_JOKERS) + "");
		build(numJokers);
	}
	
	/**
	 * build a Standard DeckIntfc of cards
	 */
	protected void build(int numJokers) {
		// add specific number of joker(s) so they're on the top of the DeckIntfc
		for (int i=0; i < numJokers; i++) {
			deck.add(new Card("", "Joker", 0));
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
				// add Card with suit, rank, value
				deck.add(new Card(suits[i], rank, j+1));
			}
		}
	}
	
	/**
	 * add a specific Card to the DeckIntfc
	 * @param card a Card to add to the DeckIntfc
	 */
	public void addCard(Card card) {
		deck.add(card);
	}
	
	/**
	 * add a List of Cards to the DeckIntfc
	 * @param cards a List of one or more Cards to add to the DeckIntfc
	 */
	public void addCards(List<Card> cards) {
		for (Card card : cards) {
			deck.add(card);
		}
	}
	
	/**
	 * Get the next Card in the DeckIntfc (starting with top Card [0]), move card to
	 * inUse pile and remove from DeckIntfc
	 * @return the next Card from the DeckIntfc
	 */
	public Card getCard() {
		Card nextCard = null;
		if (!deck.isEmpty()) {
			nextCard = deck.get(0);
			deck.remove(nextCard);
			inUse.add(nextCard);
			return nextCard;
		} else {
			System.out.println("The DeckIntfc is empty, therefore Card is null");
			return nextCard;
		}
	}
	
	/**
	 * remove Card from DeckIntfc at 'deckLoc' and add to inUse pile
	 * @param deckLoc the location in the DeckIntfc from which to remove the Card
	 * @return the Card from the DeckIntfc at 'deckLoc'
	 */
	public Card getCard(int deckLoc) {
		Card card = null;
		if (!deck.isEmpty()) {
			card = deck.get(deckLoc);
			deck.remove(card);
			inUse.add(card);
			return card;
		} else {
			System.out.println("The DeckIntfc is empty, therefore Card is null");
			return card;
		}
	}
	
	/**
	 * return the specific Card, remove Card from DeckIntfc and add to inUse pile
	 * @param card the specific Card to get from the DeckIntfc
	 * @return a specific Card from the DeckIntfc
	 */
	public Card getCard(Card card) {
		if (!deck.isEmpty()) {
			if (deck.contains(card)) {
				deck.remove(card);
				inUse.add(card);
				return card;
			} else {
				card = null;
				System.out.println("The DeckIntfc does not contain your Card");
				return card;
			}
		} else {
			card = null;
			System.out.println("The DeckIntfc is empty, therefore Card is null");
			return card;
		}
	}
	
	/** 
	 * (Does not remove cards from the DeckIntfc (or move to inUse or discards)
	 * returns the DeckIntfc as a List of Cards
	 * @return the DeckIntfc as a List of Cards
	 */
	public List<Card> getDeck() {
		return deck;
	}
	
	/**
	 * return a Card from a random location in the DeckIntfc, remove from the DeckIntfc and 
	 * add to inUse pile
	 * @return a randomly drawn Card from the DeckIntfc
	 */
	public Card getRandom() {
		Card card = null;
		if (!deck.isEmpty()) {
			Random rand = new Random();
			int rNum = rand.nextInt(deck.size());
			card = deck.get(rNum);
			deck.remove(card);
			inUse.add(card);
			return card;
		} else {
			System.out.println("You cannot get a random Card from an empty DeckIntfc");
			return card;
		}
	}
	
	/**
	 * remove a specific Card from the DeckIntfc (remove from DeckIntfc, inUse and discards)
	 * @param card the specific Card to remove from the DeckIntfc
	 */
	public void removeCard(Card card) {
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
			System.out.println("The DeckIntfc does not contain your Card");
		}
	}


	/**
	 * remove specified Card from the DeckIntfc or inUse pile to the discards pile
	 * @param card the specific Card to discard
	 */
	public void discard(Card card) {
		if (deck.contains(card) || inUse.contains(card)) {
		discards.add(card);
			if (deck.contains(card)) {
				deck.remove(card);
			} else {
				inUse.remove(card);
			}
		} else {
			System.out.println("The DeckIntfc does not contain your Card");
		}
	}
	
	/**
	 * move all Cards from discard pile back to the DeckIntfc
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
	 * add Card(s) to DeckIntfc from discards pile, shuffle the DeckIntfc
	 */
	public void shuffle() {
		for (Card c : discards) {
			deck.add(c);
		}
		Collections.shuffle(deck);
	}
	
	/**
	 * returns the number of Cards in the DeckIntfc
	 * @return the number of Cards in the DeckIntfc
	 */
	public int size() {
		return deck.size();
	}
	
	/**
	 * remove all Cards from discard and inUse piles and add back to the DeckIntfc, shuffle the DeckIntfc
	 */
	public void reInitialize() {
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

	// for testing only
//	public List<Card> getDiscards() {
//		return discards;
//	}
	
//	public List<Card> getInUse() {
//		return inUse;
//	}
	
	/**
	 * Override toString() method to print the DeckIntfc's String value instead of hashcode
	 */
	@Override
	public String toString() {
		String printDeck = "" + deck;
		return printDeck;
	}
	
	// unit test
//	public static void main (String[] args) {
//		StdDeck testDeck = new StdDeck();
//		Card c1 = (new Card("Spades", "Ace", 1));
//		Card c2 = (new Card("Spades", "2", 2));	
//		Card c3 = (new Card("Spades", "3", 3));	
//		testDeck.addCard(c1);
//		testDeck.addCard(c2);		
//		testDeck.addCard(c3);
//		System.out.println(testDeck);
//		System.out.println(testDeck.size());
//		Card c4 = testDeck.getCard();
//		Card c5 = testDeck.getCard();	
//		System.out.println("c4: " + c4);
//		System.out.println("c5: " + c5);	
//		System.out.println(testDeck.size());
//		testDeck.shuffle();
//		System.out.println(testDeck.size());	
//		System.out.println(testDeck);	
//		testDeck.discard(c1);
//		System.out.println(testDeck.size());	
//		System.out.println(testDeck);			
//		testDeck.discard(c2);	
//		testDeck.discard(c3);
//		testDeck.discard(c4);
//		testDeck.discard(c5);	
//		System.out.println("inUse: " + testDeck.getInUse());
//		System.out.println("discards: " + testDeck.getDiscards());	
//		System.out.println(testDeck.size());	
//		System.out.println(testDeck);			
//		testDeck.shuffle();
//		System.out.println(testDeck.size());	
//		System.out.println(testDeck);
//	}
}
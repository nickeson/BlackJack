package com.nickeson.games.cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: StdDeck.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A standard card deck with and without Jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class StdDeck implements Deck {
	private List<Card> deck = new ArrayList<Card>();	
	private List<Card> discards = new ArrayList<>();
	private List<Card> inUse = new ArrayList<>();
	private static final String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs" };
	public static final String OPT_NUM_JOKERS = "stdDeckNumJokers";

	/**
	 * default constructor builds a Standard Deck with 0 Jokers
	 */
	public StdDeck() {
		build(0);
	}
	
	/**
	 * convenience constructor allows us to pass an options map and build Deck
	 * using options from the map
	 */
	public StdDeck(Map<String, Object> options) {
		int numJokers = 0;
		if (options.containsKey(OPT_NUM_JOKERS) && options.get(OPT_NUM_JOKERS) != null) 
			numJokers = Integer.valueOf(options.get(OPT_NUM_JOKERS) + "");
		
		build(numJokers);
	}
	
	/**
	 * build a Standard Deck of cards
	 */
	protected void build(int numJokers) {
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
		
		// add specific number of joker(s)
		for (int i=0; i < numJokers; i++) {
			// suit, rank, value
			deck.add(new Card("", "Joker", 0));
		}
	}
	
	/**
	 * add a Card to the Deck
	 */
	public void addCard(Card card) {
		deck.add(card);
	}
	
	/**
	 * add multiple Card to the Deck
	 */
	public void addCards(List<Card> cards) {
		for (Card card : cards) {
			deck.add(card);
		}
	}
	
	/**
	 * @return get the next Card in the Deck (starting with top[0])
	 * move card to inUse pile and remove from deck
	 */
	public Card getCard() {
		Card nextCard = null;
		if (!deck.isEmpty()) {
			nextCard = deck.get(0);
			deck.remove(nextCard);
			inUse.add(nextCard);
			return nextCard;
		} else {
			System.out.println("The Deck is empty, therefore Card is null");
			return nextCard;
		}
	}
	
	/**
	 * @param deckLoc
	 * @return the Card at the location specified by deckLoc 
	 */
	public Card getCard(int deckLoc) {
		Card card = null;
		if (!deck.isEmpty()) {
			card = deck.get(deckLoc);
			deck.remove(card);
			inUse.add(card);
			return card;
		} else {
			System.out.println("The Deck is empty, therefore Card is null");
			return card;
		}
	}
	
	/**
	 * @return the specific Card referenced by card, remove from deck and add
	 * to inUse pile
	 */
	public Card getCard(Card card) {
		if (!deck.isEmpty()) {
			if (deck.contains(card)) {
				deck.remove(card);
				inUse.add(card);
				return card;
			} else {
				card = null;
				System.out.println("The Deck does not contain your Card");
				return card;
			}
		} else {
			card = null;
			System.out.println("The Deck is empty, therefore Card is null");
			return card;
		}
	}
	
	/**
	 * @return List of the Card in the Deck
	 * Does not remove cards from deck (or move to inUse or discards)
	 */
	public List<Card> getDeck() {
		return deck;
	}
	
	// for testing only
	private List<Card> getInUseDeck() {
		return inUse;
	}
	
	// for testing only
	private List<Card> getDiscards() {
		return discards;
	}
	
	/**
	 * @return a Card from a random location in the Deck
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
			System.out.println("You cannot get a random Card from an empty Deck");
			return card;
		}
	}
	
	/**
	 * remove a specific Card from the Deck (remove from deck, inUse and discards)
	 */
	public void removeCard(Card card) {
		if (deck.contains(card)) {
			deck.remove(card);
		} else {
			System.out.println("The Deck does not contain your Card");
		}
		if (inUse.contains(card)) {
			inUse.remove(card);
		} else {
			System.out.println("The inUse pile does not contain your Card");
		}
		if (discards.contains(card)) {
			discards.remove(card);
		} else {
			System.out.println("The discards pile does not contain your Card");
		}
	}
	
	/**
	 * @param card remove specified card from deck or inUse pile to the discards pile
	 */
	public void discard(Card card) {
		discards.add(card);
		if (deck.contains(card)) {
			deck.remove(card);
			discards.add(card);
		} else {
			System.out.println("The Deck does not contain your Card");
		}
		if (inUse.contains(card)) {
			inUse.remove(card);
			discards.add(card);
		} else {
			System.out.println("The inUse pile does not contain your Card");
		}
	}
	
	/**
	 * move all Card from discard pile back to Deck
	 */
	public void addDiscards() {
		for (Card c : discards) {
			deck.add(c);
		}
			discards.clear();
	}
	
	/**
	 * shuffle the Deck
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	/**
	 * ** NEEDS WORK **
	 * sort the Deck
	 */
	public void sort() {
		Collections.sort(deck);
	}
	
	/**
	 * @return the number of Card in the Deck
	 */
	public int size() {
		return deck.size();
	}
	
	/**
	 * remove all Card from discard and inUse piles and add back to Deck
	 */
	public void reInitialize() {
	}

	/**
	 * Override toString method to print Deck's String values instead of hashcode
	 */
	@Override
	public String toString() {
		String printDeck = "" + deck;
		return printDeck;
	}
 	 
	// unit test method
	public static void main(String[] args) {
		// test DeckOptions 
		StdDeck mainDeck = new StdDeck(new DeckOptions().getDeckOptions());
		
		// test shuffle()
		mainDeck.shuffle();
//		System.out.println(mainDeck);

		// test addCard()
//		mainDeck.addCard(new Card("Spades", "Ace", 11));
//		System.out.println(mainDeck);
		
		// test addCards()
//		List<Card> cards = new ArrayList<Card>();
//		cards.add(new Card("Hearts", "King", 10));
//		cards.add(new Card("Spades", "King", 10));	
//		mainDeck.addCards(cards);
//		System.out.println(mainDeck);
		
		// test getCard() variants
//		Card testCard = mainDeck.getCard();
//		Card testCard = mainDeck.getCard(51);
//		Card aos = new Card("Spades", "Ace", 1);
//		mainDeck.addCard(aos);
//		System.out.println(mainDeck); // print out mainDeck with added Ace of Spades
//		Card testCard = mainDeck.getCard(aos);
//		System.out.println(testCard);  // print out card we're going to get
//		System.out.println(mainDeck); // print out mainDeck after we got the card
//		System.out.println(mainDeck.getInUseDeck()); // print out list of 'inUse' cards
		
		// test discard()
//		mainDeck.discard(aos);
//		System.out.println(mainDeck);
//		System.out.println(mainDeck.getDiscards());
		
		// test getDeck()
//		List<Card> newDeck = mainDeck.getDeck();
//		Card aos = new Card("Spades", "Ace", 1);
//		newDeck.add(aos);
//		System.out.println(newDeck);
		
		// test getRandom()
//		Card randCard = mainDeck.getRandom();
//		System.out.println(randCard);
		
		// test addDiscards()
//		System.out.println(mainDeck); // print initial deck
//		Card one = mainDeck.getCard(0); // get 3 cards (move from main deck to inUse deck)
//		Card two = mainDeck.getCard(0);	
//		Card three = mainDeck.getCard(0);		
//		System.out.println(mainDeck.getInUseDeck()); // print inUse deck
//		mainDeck.discard(one);
//		mainDeck.discard(two);	
//		mainDeck.discard(three);
//		System.out.println(mainDeck); // print deck (should be missing discarded cards)
//		System.out.println(mainDeck.getDiscards());	 // print discards deck
//		System.out.println(mainDeck.getInUseDeck()); // print inUse deck	
//		mainDeck.addDiscards();
		System.out.println(mainDeck);
		mainDeck.sort();
		System.out.println(mainDeck);	
		DeckOptions.getDeckOptions();
	}
}
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
	private List<CardVO> deck = new ArrayList<CardVO>();	
	private List<CardVO> discards = new ArrayList<>();
	private List<CardVO> inUse = new ArrayList<>();
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
				// add CardVO with suit, rank, value
				deck.add(new CardVO(suits[i], rank, j+1));
			}
		}
		
		// add specific number of joker(s)
		for (int i=0; i < numJokers; i++) {
			// suit, rank, value
			deck.add(new CardVO("", "Joker", 0));
		}
	}
	
	/**
	 * add a CardVO to the Deck
	 */
	public void addCard(CardVO card) {
		deck.add(card);
	}
	
	/**
	 * add multiple CardVO to the Deck
	 */
	public void addCards(List<CardVO> cards) {
		for (CardVO card : cards) {
			deck.add(card);
		}
	}
	
	/**
	 * @return get the next CardVO in the Deck (starting with top[0])
	 */
	public CardVO getCard() {
		CardVO nextCard = null;
		if (!deck.isEmpty()) {
			nextCard = deck.get(0);
			deck.remove(nextCard);
			inUse.add(nextCard);
			return nextCard;
		} else {
			System.out.println("The Deck is empty, therefore CardVO is null");
			return nextCard;
		}
	}
	
	/**
	 * @param deckLoc
	 * @return the CardVO at the location specified by deckLoc 
	 */
	public CardVO getCard(int deckLoc) {
		CardVO card = null;
		if (!deck.isEmpty()) {
			card = deck.get(deckLoc);
			deck.remove(card);
			inUse.add(card);
			return card;
		} else {
			System.out.println("The Deck is empty, therefore CardVO is null");
			return card;
		}
	}
	
	/**
	 * @return the specific CardVO referenced by card, remove from deck and add
	 * to inUse pile
	 */
	public CardVO getCard(CardVO card) {
		if (!deck.isEmpty()) {
			if (deck.contains(card)) {
				deck.remove(card);
				inUse.add(card);
				return card;
			} else {
				card = null;
				System.out.println("The Deck does not contain your CardVO");
				return card;
			}
		} else {
			card = null;
			System.out.println("The Deck is empty, therefore CardVO is null");
			return card;
		}
	}
	
	/**
	 * @return List of the CardVO in the Deck
	 */
	public List<CardVO> getDeck() {
		return deck;
	}
	
	/**
	 * @return a CardVO from a random location in the Deck
	 */
	public CardVO getRandom() {
		CardVO card = null;
		if (!deck.isEmpty()) {
			Random rand = new Random();
			int rNum = rand.nextInt(deck.size());
			card = deck.get(rNum);
			return card;
		} else {
			System.out.println("You cannot get a random CardVO from an empty Deck");
			return card;
		}
	}
	
	/**
	 * remove a specific CardVO from the Deck (remove from Deck entirely)
	 */
	public void removeCard(CardVO card) {
		if (deck.contains(card)) {
			deck.remove(card);
		} else {
			System.out.println("The Deck does not contain your CardVO");
		}
	}
	
	/**
	 * @param card remove specified card to the discards pile
	 */
	public void discard(CardVO card) {
		discards.add(card);
		if (deck.contains(card)) {
			deck.remove(card);
		}
		
		if (inUse.contains(card)) {
			inUse.remove(card);
		}
	}
	
	/**
	 * move all CardVO from discard pile back to Deck
	 */
	public void addDiscards() {
		for (CardVO c : discards) {
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
	 * sort the Deck
	 */
	public void sort() {
		Collections.sort(deck);
	}
	
	/**
	 * @return the number of CardVO in the Deck
	 */
	public int size() {
		return deck.size();
	}
	
	/**
	 * remove all CardVO from discard and inUse piles and add back to Deck
	 */
	public void reInitialize() {
	}
	
	// for testing only
	private List<CardVO> getInUseDeck() {
		return inUse;
	}
	
	// for testing only
	private List<CardVO> getDiscards() {
		return discards;
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
		// test DeckOptionsVO 
		StdDeck mainDeck = new StdDeck(new DeckOptionsVO().getDeckOptions());
		
		// test shuffle()
		mainDeck.shuffle();
//		System.out.println(mainDeck);

		// test addCard()
//		mainDeck.addCard(new CardVO("Spades", "Ace", 11));
//		System.out.println(mainDeck);
		
		// test addCards()
//		List<CardVO> cards = new ArrayList<CardVO>();
//		cards.add(new CardVO("Hearts", "King", 10));
//		cards.add(new CardVO("Spades", "King", 10));	
//		mainDeck.addCards(cards);
//		System.out.println(mainDeck);
		
		// test getCard() variants
//		CardVO testCard = mainDeck.getCard();
//		CardVO testCard = mainDeck.getCard(51);
//		CardVO aos = new CardVO("Spades", "Ace", 1);
//		mainDeck.addCard(aos);
//		System.out.println(mainDeck); // print out mainDeck with added Ace of Spades
//		CardVO testCard = mainDeck.getCard(aos);
//		System.out.println(testCard);  // print out card we're going to get
//		System.out.println(mainDeck); // print out mainDeck after we got the card
//		System.out.println(mainDeck.getInUseDeck()); // print out list of 'inUse' cards
		
		// test discard()
//		mainDeck.discard(aos);
//		System.out.println(mainDeck);
//		System.out.println(mainDeck.getDiscards());
		
		// test getDeck()
//		List<CardVO> newDeck = mainDeck.getDeck();
//		CardVO aos = new CardVO("Spades", "Ace", 1);
//		newDeck.add(aos);
//		System.out.println(newDeck);
		
		// test getRandom()
//		CardVO randCard = mainDeck.getRandom();
//		System.out.println(randCard);
		
		// test addDiscards()
//		System.out.println(mainDeck); // print initial deck
//		CardVO one = mainDeck.getCard(0); // get 3 cards (move from main deck to inUse deck)
//		CardVO two = mainDeck.getCard(0);	
//		CardVO three = mainDeck.getCard(0);		
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
	}
}
package com.nickeson.games.cardgames;

//JDK 1.8.0
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
//import com.nickeson.games.cardgames.DeckOptions;

/****************************************************************************
 * <b>Title</b>: Shoe.java <p/>
 * <b>Project</b>: cardgames <p/>
 * <b>Description: </b> A Shoe of Cards for use in card games<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Shoe {

	private List<Card> shoe = new ArrayList<Card>();
	private List<Card> inUse = new ArrayList<Card>();
	private List<Card> discards = new ArrayList<Card>();
	private int numDecks = 1;
	private static final int MAX_DECKS = 8;
	
	/**
	 * default constructor builds a 6-Deck Shoe
	 */
	public Shoe(){
		build(6);
	}
	
	/**
	 * convenience constructor to build a Shoe with a specific number of Decks
	 * @param numDecks the number of Decks in the Shoe
	 */
	public Shoe(int numDecks) {
		build(numDecks);
	}
	
	/**
	 * convenience constructor to build a Shoe with a specific number of Decks,
	 * which are built using options from a Map we pass in
	 * @param numDecks the number of Decks in the Shoe
	 * @param options the Map of options used to build the Decks in the Shoe
	 */
	public Shoe(int numDecks, Map<String, Object> options) {
		build(numDecks, options);
	}

	/**
	 * build a Shoe of Decks (1 to 8 decks allowed)
	 * @param numDecks the number of Decks in the Shoe
	 */
	private void build(int numDecks) {
		StdDeck deck = null;
		this.numDecks = numDecks;
		if (numDecks > 0 && numDecks <= MAX_DECKS) {
			for (int i = 0; i < numDecks; i++) {
				deck = new StdDeck();
				shoe.addAll(deck.getDeck());
			}
		} else {
			System.out.println("You must specify a number of Decks between 1 and "
					+ MAX_DECKS);
		}
	}

	/**
	 * build a Shoe of Decks (1 to 8 decks allowed) using Decks built with
	 * options from DeckOptions Map
	 * @param numDecks the number of Decks (with options) in the Shoe
	 * @param options the Map of options from DeckOptions to use in building the Decks in Shoe
	 */
	private void build(int numDecks, Map<String, Object> options) {
		StdDeck deck = null;
		this.numDecks = numDecks;
		if (numDecks > 0 && numDecks <= MAX_DECKS) {
			for (int i = 0; i < numDecks; i++) {
				deck = new StdDeck(options);
				shoe.addAll(deck.getDeck());
			}
		} else {
			System.out.println("You must specify a number of Decks between 1 and "
					+ MAX_DECKS);
		}
	}
	
	/**
	 * Get the next Card in the Deck (starting with top Card [0]), add card to
	 * inUse pile and remove from Deck
	 * @return the next Card from the Deck
	 */
	public Card getCard() {
		Card nextCard = null;
		if (!shoe.isEmpty()) {
			nextCard = shoe.get(0);
			shoe.remove(nextCard);
			inUse.add(nextCard);
			return nextCard;
		} else {
			System.out.println("The Shoe is empty, therefore Card is null");
			return nextCard;
		}
	}
	
	/**
	 * return the Card from Shoe at 'shoeLoc', remove Card from Shoe and add to inUse pile
	 * @param shoeLoc the location in the Shoe from which to remove the Card
	 * @return the Card from the Shoe at 'shoeLoc'
	 */
	public Card getCard(int shoeLoc) {
		Card card = null;
		if (!shoe.isEmpty()) {
			card = shoe.get(shoeLoc);
			shoe.remove(card);
			inUse.add(card);
			return card;
		} else {
			System.out.println("The Shoe is empty, therefore Card is null");
			return card;
		}
	}
	
	/**
	 * (Does not remove cards from the Shoe (or move to inUse or discards)
	 * returns the Shoe as a List of Cards
	 * @return the Shoe as a List of Cards
	 */
	public List<Card> getShoe() {
		return shoe;
	}
	
	/**
	 * return a Card from a random location in the Deck, remove from the Deck and 
	 * add to inUse pile
	 * @return a randomly drawn Card from the Deck
	 */
	public Card getRandom() {
		Card card = null;
		if (!shoe.isEmpty()) {
			Random rand = new Random();
			int rNum = rand.nextInt(shoe.size());
			card = shoe.get(rNum);
			shoe.remove(card);
			inUse.add(card);
			return card;
		} else {
			System.out.println("You cannot get a random Card from an empty Deck");
			return card;
		}
	}
	
	/**
	 * move the Card at 'shoeLoc' to the discards pile
	 * @param shoeLoc the Card at 'shoeLoc' to move to the discards pile
	 */
	public void discard(int shoeLoc) {
		discards.add(shoe.get(shoeLoc));
		shoe.remove(shoeLoc);
	}
	
	/**
	 * move all Cards from discard pile back to the Shoe
	 */
	public void addDiscards() {
		if (!discards.isEmpty()) {
			for (Card c : discards) {
				shoe.add(c);
			}
				discards.clear();
		} else {
			System.out.println("The discard pile is empty");
		}
	}

	/**
	 * add Card(s) from discards pile back to Shoe, shuffle the Shoe
	 */
	public void shuffle() {
		for (Card c : discards) {
			shoe.add(c);
		}
		discards.clear();
		Collections.shuffle(shoe);
	}
	
	/**
	 * returns the number of Decks in the Shoe
	 * @return the number of Decks in the Shoe
	 */
	public int size() {
		return numDecks;
	}
	
	/**
	 * returns the number of Cards in the Shoe
	 * @return the number of Cards in the Shoe
	 */
	public int cardCount() {
		return shoe.size();
	}
	
	/**
	 * add Card(s) from inUse and discards piles back to Shoe, shuffle the Shoe
	 */
	public void reInitialize(){
		for (Card c : inUse) {
			shoe.add(c);
		}
		for (Card c : discards) {
			shoe.add(c);
		}
		inUse.clear();
		discards.clear();
		Collections.shuffle(shoe);
	}
	
	// for testing only
//	public List<Card> getDiscards() {
//		return discards;
//	}
	
	// for testing only
//	public List<Card> getInUse() {
//		return inUse;
//	}

	/**
	 * Override toString() method to print the Shoe's String value instead of hashcode
	 */
	@Override
	public String toString() {
		String printShoe = "" + shoe;
		return printShoe;
	}
 	 
	// unit test method
//	public static void main(String[] args) {
//		DeckOptions d1 = new DeckOptions();
//		System.out.println(new Shoe(3, d1.getDeckOptions()));
//		testShoe.shuffle();
//		System.out.println(testShoe);	
//		System.out.println(testShoe.size());
//		System.out.println(testShoe.cardCount());	
//		Card c1 = testShoe.getCard();
//		Card c2 = testShoe.getCard();	
//		Card c3 = testShoe.getCard();	
//		System.out.println("Gotten Cards: " + c1 + ", " + c2 + ", " + c3);
//		System.out.println(testShoe);
//		System.out.println(testShoe.cardCount());			
//		testShoe.discard(c1);
//		testShoe.discard(c2);
//		System.out.println(testShoe);
//		System.out.println(testShoe.cardCount());			
//		System.out.println(testShoe.getRandom());
//		System.out.println(testShoe.getRandom());	
//		System.out.println(testShoe.getRandom());		
//		System.out.println(testShoe.cardCount());				
//		System.out.println(testShoe.getInUse());
//		testShoe.discard(c1);
//		System.out.println(testShoe.getDiscards());
//		testShoe.discard(c2);		
//		testShoe.discard(c2);		
//		testShoe.discard(c3);		
//		System.out.println(testShoe.getDiscards());
//		System.out.println(testShoe.getInUse());	
//		System.out.println(testShoe.cardCount());
//	}
}
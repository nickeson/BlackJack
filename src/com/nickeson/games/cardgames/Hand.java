package com.nickeson.games.cardgames;

import java.util.ArrayList;
import java.util.List;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Hand.java <p/>
 * <b>Project</b>: Card Games <p/>
 * <b>Description: </b> A Player's collection of Playing Cards<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Hand {

	private List<Card> hand = null;
	
	/**
	 * unknown number of cards in a Hand (varies by game), so default to blank
	 */
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	/**
	 * convenience constructor allows us to pass an ArrayList of Cards
	 * @param hand an ArrayList of Cards passed to build Hand
	 */
	public Hand(ArrayList<Card> hand) {
		this.hand = new ArrayList<Card>(hand);
	}

	/**
	 * Add a specific Card to the Hand
	 * @param c the Card to add to the Hand
	 */
	public void addCard(Card c) {
		hand.add(c);
	}
	
	/**
	 * Add multiple Cards to the Hand
	 * @param cards the Cards to add to the Hand
	 */
	public void addCard(ArrayList<Card> cards) {
		for (Card c : cards) {
			hand.add(c);
		}
	}
	
	/**
	 * Remove a specific Card from the Hand
	 * @param c the Card to remove from the Hand
	 */
	public void discard(Card c) {
		hand.remove(c);
	}
	
	/**
	 * Remove multiple Cards from the Hand
	 * @param c an ArrayList of Cards to remove from the Hand
	 */
	public void discard(ArrayList<Card> cards) {
		for (Card c : cards) {
			hand.remove(c);
		}
	}
	
	/**
	 * @param c the Card to check if it exists in Hand
	 * @return a boolean result of whether or not Card exists in Hand
	 */
	public boolean inHand(Card c) {
		boolean result = false;
		String c1String = c.toString();
		String c2String = null;
		
		if (hand.contains(c)) { // compare Card objects directly
			result = true;
		} else { 				// compare Cards by string values
			for (Card card : hand) {
					c2String = card.toString();
					result = c1String.equalsIgnoreCase(c2String);
					if (result == true) {
						break;
					}
			}
		} return result;
	}
	
	/**
	 * Sorts the cards in the hand so that cards of the same suit are grouped
	 * together, and within a suit the cards are sorted by value.
	 */
	public void sortBySuit() {
	   ArrayList<Card> tmpHand = new ArrayList<>();
	   while (hand.size() > 0) {
	      int pos = 0;  // first card's position
	      Card c = (Card)hand.get(0);  // first card
	      for (int i = 1; i < hand.size(); i++) {
	         Card c1 = (Card)hand.get(i);
	         if ((c1.getSuit().compareToIgnoreCase(c.getSuit()) < 0) 
	        		 || ((c1.getSuit() == c.getSuit()) 
					 && (c1.getValue() < c.getValue())))
	         {
	             pos = i;
	             c = c1;
	         }
	      }
	      hand.remove(pos);
	      tmpHand.add(c);
	   }
	   hand = tmpHand;
	}
	
	/**
	 * Sorts the cards in the hand so that cards of the same value are grouped
	 * together.  Cards with the same value are sorted by suit.
	 */
	public void sortByValue() {
	   ArrayList<Card> tmpHand = new ArrayList<>();
	   while (hand.size() > 0) {
	      int pos = 0;  // first card's position
	      Card c = (Card)hand.get(0);  // first card
	      for (int i = 1; i < hand.size(); i++) {
	         Card c1 = (Card)hand.get(i);
	         if ( c1.getValue() < c.getValue() ||
	                 ((c1.getValue() == c.getValue()) && 
					 (c1.getSuit().compareToIgnoreCase(c.getSuit()) < 0)))
	         {
	             pos = i;
	             c = c1;
	         }
	      }
	      hand.remove(pos);
	      tmpHand.add(c);
	   }
	   hand = tmpHand;
	}
	
	/**
	 * Remove all Cards from the hand instance
	 */
	public void clearHand() {
		hand.clear();
	}
	
	/**
	 * @return the number of Cards in the Hand
	 */
	public int size() {
		int result = 0;
		result = hand.size();
		return result;
	}
	
	/**
	 * @return the hand as a List of Cards
	 */
	public List<Card> getHand() {
		return hand;
	}
	
	/**
	 * print value of hand as String instead of hashcode
	 */
	@Override
	public String toString() {
		String result = "" + hand;
		return result;
	}
	
	// unit test method
//	public static void main(String[] args) {
//		Hand hand = new Hand();
//		StdDeck stdDeck = new StdDeck(new DeckOptions().getDeckOptions());
//		stdDeck.shuffle();
		
		// add all cards in Deck to hand, casting List<Card> from Deck to ArrayList<Card> for hand
//		hand.addCard((ArrayList<Card>)stdDeck.getDeck());

//		System.out.println("Hand before sorting: " + hand);
//		hand.sortBySuit();
//		hand.sortByValue();
//		System.out.println("Hand after sorting: " + hand);	
		
		// testing inHand()
//		System.out.println(hand.inHand(new Card("Diamonds", "3", 1)));
//	}
}
package com.nickeson.game.cardgame.blackjack;

import java.util.ArrayList;
import java.util.List;
import com.nickeson.game.cardgame.Card;
//import com.nickeson.game.cardgame.StdDeck;

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

	private List<Card> hand = new ArrayList<Card>();
	
	/**
	 * default constructor builds empty Hand
	 */
	public Hand() {
	}
	
	/**
	 * convenience constructor - pass a List of Cards to build Hand
	 * @param hand a List of Cards passed to build Hand
	 */
	public Hand(List<Card> hand) {
		this.hand = hand;
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
	public void addCard(List<Card> cards) {
		for (Card c : cards) {
			hand.add(c);
		}
	}
	
	/**
	 * Remove a specific Card from the Hand
	 * @param c the Card to remove from the Hand
	 */
	public void removeCard(Card c) {
		String c1 = c.toString();
		String c2 = null;
		for (Card card : hand) {
			c2 = card.toString();
			if (hand.contains(c) || (c1.equalsIgnoreCase(c2))) {
				c = card;
				hand.remove(c);
				break;
			}
		}
	}
	
	/**
	 * Remove multiple Cards from the Hand
	 * @param cards a List of Cards to remove from the Hand
	 */
	public void removeCard(List<Card> cards) {
		String c2 = null;
		for (Card c : cards) {
		String c1 = c.toString();
			for (Card card : hand) {
				c2 = card.toString();
				if ((c1.equalsIgnoreCase(c2))) {
					hand.remove(card);
					break;
				}
			}
		}
	}
	
	/**
	 * returns a boolean result of whether or not Card exists in Hand
	 * @param c the Card to check if it exists in Hand
	 * @return a boolean result of whether or not Card exists in Hand
	 */
	public boolean inHand(Card c) {
		boolean result = false;
		String c1String = c.toString();
		String c2String = null;
		
		if (hand.contains(c)) {
			result = true;
		} else {
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
	 * returns the Hand as a List of Cards
	 * @return the Hand as a List of Cards
	 */
	public List<Card> getHand() {
		return hand;
	}
	
	/**
	 * Sorts the cards in the Hand so that cards of the same suit are grouped
	 * together, and within a suit the cards are sorted by value ascending.
	 */
	public void sortBySuit() {
	   List<Card> tmpHand = new ArrayList<>();
	   while (hand.size() > 0) {
	      int pos = 0;  // first card's position
	      Card c = (Card)hand.get(0);  // first card
	      for (int i = 1; i < hand.size(); i++) {
	         Card c1 = (Card)hand.get(i);
	         if ((c1.getSuit().compareToIgnoreCase(c.getSuit()) > 0) 
	        		 || ((c1.getSuit() == c.getSuit()) 
					 && (c1.getIndexValue() < c.getIndexValue())))
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
	 * Sorts the cards in the Hand so that cards of the same indexValue are
	 * grouped together, and within an indexValue the Cards are sorted by suit 
	 * - indexValues proceed in an ascending fashion
	 */
	public void sortByIndexValue() {
	   List<Card> tmpHand = new ArrayList<>();
	   while (hand.size() > 0) {
	      int pos = 0;  // first card's position
	      Card c = (Card)hand.get(0);  // first card
	      for (int i = 1; i < hand.size(); i++) {
	         Card c1 = (Card)hand.get(i);
	         if (c1.getIndexValue() < c.getIndexValue() ||
	                 ((c1.getIndexValue() == c.getIndexValue()) && 
					 (c1.getSuit().compareToIgnoreCase(c.getSuit()) > 0)))
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
	 * calculate the Blackjack Hand's point value
	 * @param the boolean value to determine if Aces should be counted as 
	 * 1(true) or 11(false)
	 * @return the Blackjack Hand's point value
	 */
	public int calcValue(boolean isSoft) {
		int result = 0;
		for (Card c : hand) {
			switch (c.getIndexValue()) { // Blackjack Card indexValues run from 1 to 13
				case 1: // Ace Card's indexValue is 1
						if (isSoft) {
							result += 1; // Ace's Blackjack point value for 'Soft' Hand
						} else {
							result += 11; // Ace's Blackjack point value for 'Hard' Hand 
						}
						break;
				case 11:
						result += 10; // Jack's Blackjack point value is 10
						break;
				case 12:
						result += 10; // Queen's Blackjack point value is 10 
						break;
				case 13:
						result += 10; // King's Blackjack point value is 10 
						break;
				default: result += c.getIndexValue(); // all non-face Cards
			}
		}
		return result;
	}
	
	/**
	 * Remove all Cards from the Hand instance
	 */
	public void clear() {
		hand.clear();
	}
	
	/**
	 * returns the number of Cards in the Hand
	 * @return the number of Cards in the Hand
	 */
	public int size() {
		return hand.size();
	}
	
	/**
	 * print value of Hand as String instead of hashcode
	 */
	@Override
	public String toString() {
		String result = "" + hand;
		return result;
	}
	
	// unit test method
//	public static void main(String[] args) {
//		Hand hand = new Hand();
//		StdDeck stdDeck = new StdDeck();
//		System.out.println("StdDeck: " + stdDeck);
//		stdDeck.shuffle();
		
		// add all cards in DeckIntfc to hand, casting List<Card> from DeckIntfc to ArrayList<Card> for hand
//		hand.addCard((ArrayList<Card>)stdDeck.getDeck());
//		hand.addCard(stdDeck.getCard());
//		hand.addCard(stdDeck.getCard());	
//		hand.addCard(stdDeck.getCard());		
//		hand.addCard(stdDeck.getCard());	
//		hand.addCard(stdDeck.getCard());	
		
//		System.out.println(hand);
//		System.out.println(stdDeck);
//		System.out.println(hand.calcValue(true));
//		System.out.println(hand.calcValue(false));
		
//		System.out.println("Hand before sorting: " + hand);
//		hand.sortBySuit();
//		hand.sortByIndexValue();
//		System.out.println("Hand after sorting: " + hand);	
		
		// testing inHand()
//		System.out.println(hand.inHand(new Card("Clubs", "3", 3)));

		// testing removeCard()
//		Card testCard2 = new Card("Clubs", "Ace", 1);
//		Card testCard3 = new Card("Clubs", "Ace", 1);	
//		Card testCard4 = new Card("Spades1", "Ace", 1);	
//		List<Card> testArrayList = new ArrayList<Card>();
//		testArrayList.add(testCard2);
//		testArrayList.add(testCard3);		
//		testArrayList.add(testCard4);
//		System.out.println("Hand before removeCard: " + hand);
//		System.out.println(testArrayList);
//		hand.removeCard(testArrayList);
//		hand.removeCard(testCard2);
//		hand.removeCard(testCard2);
//		System.out.println(hand);
//		System.out.println(hand.size());

		// testing getCard()
//		Card testCard5 = new Card("Clubs", "Ace", 1);
//		System.out.println(hand.getCard(testCard5));
//	}
}
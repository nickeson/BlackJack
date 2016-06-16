package com.nickeson.game.cardgame.blackjack;

//JDK 1.8.0
import java.util.List;
import java.util.ArrayList;
import com.nickeson.game.cardgame.Card;

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
					 && (c1.getIndexValue() > c.getIndexValue())))
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
	         if (c1.getIndexValue() > c.getIndexValue() ||
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
	 * calculate the Blackjack Hand's point value (uses Ace as point value of 1
	 *  to avoid 'Busting', when possible
	 * @return the Blackjack Hand's point value (uses Ace as point vlaue of 1
	 *  to avoid 'Busting', when possible
	 */
	public int calcValue() {
		int softResult = 0;
		int hardResult = 0;
		int result = 0;
		int numAces = 0;
		
		sortByIndexValue(); // sort cards first so Aces get processed last
		for (Card c : hand) {
			switch (c.getIndexValue()) {
				case 1: 
						softResult += 1;
						if (numAces == 0) {
							hardResult += 11;
							if (hardResult == 21) {
								break;
							} else {
								if (hardResult > 21) hardResult = softResult; 
							}
						} else {
							if (numAces > 0) {
								hardResult += 1;
							}
						}
						numAces++;
						break;
				case 11:
						softResult += 10; // Jack
						hardResult += 10;
						break;
				case 12:
						softResult += 10; // Queen
						hardResult += 10;
						break;
				case 13:
						softResult += 10; // King
						hardResult += 10;
						break;
				default: 
						softResult += c.getIndexValue(); // all non-face Cards
						hardResult += c.getIndexValue();
			}
			if (hardResult == 21 || softResult == 21) {
				result = 21;
			} else {
				if ((hardResult > 21) && (softResult < 21)) {
					result = softResult;
				} else {
					result = hardResult;
				}
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
	 * @return the String value of the Hand
	 */
	@Override
	public String toString() {
		String result = "" + hand;
		return result;
	}
}
package com.nickeson.games.cardgames;

import java.util.ArrayList;
import java.util.List;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Hand.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A Player's Collection of Playing Cards<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Hand<T extends Card> {
	List<Card> hand;
	int score;
	
	/**
	 * we don't know number of cards in a hand (varies by game) so default to a
	 * blank hand
	 */
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the hand
	 */
	public List<Card> getHand() {
		return hand;
	}

	/**
	 * setup a hand of indeterminate size by assigning a List<Card> object
	 * @param hand
	 */
	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	/**
	 * Add a specific Card to the hand instance
	 * @param c
	 */
	public void addCard(Card c) {
		hand.add(c);
	}
	
	/**
	 * Remove a specific Card from the hand instance
	 * @param c
	 */
	public void removeCard(Card c) {
		hand.remove(c);
	}
	
	/**
	 * Remove all cards from the hand instance
	 */
	public void clearHand() {
		hand.clear();
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
//		Hand<Card> hand = new Hand<>();
//		hand.addCard(new Card("", "Joker", true, true));
//		hand.addCard(new Card("Hearts", "Ace", false, false));	
//		System.out.println(hand);
//	}
}
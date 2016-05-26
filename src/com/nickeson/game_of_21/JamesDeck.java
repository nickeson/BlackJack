package com.nickeson.game_of_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/********************************************************************
 * <b>Title: </b>JamesDeck.java<br/>
 * <b>Description: </b><<<< Some Desc Goes Here >>>><br/>
 * <b>Copyright: </b>Copyright (c) 2016<br/>
 * <b>Company: </b>Silicon Mountain Technologies
 * @author james
 * @version 3.x
 * @since May 26, 2016
 * Last Updated:
 * 	
 *******************************************************************/
public class JamesDeck {
	
	private List<JamesCard> deck = new ArrayList<>();
	private List<JamesCard> usedCards = new ArrayList<>();
	private List<JamesCard> inUse = new ArrayList<>();
	
	public static final String[] suits = {"hearts", "diamonds", "spades", "clubs" };
	
	/**
	 * Pass this option as true or false to include jokers
	 */
	public static final String OPTION_NUMBER_JOKERS = "numberJokers";
	
	/**
	 * 
	 */
	public JamesDeck() {
		createDeck(0);
	}
	
	/**
	 * 
	 */
	public JamesDeck(Map<String, Object> options) {
		int numJokers = 0;
		if (options.containsKey(OPTION_NUMBER_JOKERS) && options.get(OPTION_NUMBER_JOKERS) != null) 
			numJokers = Integer.valueOf(options.get(OPTION_NUMBER_JOKERS) + "");
		
		createDeck(numJokers);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JamesDeck mainDeck = new JamesDeck();
		mainDeck.addCards(new JamesDeck().getDeck());
		mainDeck.addCards(new JamesDeck().getDeck());
		mainDeck.addCards(new JamesDeck().getDeck());
		mainDeck.shuffle();
		System.out.println("Deck Size: " + mainDeck.getDeck().size());
	}
	
	
	protected void createDeck(int numJokers) {
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
					default:
						rank = (j+1) + "";
				}
				
				deck.add(new JamesCard(suits[i], rank, j+1));
			}
		}
		
		for (int i=0; i < numJokers; i++) {
			deck.add(new JamesCard(suits[i],"Joker: " + i ,0));
		}
	}
	
	
	public void reset() {
		deck.addAll(usedCards);
		deck.addAll(inUse);
		
		usedCards.clear();
		inUse.clear();
	}
	
	public JamesCard getNextCard() {
		JamesCard card = deck.get(0);
		deck.remove(0);
		inUse.add(card);
		return card;
	}
	
	
	public void returnCard(JamesCard card) {
		usedCards.add(card);
		
		// Loop and find card in inUse collection and remove
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	
	public void addCard(JamesCard card) {
		deck.add(card);
	}
	
	
	public void addCards(List<JamesCard> cards) {
		deck.addAll(cards);
	}

	
	public List<JamesCard> getDeck() {
		return deck;
	}
}


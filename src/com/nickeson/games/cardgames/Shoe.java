package com.nickeson.games.cardgames;

//JDK 1.8.0
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nickeson.games.cardgames.Deck;
import com.nickeson.games.cardgames.CardVO;

/****************************************************************************
 * <b>Title</b>: Shoe.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A Shoe of Standard PlayingCards of specified number of
 * Decks, with and without Jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Shoe implements Deck {
	private List<CardVO> shoe = new ArrayList<CardVO>();
//	private static String[] cardSuits = new String[4];	 
//	private static String[] cardRanks = new String[13];
//	private static String[] cardValues = new String[13];
//	private int numOfDecks = 1;
//	private static final int MAX_DECKS = 8;
	
	/**
	 * constructor to build a single-Deck Shoe of Standard Playing Cards with 
	 * no Jokers if no arg is passed 
	 */
	public Shoe(){
		build();
	}
	
	/**
	 * build a StdShoe of cards with suits and values defined in
	 * StandardCardSuits.java and StandardCardValues.java
	 */
	public void build() {
	}
	
	/**
	 * add a face down Joker to StdShoe with custom Joker name (no suit)
	 */
	public void addCard() {
	}
	
	public void discard() {
	}
	
	public void reset(){
	}
	/**
	 * a method to shuffle this StdShoe
	 */
	public void shuffle() {
		Collections.shuffle(shoe);
	}
	
	public CardVO getTopCard(){
		return null;
	}
	/**
	 * @return the List of Playing Cards in the Shoe (a combo Deck)
	 */
	public List<CardVO> getDeck(){
        return shoe;
    }
	
	/**
	 * print Shoe String values instead of hashcode
	 */
	@Override
	public String toString() {
		String printDeck = "" + shoe;
		return printDeck;
	}
 	 
	// unit test method
	public static void main(String[] args) {
	}
}
package com.nickeson.game_of_21;

//JDK 1.8.0
import java.util.ArrayList;

/****************************************************************************
 * <b>Title</b>: StandardDeck.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A standard 52 card deck + 2 jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class StandardDeck implements Deck {
	boolean jokers;
	ArrayList<Card> myDeck = new ArrayList<>(54);
	
	Card twoOfClubs = new Card("2", "Clubs");
	Card jokerOfClubs = new Card("Joker", "Clubs");

	// default no-arg constructor builds a full deck with Jokers
	public StandardDeck() {
		buildStdDeck();
	}
	
	// convenience constructor builds a full deck with or without Jokers
	public StandardDeck(boolean jokers) {
		buildNoJokerDeck();
	}
	
	public void buildStdDeck() {
		myDeck.add(twoOfClubs);
		myDeck.add(jokerOfClubs);		
	}
	
	public void buildNoJokerDeck() {
		if (jokers) {
			buildStdDeck();
		} else {
			buildStdDeck();
			myDeck.remove(jokerOfClubs);
		}
	}

	public static void main(String[] args) {
		StandardDeck newDeck = new StandardDeck(true);
		System.out.println(newDeck);
	}
}
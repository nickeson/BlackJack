package com.nickeson.games.cardgames.blackjack;

//JDK 1.8.0
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.nickeson.games.cardgames.PlayingCard;
import com.nickeson.games.cardgames.Deck;

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

public class Shoe implements Deck<PlayingCard> {
	private List<PlayingCard> shoe = new ArrayList<PlayingCard>();
	// initialize empty string arrays for card suits & values to correct sizes
	private static String[] cardSuits = new String[StdPlayingCardSuits.values().length];	 
	private static String[] cardValues = new String[StdPlayingCardValues.values().length];
	// setup location index for Joker
	private static int jokerIndex = (StdPlayingCardValues.values().length -1);
	private int numOfDecks;
	private static final int MAX_DECKS = 8;
	
	/**
	 * constructor to build a single-Deck Shoe of Standard Playing Cards with 
	 * no Jokers if no arg is passed 
	 */
	public Shoe(){
		buildDeck();
	}
	
	/**
	 * constructor to build a single-deck Shoe of Standard Playing Cards with or
	 * without jokers
	 * @param numOfJokers
	 */
	public Shoe(int numOfJokers) {
		buildDeck();
		for (int j = 0; j < numOfJokers; j++) {
			addJoker();
		}
	}
	
	/**
	 * constructor to build a Shoe of Standard Playing Cards of a specific 
	 * number of decks, with or without jokers
	 * @param numOfJokers
	 * @param numOfDecks
	 */
	public Shoe(int numOfJokers, int numOfDecks) {
		// minimum number of Decks is 1
		if (numOfDecks < 1) {
			System.out.println("Minimum Number of Decks is 1");
		}
		if (numOfDecks <= MAX_DECKS) {
			for (int i = 1; i <= numOfDecks; i++) {
				buildDeck();
				for (int j = 0; j < numOfJokers; j++) {
					addJoker();
				}
			}
		} else { 
			System.out.println("Maximum number of Decks in Shoe is " + MAX_DECKS);
		}
	}
	
	/**
	 * build a StdShoe of cards with suits and values defined in
	 * StandardCardSuits.java and StandardCardValues.java
	 */
	public void buildDeck() {
		
		// fill String Arrays with Enum values from StdCardSuits.values()
		for (StdPlayingCardSuits itr : StdPlayingCardSuits.values()) {
			int ord = itr.ordinal();
			cardSuits[ord] = "" + itr;			
		}
				
		for (StdPlayingCardValues ir : StdPlayingCardValues.values()) {
			int odl = ir.ordinal();
			cardValues[odl] = "" + ir;				
		}	
		
		/* loop through the suits and values string arrays, building new cards
		 * for each value of each suit, all face down
		 */
		for (String ol : cardSuits)
		{
			for (String il : cardValues)
			{
				if (!il.equals(cardValues[jokerIndex])) {
					// params = (suit, value, isJoker, isFaceUp)
					shoe.add(new PlayingCard(ol,il,false,false));
				}
			}
		}
	}
	
	/**
	 * @return the custom Joker name
	 */
	public static String getJokerName() {
		String jokerName = cardValues[jokerIndex];
		return jokerName;
	}
	
	/**
	 * add a face down Joker to StdShoe with custom Joker name (no suit)
	 */
	public void addJoker() {
		String jokerName = getJokerName();
		// params = (suit, value, isJoker, isFaceUp)
		shoe.add(new PlayingCard("",jokerName,true,false));
	}
	
	/**
	 * a method to shuffle this StdShoe
	 */
	public void shuffleDeck() {
		Collections.shuffle(shoe);
	}
	
	/**
	 * @return the numOfDecks in this StdShoe
	 */
	public int getNumOfDecks() {
		return numOfDecks;
	}

	/**
	 * @param numOfDecks the numOfDecks to set for StdShoe
	 */
	public void setNumOfDecks(int numOfDecks) {
		this.numOfDecks = numOfDecks;
	}
	
	/**
	 * @return the List of Playing Cards in the Shoe (a combo Deck)
	 */
	public List<PlayingCard> getCards(){
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
		Shoe testShoe = new Shoe(1, 2);		
		System.out.println("2 Deck Shoe with 1 Joker per Deck: " + testShoe);		
		Shoe myShoe = new Shoe(2);
		System.out.println("Shoe with 1 Joker per Deck: " + myShoe);
		
		Shoe my2ndShoe = new Shoe(0);	
		my2ndShoe.shuffleDeck();
		System.out.println("Shuffled Shoe without Jokers: " + my2ndShoe);	
		
		Shoe my3rdShoe = new Shoe(2, 1);
		my3rdShoe.shuffleDeck();
		System.out.println("Shuffled Shoe with Jokers: " + my3rdShoe);
		}
}
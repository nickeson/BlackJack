package com.nickeson.game.cardgame.blackjack;

import java.util.Map;
import java.util.HashMap;
import com.nickeson.game.cardgame.DeckIntfc;
import com.nickeson.game.cardgame.Shoe;
import com.nickeson.game.cardgame.StdDeck;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Initializer.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> Blackjack setup routines<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public class Initializer {

	private Shoe gameShoe = null;
	private int shoeSize;
	private int numPlayers;
	private int winLimit;
	private int minBet;
	private int maxBet;
	private int shuffleMarker;
	private Map<String, Object> acctBalances = null; // this will serve as Bank for now

	/**
	 * default constructor builds shoe of size 'shoeSize' and then sets up Player(s)
	 */
	public Initializer() {
		runConfigurator();
		buildShoe();
		setupPlayers();
	}

	private void runConfigurator() {
		shoeSize = 6; // modify these to pull their values from config file
		winLimit = 500;
		minBet = 5;
		maxBet = 100;
		shuffleMarker = 220;
	}
	
	private void setupPlayers() {
		numPlayers = 1; // modify this to pull from command line / user input
	}

	// modify this to pull Deck type as an option, number of jokers as an option, number of Decks
	// as an option from config file
	/**
	 * builds a Shoe of Decks of size 'shoeSize', with type specified by HashMap options
	 */
	private void buildShoe() {
		Map<String, Object> deckOpt = new HashMap<>();
		deckOpt.put("typeOfDeck", (new StdDeck())); // modify to pull values from config file
		deckOpt.put("stdDeckNumJoker", (new StdDeck(deckOpt))); // modify to pull values from config file
		StdDeck addlDeck = new StdDeck(deckOpt); // modify to pull values from config file
		gameShoe = new Shoe(deckOpt); // builds first Deck of type specified in deckOpt
		
		// add additional decks (one deck already exists)
		for (int i = 1; i < shoeSize; i++) {
			gameShoe.addDeck(addlDeck);
		}
		gameShoe.getShoe().shuffle();
	}
	
	/**
	 * return the gameShoe as DeckIntfc object
	 * @return the gameShoe as DeckIntfc object
	 */
	public DeckIntfc getGameShoe() {
		return gameShoe.getShoe();
	}
	
	/**
	 * returns the number of Players in the game
	 * @return the number of Players in the game
	 */
	public int getNumPlayers() {
		return numPlayers;
	}

	/**
	 * @return the winLimit
	 */
	public int getWinLimit() {
		return winLimit;
	}

	/**
	 * @return the minBet
	 */
	public int getMinBet() {
		return minBet;
	}

	/**
	 * @return the maxBet
	 */
	public int getMaxBet() {
		return maxBet;
	}

	/**
	 * @return the shuffleMarker
	 */
	public int getShuffleMarker() {
		return shuffleMarker;
	}

	/**
	 * @return the acctBalances
	 */
	public Map<String, Object> getAcctBalances() {
		return acctBalances;
	}

//	public static void main(String[] args) {
		// setup maps for options
//	}
}
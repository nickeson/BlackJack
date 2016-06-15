package com.nickeson.game.cardgame.blackjack;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
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
	int shoeSize;
	private List<Player> playerArray = new ArrayList<>();
	private Map<String, Object> acctBalanceMap = new HashMap<>();
	private	Map<String, Object> configParamsMap = new HashMap<>();

	/**
	 * default constructor builds shoe of size 'shoeSize' and then sets up Player(s)
	 */
	public Initializer() {
		runConfigurator();
		setupShoe();
		setupPlayers();
	}

	// modify to allow pulling values from config file
	protected void runConfigurator() {
		// setup config params
		shoeSize = 6;
		configParamsMap.put("winLimit", 500);
		configParamsMap.put("minBet",  5);
		configParamsMap.put("maxBet",  100);
		configParamsMap.put("shuffleMarker",  220);
	}
	
	// needs modification to allow pulling number of players from command line & acctBalances from config file
	private void setupPlayers() {
		Player player = new Player("Player", "1");
//		Player player2 = new Player("Player", "2");	
		String playerName = player.getFirstName() + " " + player.getLastName();
//		String playerName2 = player2.getFirstName() + " " + player2.getLastName();	
		playerArray.add(player);
//		playerArray.add(player2);

		Player dealer = new BlackjackDealer(getGameShoe());
		String dealerName = dealer.toString();
		playerArray.add(dealer);

		acctBalanceMap.put(playerName, 200);
//		acctBalanceMap.put(playerName2,  200);
		acctBalanceMap.put(dealerName, "Balance N/A");
		
//		System.out.println("Player Array: " + playerArray);
	}
	
	// modify this to pull Deck type as an option, number of jokers as an option, number of Decks
	// as an option from config file
	/**
	 * builds a Shoe of Decks of size 'shoeSize', with type specified by HashMap options
	 */
	private void setupShoe() {
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
	public List<Player> getPlayers() {
		return playerArray;
	}

	/**
	 * returns the acctBalanceMap
	 * @return the acctBalanceMap
	 */
	public Map<String, Object> getAcctBalanceMap() {
		return acctBalanceMap;
	}
	
	/**
	 * returns the configParamsMap
	 * @return the configParamsMap
	 */
	public Map<String, Object> getConfig() {
		return configParamsMap;
	}

//	public static void main(String[] args) {
		// setup maps for options
//	}
}

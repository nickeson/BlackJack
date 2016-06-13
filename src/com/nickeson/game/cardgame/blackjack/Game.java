package com.nickeson.game.cardgame.blackjack;

import java.util.Map;
import com.nickeson.game.cardgame.DeckIntfc;
//import java.util.List;
//import com.nickeson.game.cardgame.Card;
//import com.nickeson.game.cardgame.Shoe;
//import com.nickeson.game.cardgame.StdDeck;
//import com.nickeson.game.cardgame.TestDeck;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Game.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> Blackjack game logic<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public class Game {
	
	/**
	 * default constructor calls initializer to get all game params
	 */
	public Game() {
		Initializer init = new Initializer();
		DeckIntfc gameDeck = init.getGameShoe();
		int numPlayers = init.getNumPlayers();
		int winLimit = init.getWinLimit();
		int minBet = init.getMinBet();
		int maxBet = init.getMaxBet();
		int shuffleMarker = init.getShuffleMarker();
		Map<String, Object> acctBalances = init.getAcctBalances();
//		System.out.println(gameDeck);
//		System.out.println(gameDeck.size());
//		System.out.println(numPlayers);
//		System.out.println(winLimit);
//		System.out.println(minBet);
//		System.out.println(maxBet);
//		System.out.println(shuffleMarker);
//		System.out.println(acctBalances);
	}
	
	private void runGameLoop() {
	}

	private void getPlayerBet() {
	}
	
	private void updateBank(int amount) {
	}
	
	/**
	 * display any game closing messages to the view
	 */
	private void end() {
		System.out.println("Thanks for Playing!");
	}
	
	// contains all main game logic
	public static void main(String[] args) {
		Game blackjack = new Game();
		blackjack.runGameLoop();
		blackjack.getPlayerBet();
		blackjack.updateBank(50);
		blackjack.end();
	}
}
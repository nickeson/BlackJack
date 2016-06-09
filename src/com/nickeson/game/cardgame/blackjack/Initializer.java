package com.nickeson.game.cardgame.blackjack;

import java.util.Map;

import com.nickeson.game.cardgame.StdDeck;

import java.util.HashMap;

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

	Map<String, Object> deckOpt = new HashMap<String, Object>();

	public Initializer() {
	}

	public void runInitializer() {
	}

	public void runConfigurator() {
	}
	
	public void setupPlayers() {
	}

	public void buildShoe() {
		deckOpt.put("stdDeckNumJokers", new Integer(2));
		StdDeck gameDeck = new StdDeck(deckOpt);
	}

	// for testing only
	public Map<String, Object> getDeckOpt() {
		return deckOpt;
	}

	public static void main(String[] args) {
		Initializer init = new Initializer();
		init.runInitializer();
	}
}
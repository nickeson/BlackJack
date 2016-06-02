package com.nickeson.games.cardgames;

import java.util.Map;
import java.util.HashMap;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: DeckOptionsMap.java <p/>
 * <b>Project</b>: Card Games <p/>
 * <b>Description: </b> A map of options for building a Deck of Playing Cards<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 1, 2016<p/>
 * updates:
 ****************************************************************************/

public class DeckOptions {

	public static Map<String, Object> deckOpt = new HashMap<String, Object>();

	/**
	 * default constructor defines Deck options
	 */
	public DeckOptions() {
		// a standard Deck has 2 Jokers
		deckOpt.put("stdDeckNumJokers", new Integer(2));
	}
	
	/**
	 * @return the options from DeckOptions as a Map object
	 */
	public static Map<String, Object> getDeckOptions() {
		return deckOpt;
	}
	
	// unit test
//	public static void main(String[] args) {
//	}
}
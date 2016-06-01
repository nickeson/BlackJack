package com.nickeson.games.cardgames;

import java.util.Map;
import java.util.HashMap;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: DeckOptionsMap.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A map of options for building a cardgame Deck<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 1, 2016<p/>
 * updates:
 ****************************************************************************/

public class DeckOptionsVO {
	public static final Map<String, Object> deckOpt = new HashMap<String, Object>();

	public DeckOptionsVO() {
		// a standard deck has 2 Jokers
		deckOpt.put("stdDeckNumJokers", new Integer(2));
	}
	
	/**
	 * @return the options from the DeckOptionsMapVO
	 */
	public Map<String, Object> getDeckOptions() {
		return deckOpt;
	}
	
	// unit test
	public static void main(String[] args) {
	}
}
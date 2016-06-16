package com.nickeson.game.cardgame;

//JDK 1.8.0
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: Shoe.java <p/>
 * <b>Project</b>: cardgames <p/>
 * <b>Description: </b> A Shoe of Cards for use in card games<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Shoe {
	private DeckIntfc shoe = null;
	public static final String DECKTYPE = "typeOfDeck";
	
	/**
	 * default constructor builds a single Deck Shoe using Decks of type 'deckType'
	 * @param options the Map of options used to build the Shoe
	 */
	public Shoe(Map<String, Object> options) {
		if (options.containsKey(DECKTYPE) && options.get(DECKTYPE) != null) {
			shoe = (DeckIntfc) (options.get(DECKTYPE));
		}
	}
	
	/**
	 * returns the Shoe as a DeckIntfc object
	 * @return the Shoe as a DeckIntfc object
	 */
	public DeckIntfc getShoe() {
		return shoe;
	}

	/**
	 * add a Deck of Cards to the Shoe
	 * @param deck the Deck of Cards to add to the Shoe
	 */
	public void addDeck(DeckIntfc deck) {
		shoe.addCards(deck.getDeck());
	}

	/**
	 * returns the number of Cards in the Shoe
	 * @return the number of Cards in the Shoe
	 */
	public int size() {
		if (shoe == null) {
			return 0;
		} else {
			return shoe.size();
		}
	}
	
	/**
	 * Override toString() method to print the Shoe's String value instead of hashcode
	 * @return the String value of the Shoe
	 */
	@Override
	public String toString() {
		return "" + shoe;
	}
}
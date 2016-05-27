package com.nickeson.games.cardgames.blackjack;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: StdPlayingCardValues.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> Enums define values for a standard deck of cards<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 18, 2016<p/>
 * updates:
 ****************************************************************************/

public enum StdPlayingCardValues {
	
	ACE("Ace"), KING("King"), QUEEN("Queen"), JACK("Jack"), TEN("10"), NINE("9"),
		EIGHT("8"), SEVEN("7"), SIX("6"), FIVE("5"), FOUR("4"), THREE("3"),
		TWO("2"), JOKER("Joker");
	
	private final String value;
	
	/**
	 * the Standard Playing Card's value(s)
	 * @param value
	 */
	private StdPlayingCardValues(String value) {
		this.value = value;
	}
	
	// provides 'values' instead of 'keys'
	@Override
	public String toString(){
		return value;
	}
}
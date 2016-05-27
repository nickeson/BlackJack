package com.nickeson.games.cardgames.blackjack;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: CstmCardSuits1.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> Enums define values for a custom deck of cards<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 18, 2016<p/>
 * updates:
 ****************************************************************************/

public enum CstmPlayingCardValues1 {
	
	ACE("Whiz"), KING("Caesar"), QUEEN("RuPaul"), JACK("Nicholson"), 
	TEN("Bo Derek"), NINE("Beatles"), EIGHT("Crazy"), SEVEN("Lucky"), 
	SIX("Six Shooter"), FIVE("High Five"), FOUR("Four on the Floor"),
	THREE("Trinity"), TWO("Deuce"), JOKER("Colbert");
	
	private final String value;
	
	/**
	 * the Custom Playing Card's value(s)
	 * @param value
	 */
	private CstmPlayingCardValues1(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	// provides 'values' instead of 'keys'
	@Override
	public String toString(){
		return getValue();
	}
}
package com.nickeson.games.cardgames.blackjack;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: CstmPlayingCardSuits1.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> Enums define suits for a custom deck of cards<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 18, 2016<p/>
 * updates:
 ****************************************************************************/

public enum CstmPlayingCardSuits1 {
	
	HEARTS("BlackHearts"), DIAMONDS("BloodDiamonds"), 
	SPADES("GardenSpades"), CLUBS("BookClubs");
	
	private final String value;
	
	/**
	 * the Custom Playing Card's suit(s)
	 * @param value
	 */
	private CstmPlayingCardSuits1(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	// provides 'values' instead of 'keys' for ENUM constants
	@Override
	public String toString(){
		return getValue();
	}
}
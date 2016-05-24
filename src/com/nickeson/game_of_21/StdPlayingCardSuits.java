package com.nickeson.game_of_21;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: StdPlayingCardSuits.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> Enums define suits for a standard deck of cards<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 18, 2016<p/>
 * updates:
 ****************************************************************************/

public enum StdPlayingCardSuits {
	
	HEARTS("Hearts"), DIAMONDS("Diamonds"), SPADES("Spades"), CLUBS("Clubs");
	
	private final String value;
	
	/**
	 * the Standard Playing Card's suit(s)
	 * @param value
	 */
	private StdPlayingCardSuits(String value) {
		this.value = value;
	}
	
	// provides 'values' instead of 'keys' for ENUM constants
	@Override
	public String toString(){
		return value;
	}
}
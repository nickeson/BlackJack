package com.nickeson.game_of_21;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: StdCardSuit.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> Enum to define suits for a standard deck of cards<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 18, 2016<p/>
 * updates:
 ****************************************************************************/

public enum CustomCardValues1 {
	
	WHIZ("Whiz"), CAESAR("Caesar"), RUPAUL("RuPaul"), NICHOLSON("Nicholson"), 
	BODEREK("Bo Derek"), BEATLES("Beatles"), CRAZY("Crazy"), LUCKY("Lucky"), 
	SIXSHOOTER("Six Shooter"), HIGHFIVE("High Five"), 
	FOURONTHEFLOOR("Four On The Floor"), TRINITY("Trinity"), Deuce("Deuce"),
	COLBERT("Colbert"); 
	
	private final String value;
	
	private CustomCardValues1(String value) {
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

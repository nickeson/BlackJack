package com.nickeson.games.cardgames;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: HandCalculator.java <p/>
 * <b>Project</b>: Card Games <p/>
 * <b>Description: </b> A generic interface to calculate values of Player's Hands of Cards<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public interface HandCalculator {
	
	/**
	 * calculate the value of the Player's Hand of Cards
	 */
	public void checkHandValue();
}

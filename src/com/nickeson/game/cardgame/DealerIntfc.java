package com.nickeson.game.cardgame;

//JDK 1.8.0
import com.nickeson.game.cardgame.blackjack.Player;

/****************************************************************************
 * <b>Title</b>: DealerIntfc.java <p/>
 * <b>Project</b>: Card Games <p/>
 * <b>Description: </b> DealerIntfc interface provides ability to deal a Card or Hand<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public interface DealerIntfc {
	/**
	 * deal a single Card by removing it from the Card collection (deck/shoe), 
	 * then adding it to a Player's Hand and inUse pile
	 * @param player the Player to whom the Dealer deals Cards
	 * @param numCards the number of Cards to deal
	 * @throws EmptyDeckException
	 */
	public void dealCard (Player player, int numCards) throws EmptyDeckException;
	
	/**
	 * deal a Hand of Cards by removing the Cards from the Card collection, 
	 * (deck/shoe), then adding them to the Player's Hand and inUse pile
	 * @param player the Player to whom the Dealer deals Cards
	 * @throws EmptyDeckException
	 */
	public void dealHand(Player player) throws EmptyDeckException;
}
package com.nickeson.game.cardgame.blackjack;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: BetManager.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> Manages betting operations for games<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public interface BetManager {
	
	public void getBet();
	
	public void processBet();
	
	public void runConfigurator();
}
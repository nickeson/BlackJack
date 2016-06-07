package com.nickeson.games.cardgames;
import com.nickeson.games.GameInitializer;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: CardGameInitializer.java <p/>
 * <b>Project</b>: Card Games <p/>
 * <b>Description: </b> Card Game Setup Utilities<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public abstract class CardGameInitializer implements GameInitializer {

	public CardGameInitializer() {
	}
	
	/**
	 * import games settings from Config file(s)
	 */
	public void runConfigurator() { }
	
	/**
	 * establish number of Players for game and setup initial properties (name, etc.)
	 */
	public void setupPlayers() { }
}
package com.nickeson.games;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: GameInitializer.java <p/>
 * <b>Project</b>: Games <p/>
 * <b>Description: </b> Startup routines for games<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public interface GameInitializer {

	/**
	 * establish number of Players for game and setup initial properties (name, etc.)
	 */
	public void setupPlayers();
}
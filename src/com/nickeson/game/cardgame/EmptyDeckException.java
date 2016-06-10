package com.nickeson.game.cardgame;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: EmptyDeckException.java <p/>
 * <b>Project</b>: cardgame <p/>
 * <b>Description: </b> Exception for when an operation is performed on an empty
 * Deck <p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 10, 2016<p/>
 * updates:
 ****************************************************************************/

public class EmptyDeckException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * default constructor provides default Exception message
	 */
	public EmptyDeckException(String message) {
		super(message);
	}
}
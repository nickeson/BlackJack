package com.nickeson.game_of_21;

//JDK 1.8.0
import java.util.ArrayList;

/****************************************************************************
 * <b>Title</b>: StandardDeck.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A standard 52 card deck + 2 jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class StandardDeck implements Deck {

	public StandardDeck() {
	}
	
	ArrayList<Card> myDeck = new ArrayList<>(52);

	public static void main(String[] args) {
	
	}
}
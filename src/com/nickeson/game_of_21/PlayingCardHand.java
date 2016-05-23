package com.nickeson.game_of_21;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Hand.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> Class to hold a hand of cards<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class PlayingCardHand {
	int score;
	
	/**
	 * default no-arg constructor
	 */
	public PlayingCardHand() {
	}
	
	/**
	 * add another PlayingCard to this hand instance
	 */
	public void addPlayingCard() {
		
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
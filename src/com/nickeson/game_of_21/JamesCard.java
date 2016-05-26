package com.nickeson.game_of_21;

/********************************************************************
 * <b>Title: </b>JamesCard.java<br/>
 * <b>Description: </b><<<< Some Desc Goes Here >>>><br/>
 * <b>Copyright: </b>Copyright (c) 2016<br/>
 * <b>Company: </b>Silicon Mountain Technologies
 * @author james
 * @version 3.x
 * @since May 26, 2016
 * Last Updated:
 * 	
 *******************************************************************/
public class JamesCard {

	private String suit = null;
	private String rank = null;
	private int value = 0;
	
	/**
	 * 
	 */
	public JamesCard() {
		
	}
	
	public JamesCard(String suit, String rank, int value) {
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	
	public boolean isValue(int value) {
		return this.value == value;
	}
	
	public boolean isRank(String rank) {
		if (this.rank == null || this.rank.length() == 0) return false;
		return this.rank.equalsIgnoreCase(rank);
	}

	/**
	 * @return the suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * @param suit the suit to set
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

}


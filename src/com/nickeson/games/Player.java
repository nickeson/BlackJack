package com.nickeson.games;

import java.time.LocalDate;
import java.util.List;
import com.nickeson.Person;
import com.nickeson.games.cardgames.Card;
import com.nickeson.games.cardgames.Hand;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Player.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A subclass of Person for use in game play<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Player extends Person {
	
	private int acctBalance = 0; // whole dollar values only for our card game(s)
	private int winBalance = 0;
	private Hand<Card> hand;
	
	/**
	 * default no-arg constructor calls the super constructor which then 
	 * reminds user that a minimum of firstName, lastName is required to instantiate
	 * a Person (or Player, in this case)
	 */
	public Player() {
		super();
	}
		
	/**
	 * constructor requires first and last names at minimum upon instantiation of Player
	 * @param firstName
	 * @param lastName
	 */
	public Player(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	/**
	 * constructor allows first and last name fields and birthday to be set upon
	 * instantiation of Player
	 * @param firstName
	 * @param lastName
	 * @param birthday
	 */
	public Player(String firstName, String lastName, String birthday) {
		super(firstName, lastName, birthday);
	}
	
	/**
	 * constructor allows all Person fields to be set upon instantiation of Player
	 * @param firstName
	 * @param lastName
	 * @param birthday
	 * @param genderIdentity
	 */
	public Player(String firstName, String lastName, String birthday, 
			String genderIdentity) {
		super(firstName, lastName, birthday, genderIdentity);
	}
	
	/**
	 * constructor allows all Person fields to be set upon instantiation of Player
	 * @param firstName
	 * @param lastName
	 * @param birthday
	 * @param genderIdentity
	 * @param nickNames
	 */
	public Player(String firstName, String lastName, String birthday, 
			String genderIdentity, List<String> nickNames) {
		super(firstName, lastName, birthday, genderIdentity, nickNames);
	}
	
	/** set the Player's firstName (variable inherited from Person.java)
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		super.setFirstName(firstName);
	}
	
	/**
	 * @return the Player's firstName (variable inherited from Person.java)
	 */
	public String getFirstName() {
		return super.getFirstName();
	}
	
	/** set the Player's lastName (variable inherited from Person.java)
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		super.setLastName(lastName);
	}
	
	/**
	 * @return the Player's lastName (variable inherited from Person.java)
	 */
	public String getLastName() {
		return super.getLastName();
	}
	
	/**
	 * set the Player's birthday (variable inherited from Person.java)
	 * @param birthday
	 */
	public void setDOB(String birthday) {
		super.setDOB(birthday);
	}
	
	/**
	 * @return the Player's dob (variable inherited from Person.java)
	 */
	public LocalDate getDOB() {
		return super.getDOB();
	}
	
	/**
	 * set the Player's genderIdentity (variable inherited from Person.java)
	 * @param genderIdentity
	 */
	public void setGenderIdentity(String genderIdentity) {
		super.setGenderIdentity(genderIdentity);
	}
	
	/**
	 * @return the Player's genderIdentity (variable inherited from Person.java)
	 */
	public String getGenderIdentity() {
		return super.getGenderIdentity();
	}
	
	/**
	 * @return the acctBalance
	 */
	public int getAcctBalance() {
		return acctBalance;
	}

	/**
	 * @param acctBalance the acctBalance to set
	 */
	public void setAcctBalance(int acctBalance) {
		this.acctBalance = acctBalance;
	}

	/**
	 * winBalance is the total amount of money a Player has won from the Bank
	 * @return the winBalance
	 */
	public int getWinBalance() {
		return winBalance;
	}

	/**
	 * winBalance is the total amount of money a Player has won from the Bank
	 * @param winBalance the winBalance to set
	 */
	public void setWinBalance(int winBalance) {
		this.winBalance = winBalance;
	}

	/**
	 * @return the hand
	 */
	public Hand<Card> getHand() {
		return hand;
	}

	/**
	 * set the Player's hand
	 * @param hand
	 */
	public void setHand(Hand<Card> hand) {
		this.hand = hand;
	}
	
	/**
	 * Override toString() to print Person's field values, rather than hashcode
	 */
	@Override
	public String toString() {
		String result = getFirstName() + " " + getLastName() + " is " + getDOB() + 
				" years old, " + getGenderIdentity() + 
				", and is also known as: " + getNickNames() + 
				".  Account Balance: $" + getAcctBalance();
		return result;
	}
	// unit test main method
//	public static void main(String[] args) {
//	}
}
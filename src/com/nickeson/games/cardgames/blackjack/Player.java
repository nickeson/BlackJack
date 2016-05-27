package com.nickeson.games.cardgames.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
//JDK 1.8.0
import java.util.List;

/****************************************************************************
 * <b>Title</b>: Player.java <p/>
 * <b>Project</b>: game_of_21 <p/>
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
	private Hand<PlayingCard> hand;
	
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
	 * constructor allows first and last name fields and age to be set upon
	 * instantiation of Player
	 * @param firstName
	 * @param lastName
	 * @param age
	 */
	public Player(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}
	
	/**
	 * constructor allows all Person fields to be set upon instantiation of Player
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param genderIdentity
	 */
	public Player(String firstName, String lastName, int age, 
			String genderIdentity) {
		super(firstName, lastName, age, genderIdentity);
	}
	
	/**
	 * constructor allows all Person fields to be set upon instantiation of Player
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param genderIdentity
	 * @param nickNames
	 */
	public Player(String firstName, String lastName, int age, 
			String genderIdentity, List<String> nickNames) {
		super(firstName, lastName, age, genderIdentity, nickNames);
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
	 * set the Player's age (variable inherited from Person.java)
	 * @param age
	 */
	public void setAge(int age) {
		super.setAge(age);
	}
	
	/**
	 * @return the Player's age (variable inherited from Person.java)
	 */
	public int getAge() {
		return super.getAge();
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
	
	/** set the Player's nickNames (variable inherited from Person.java)
	 * @param nickNames
	 */
	public void setNickNames(List<String> nickNames) {
		super.nickNames = nickNames;
	}
	
	/**
	 * @return the Player's nickName(s)
	 */
	public List<String> getNickNames() {
		return super.nickNames;
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
	public Hand<PlayingCard> getHand() {
		return hand;
	}

	/**
	 * set the Player's hand
	 * @param hand
	 */
	public void setHand(Hand<PlayingCard> hand) {
		this.hand = hand;
	}
	
	/**
	 * Override toString() to print Person's field values, rather than hashcode
	 */
	@Override
	public String toString() {
		String result = getFirstName() + " " + getLastName() + " is " + getAge() + 
				" years old, " + getGenderIdentity() + 
				", and is also known as: " + getNickNames() + 
				".  Account Balance: $" + getAcctBalance();
		return result;
	}
	// unit test main method
	public static void main(String[] args) {
		// what happens when we try to create a null Player?
		//System.out.println(new Player());
		
		// create a sample Player & print out the values
		Player testPlayer = new Player("Kris", "Nickeson", 39, "Male", 
				(new ArrayList<String>(Arrays.asList("U-Turn", "MegaGiga", "Shorty"))));
		testPlayer.setAcctBalance(50);
		System.out.println(testPlayer);
		
		// create a sample player 'piecemeal'
		Player testPlayer2 = new Player();
		testPlayer2.setFirstName("Niya");
		testPlayer2.setLastName("Nolting");	
		testPlayer2.setAge(42);
		testPlayer2.setGenderIdentity("Female");
		testPlayer2.setNickNames(new ArrayList<String>(Arrays.asList("Li'l Shorty", "Sweetie")));
		testPlayer2.setAcctBalance(40);
		System.out.println(testPlayer2);
	}
}
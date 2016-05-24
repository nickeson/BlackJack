package com.nickeson.game_of_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Dealer.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> Specific Dealer for game_of_21, provides ability to 
 * deal cards and play the Dealer's hand<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Dealer_of_21 extends Player {
	
	private StdPlayingCards_Shoe shoe;
	private CstmPlayingCards1_Shoe cstmShoe;
	
	/**
	 * no-arg constructor instantiates the Dealer (PC) as a Player
	 */
	public Dealer_of_21() {
		super("Dealer", "(PC)");
	}
	
	/**
	 * minimal constructor requires first & last name upon instantiating a Player/Dealer
	 */
	public Dealer_of_21(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	/**
	 * convenience constructor allows first and last name & age fields to be set
	 * upon instantiation of a Player/Dealer
	 * @param firstName
	 * @param lastName
	 * @param age
	 */
	public Dealer_of_21(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}
	
	/**
	 * convenience constructor allows first & last names, age and genderIdentity
	 * fields to be set upon instantiation of a Player/Dealer
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param genderIdentity
	 */
	public Dealer_of_21(String firstName, String lastName, int age, String genderIdentity) {
		super(firstName, lastName, age, genderIdentity);
	}
	
	/**
	 * constructor allows all Person fields to be set upon instantiation of Player/Dealer
	 */
	public Dealer_of_21(String firstName, String lastName, int age, 
			String genderIdentity, List<String> nickNames) {
		super(firstName, lastName, age, genderIdentity, nickNames);
	}
	
	/** set the Dealer's firstName (variable inherited from Person.java)
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		super.setFirstName(firstName);
	}
	
	/**
	 * @return the Dealer's firstName (variable inherited from Person.java)
	 */
	public String getFirstName() {
		return super.getFirstName();
	}
	
	/** set the Dealer's lastName (variable inherited from Person.java)
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		super.setLastName(lastName);
	}
	
	/**
	 * @return the Dealer's lastName (variable inherited from Person.java)
	 */
	public String getLastName() {
		return super.getLastName();
	}
	
	/**
	 * set the Dealer's age (variable inherited from Person.java)
	 * @param age
	 */
	public void setAge(int age) {
		super.setAge(age);
	}
	
	/**
	 * @return the Dealer's age (variable inherited from Person.java)
	 */
	public int getAge() {
		return super.getAge();
	}
	
	/**
	 * set the Dealer's genderIdentity (variable inherited from Person.java)
	 * @param genderIdentity
	 */
	public void setGenderIdentity(String genderIdentity) {
		super.setGenderIdentity(genderIdentity);
	}
	
	/**
	 * @return the Dealer's genderIdentity (variable inherited from Person.java)
	 */
	public String getGenderIdentity() {
		return super.getGenderIdentity();
	}
	
	/** set the Dealer's nickNames (variable inherited from Person.java)
	 * @param nickNames
	 */
	public void setNickNames(List<String> nickNames) {
		super.nickNames = nickNames;
	}
	
	/**
	 * @return the Dealer's nickName(s)
	 */
	public List<String> getNickNames() {
		return super.nickNames;
	}
	
	/**
	 * set the Dealer's hand
	 * @param hand
	 */
	public void setHand(PlayingCardsHand<PlayingCard> hand) {
		super.setHand(hand);
	}
	
	/**
	 * @return the Dealer's hand
	 */
	public PlayingCardsHand<PlayingCard> getHand() {
		PlayingCardsHand<PlayingCard> hand = super.getHand();
		return hand;
	}

	/**
	 * set the Dealer's account balance
	 * @param acctBalance
	 */
	public void setAcctBalance(int acctBalance) {
		super.setAcctBalance(acctBalance);
	}
	
	/**
	 * @return the Dealer's account balance
	 */
	public int getAcctBalance() {
		int result = super.getAcctBalance();
		return result;
	}

	/**
	 * setup the Dealer's shoe of PlayingCards
	 * @param shoe
	 */
	public void setShoe(StdPlayingCards_Shoe shoe) {
		this.shoe = shoe;
	}

	/**
	 * @return the Dealer's shoe of PlayingCards
	 */
	public StdPlayingCards_Shoe getShoe() {
		return shoe;
	}

	/**
	 * @param cstmShoe the cstmShoe to set
	 */
	public void setCstmShoe(CstmPlayingCards1_Shoe cstmShoe) {
		this.cstmShoe = cstmShoe;
	}
	
	/**
	 * @return the cstmShoe
	 */
	public CstmPlayingCards1_Shoe getCstmShoe() {
		return cstmShoe;
	}

	/**
	 * deal a Hand of PlayingCards
	 * include special rules for Dealer's hand
	 */
	public void deal() {
	}
	
	/**
	 * play the Dealer's hand of 21 (specific rules for game_of_21)
	 */
	public void playHand() {
	}
	
	/**
	 * Override the toString() method to print specific String when the Dealer
	 * is the PC and not a human Person/Player, otherwise print Dealer's field
	 * values as Strings, rather than hashcode
	 */
	@Override
	public String toString() {
		String result = "";
		if ((getFirstName().equals("Dealer")) && (getLastName().equals("(PC)"))){
			result = "The PC is the Dealer";
		} else {
			result = getFirstName() + " " + getLastName() + " is " + getAge() + 
					" years old, " + getGenderIdentity() + 
					", and is also known as: " + getNickNames() +
					".  Account Balance: $" + getAcctBalance();
		}
		return result;
	}
	
	// unit test method
	public static void main(String[] args) {
		Dealer_of_21 tmpDealer = new Dealer_of_21();
		System.out.println(tmpDealer);
		
		System.out.println("");
		
		// default Shoe is 6 decks, no Jokers, shuffled
		CstmPlayingCards1_Shoe cstmDlrShoe = new CstmPlayingCards1_Shoe(0,1);
		cstmDlrShoe.shuffleDeck();
		Dealer_of_21 tmpDealer2 = new Dealer_of_21("Kris", "Nickeson", 39, "Male", 
				(new ArrayList<String>(Arrays.asList("U-Turn", "MegaGiga", "Shorty"))));
		tmpDealer2.setAcctBalance(500);
		tmpDealer2.setCstmShoe(cstmDlrShoe);
		System.out.println("Dealer " + tmpDealer2);
		System.out.println("Dealer's shuffled custom Shoe contents: " + tmpDealer2.getCstmShoe());
		
		System.out.println("");	
		
		// default Shoe is 6 decks, no Jokers, shuffled
		StdPlayingCards_Shoe dlrShoe = new StdPlayingCards_Shoe(0, 6);
		dlrShoe.shuffleDeck();
		Dealer_of_21 tmpDealer3 = new Dealer_of_21();
		tmpDealer3.setFirstName("Poncho");
		tmpDealer3.setLastName("Sanchez");
		tmpDealer3.setAge(69);
		tmpDealer3.setGenderIdentity("Male");
		tmpDealer3.setNickNames(new ArrayList<String>(Arrays.asList("RoughHands", "El mas excepcional jugador de Conga")));
		tmpDealer3.setAcctBalance(30);
		tmpDealer3.setShoe(dlrShoe);
		System.out.println("Dealer " + tmpDealer3);
		System.out.println("Dealer's shuffled Shoe contents: " + tmpDealer3.getShoe());
	}
}
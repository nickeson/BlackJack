package com.nickeson.games.cardgames;

import java.time.LocalDate;
import java.util.List;
import com.nickeson.games.Player;
import com.nickeson.games.cardgames.Shoe;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Dealer.java <p/>
 * <b>Project</b>: Card Games <p/>
 * <b>Description: </b> Card Dealer provides ability to deal a Card or Hand<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Dealer extends Player {
	
	private Shoe shoe;
	
	/**
	 * no-arg constructor instantiates the Dealer (PC) as a Player
	 */
	public Dealer() {
		super("Dealer", "(PC)");
	}
	
	/**
	 * minimal constructor requires first & last name upon instantiating a Player/Dealer
	 */
	public Dealer(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	/**
	 * convenience constructor allows first and last name & birthday fields to be set
	 * upon instantiation of a Player/Dealer
	 * @param firstName
	 * @param lastName
	 * @param birthday
	 */
	public Dealer(String firstName, String lastName, String birthday) {
		super(firstName, lastName, birthday);
	}
	
	/**
	 * convenience constructor allows first & last names, birthday and genderIdentity
	 * fields to be set upon instantiation of a Player/Dealer
	 * @param firstName
	 * @param lastName
	 * @param birthday
	 * @param genderIdentity
	 */
	public Dealer(String firstName, String lastName, String birthday, String genderIdentity) {
		super(firstName, lastName, birthday, genderIdentity);
	}
	
	/**
	 * constructor allows all Person fields to be set upon instantiation of Player/Dealer
	 */
	public Dealer(String firstName, String lastName, String birthday, 
			String genderIdentity, List<String> nickNames) {
		super(firstName, lastName, birthday, genderIdentity, nickNames);
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
	 * set the Dealer's birthday (variable inherited from Person.java)
	 * @param birthday
	 */
	public void setDOB(String birthday) {
		super.setDOB(birthday);
	}
	
	/**
	 * @return the Dealer's birthday (variable inherited from Person.java)
	 */
	public LocalDate getDOB() {
		return super.getDOB();
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
	
	/**
	 * set the Dealer's hand
	 * @param hand
	 */
	public void setHand(Hand<Card> hand) {
		super.setHand(hand);
	}
	
	/**
	 * @return the Dealer's hand
	 */
	public Hand<Card> getHand() {
		Hand<Card> hand = super.getHand();
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
	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}

	/**
	 * @return the Dealer's shoe of PlayingCards
	 */
	public Shoe getShoe() {
		return shoe;
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
			result = getFirstName() + " " + getLastName() + " is " + getDOB() + 
					" years old, " + getGenderIdentity() + 
					", and is also known as: " + getNickNames() +
					".  Account Balance: $" + getAcctBalance();
		}
		return result;
	}
	
	// unit test method
//	public static void main(String[] args) {
//	}
}
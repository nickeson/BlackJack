package com.nickeson.games.cardgames.blackjack;

//import java.util.ArrayList;
import java.util.List;

import com.nickeson.games.cardgames.Dealer;
import com.nickeson.games.cardgames.Shoe;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: BlackjackDealer.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A dealer for the game of Blackjack<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public class BlackjackDealer extends Player implements Dealer {

//	private List<Player> players = new ArrayList<Player>();
	private Shoe shoe = new Shoe(); // builds a standard 6 deck Shoe, no Jokers
	
	/**
	 * default constructor sets Dealer's name to PC (assumes the Dealer role is
	 * played by the PC)
	 */
	public BlackjackDealer() {
		super("Dealer", "(PC)");
	}
	
	/**
	 * convenience constructor allows setting of firstName and lastName during
	 * BlackjackDealer instantiation
	 * @param firstName the First Name to set
	 * @param lastName the Last Name to set
	 */
	public BlackjackDealer(String firstName, String lastName) {
		super(firstName, lastName);
	}

	/**
	 * convenience constructor allows first and last name & DOB fields to be set
	 * upon instantiation of BlackjackDealer
	 * @param firstName the First Name to set
	 * @param lastName the Last Name to set
	 * @param dob the DateOfBirth to set
	 */
	public BlackjackDealer(String firstName, String lastName, String dob) {
		super(firstName, lastName, dob);
	}
	
	/**
	 * convenience constructor allows first & last names, DOB and genderIdentity
	 * fields to be set upon instantiation of BlackjackDealer
	 * @param firstName the First Name to set
	 * @param lastName the Last Name to set
	 * @param dob the DateOfBirth to set
	 * @param genderIdentity the Gender Identity to set
	 */
	public BlackjackDealer(String firstName, String lastName, String dob, String genderIdentity) {
		super(firstName, lastName, dob, genderIdentity);
	}
	
	/**
	 * convenience constructor allows first & last names, DOB, genderIdentity, 
	 * and nickNames fields to bet set upon instantiation of BlackjackDealer
	 * @param firstName the First Name to set
	 * @param lastName the Last Name to set
	 * @param dob the DateOfBirth to set
	 * @param genderIdentity the Gender Identity to set
	 * @param nickNames the Nicknames to set
	 */
	public BlackjackDealer(String firstName, String lastName, String dob, 
			String genderIdentity, List<String> nickNames) {
		super(firstName, lastName, dob, genderIdentity, nickNames);
	}
	
	/**
	 * convenience constructor allows all Person fields to be set upon 
	 * instantiation of BlackjackDealer
	 * @param firstName the First Name to set
	 * @param lastName the Last Name to set
	 * @param dob the DateOfBirth to set
	 * @param genderIdentity the Gender Identity to set
	 * @param nickNames the Nicknames to set
	 */
	public BlackjackDealer(String firstName, String lastName, String dob, 
			String genderIdentity, List<String> nickNames, String screenName) {
		super(firstName, lastName, dob, genderIdentity, nickNames, screenName);
	}
	
	public void dealHand() {
	}
	
	public void dealCard(Player player, boolean faceUp) {
//		nextCard = shoe.getCard();
	}
	
	// contains special logic that the BlackjackDealer has to follow that other Players don't have to follow
	@Override
	public boolean hitOrStand() {
		boolean result = false;
		return result;
	}
	
	/**
	 * Override the toString() method to print specific String when the Dealer
	 * is the PC and not a human PersonVO/Player, otherwise print Dealer's field
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
	
	// unit test
	public static void main(String[] args) {
		BlackjackDealer dealer = new BlackjackDealer();
		System.out.println(dealer);
		System.out.println(dealer.shoe);
		
		Player kn = new Player("Kris", "Nickeson");
		dealer.dealCard(kn, false);
	}
}
package com.nickeson.game.cardgame.blackjack;

import java.util.List;
import com.nickeson.game.cardgame.DealerIntfc;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: BlackjackDealer.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> A dealer for the game of Blackjack<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public class BlackjackDealer extends Player implements DealerIntfc {

	/**
	 * default constructor assumes the BlackjackDealer role is played by the PC
	 */
	public BlackjackDealer() {
		super("DealerIntfc", "(PC)");
	}
	
	/**
	 * minimal constructor allows setting of firstName and lastName during
	 * BlackjackDealer instantiation
	 * @param firstName the First Name to set
	 * @param lastName the Last Name to set
	 */
	public BlackjackDealer(String firstName, String lastName) {
		super(firstName, lastName);
	}

	/**
	 * convenience constructor allows all Person fields to be set
	 * @param firstName the First Name to set
	 * @param lastName the Last Name to set
	 * @param dob the DateOfBirth to set
	 * @param genderIdentity the Gender Identity to set
	 * @param nickNames the Nicknames to set
	 * @param screenName the Screen Name to set
	 * @param acctBalance the Account Balance to set
	 */
	public BlackjackDealer(String firstName, String lastName, String dob, 
			String genderIdentity, List<String> nickNames, String screenName, int acctBalance) {
		super(firstName, lastName, dob, genderIdentity, 
				nickNames, screenName, acctBalance);
	}
	
	public void dealHand() {
	}
	
	public void dealCard() {
	}
	
	// contains game logic that the BlackjackDealer must follow that other
	// Players don't have to follow
	@Override
	public boolean hitOrStand() {
		boolean result = false;
		return result;
	}
	
	/**
	 * Override the toString() method to print specific String when the 
	 * Blackjack Dealer is the PC and not a human Player, otherwise printer
	 * Blackjack Dealer's value as String rather than hashcode
	 */
	@Override
	public String toString() {
		String result = "";
		if ((getFirstName().equals("DealerIntfc")) && (getLastName().equals("(PC)"))){
			result = "The PC is the Blackjack Dealer";
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
	}
}
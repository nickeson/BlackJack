package com.nickeson.games;

import java.util.List;
import com.nickeson.Person;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Player.java <p/>
 * <b>Project</b>: Games <p/>
 * <b>Description: </b> A subclass of Person for use in game play<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Player extends Person {
	
	private String screenName = null;
	private int acctBalance = 0; // whole dollar values only for our game(s)

	/**
	 * default no-arg constructor issues message that a minimum of firstName and
	 * lastName is required to instantiate a Player
	 */
	public Player() {
		super();
	}
		
	/**
	 * primary constructor requires firstName and lastName at minimum
	 * to instantiate a Player
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 */
	public Player(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	/**
	 * convenience constructor allows firstName and lastName fields and dob
	 * to be set upon instantiation of Player
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 * @param dob the DateOfBirth to set (2016-12-03 is proper format)
	 */
	public Player(String firstName, String lastName, String dob) {
		super(firstName, lastName, dob);
	}
	
	/**
	 * convenience constructor allows firstName and lastName fields, dob, 
	 * and genderIdentity to be set upon instantiation of Player
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 * @param dob the DateOfBirth to set (2016-12-03 is proper format)
	 * @param genderIdentity the gender identity to set
	 */
	public Player(String firstName, String lastName, String dob, 
			String genderIdentity) {
		super(firstName, lastName, dob, genderIdentity);
	}
	
	/**
	 * convenience constructor allows firstName and lastName fields, dob, 
	 * genderIdentity, and nickName(s) to be set upon instantiation of Player
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 * @param dob the DateOfBirth to set (2016-12-03 is proper format)
	 * @param genderIdentity the gender identity to set
	 * @param nickNames the nickname(s) to set
	 */
	public Player(String firstName, String lastName, String dob, 
			String genderIdentity, List<String> nickNames) {
		super(firstName, lastName, dob, genderIdentity, nickNames);
	}
	
	/**
	 * convenience constructor allows firstName and lastName fields, dob,
	 * genderIdentity, nickName(s), and screenName to be set upon Player instantiation
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 * @param dob the DateOfBirth to set (2016-12-03 is proper format)
	 * @param genderIdentity the gender identity to set
	 * @param nickNames the nickname(s) to set
	 */
	public Player(String firstName, String lastName, String dob, 
			String genderIdentity, List<String> nickNames, String screenName) {
		super(firstName, lastName, dob, genderIdentity, nickNames);
		this.screenName = screenName;
	}

	/**
	 * convenience constructor allows firstName and lastName fields, dob,
	 * genderIdentity, nickName(s), screenName and acctBalance to be set upon 
	 * instantiation of Player
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 * @param dob the DateOfBirth to set (2016-12-03 is proper format)
	 * @param genderIdentity the gender identity to set
	 * @param nickNames the nickname(s) to set
	 */
	public Player(String firstName, String lastName, String dob, 
			String genderIdentity, List<String> nickNames, 
			String screenName, int acctBalance) 
	{
		super(firstName, lastName, dob, genderIdentity, nickNames);
		this.screenName = screenName;
		this.acctBalance = acctBalance;
	}
	
	/**
	 * @return the Player's screenName
	 */
	public String getScreenName() {
		return screenName;
	}

	/**
	 * @param screenName the screenName to set
	 */
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	
	/**
	 * @return the Player's acctBalance
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
	 * players have the option to Hit (get another Card from Dealer) or 
	 * Stand (no more Cards, run HandCalculator)
	 */
	public void hitOrStand() {

	}
	
	/**
	 * Override toString() to print Person's field values, rather than hashcode
	 */
	@Override
	public String toString() {
		String result = super.toString();
		result += "screenName: ";
		if (getScreenName() == null) {
			result += "unavailable\n";
		} else {
			result += getScreenName() + "\n";
		}
		result += "acctBalance: ";
		if (getAcctBalance() == 0) {
			result += "unavailable\n";
		} else {
			result += "$" + getAcctBalance() + "\n";
		}
		return result;
	}
}
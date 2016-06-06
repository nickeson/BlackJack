package com.nickeson;

import java.time.LocalDate;
import java.util.List;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Person.java <p/>
 * <b>Project</b>: Base Library <p/>
 * <b>Description: </b> A class to model a Person<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Person {
	private String firstName = null;
	private String lastName = null;
	private LocalDate dob = null;
	private String genderIdentity = null;
	List<String> nickNames = null;

	/**
	 * default no-arg constructor warns against creating a null Person
	 */
	public Person() {
		System.out.print("You have created an anonymous Person with null values " +
				"that can be populated later.\n");
		System.out.println("However, you should always instantiate a Person with (at minimum): " +
				"firstName, lastName.");
	}
	
	/**
	 * minimal constructor requires first & last name
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = null;
		this.genderIdentity = null;
		this.nickNames = null;
	}
	
	/**
	 * convenience constructor allows first and last name & dob fields to be set
	 * upon instantiation
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 * @param dob the DateOfBirth to set (2016-12-03 is proper format)
	 */
	public Person(String firstName, String lastName, String dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = LocalDate.parse(dob);
		this.genderIdentity = null;
		this.nickNames = null;
	}
	
	/**
	 * convenience constructor allows first & last names, dob and genderIdentity
	 * fields to be set upon instantiation
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 * @param dob the DateOfBirth to set (2016-12-03 is proper format)
	 * @param genderIdentity the gender identity to set
	 */
	public Person(String firstName, String lastName, String dob, String genderIdentity) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = LocalDate.parse(dob);
		this.genderIdentity = genderIdentity;
		this.nickNames = null;
	}
	
	/**
	 * convenience constructor allows all Person fields to be set upon instantiation
	 * @param firstName the first name to set
	 * @param lastName the last name to set
	 * @param dob the DateOfBirth to set (2016-12-03 is proper format)
	 * @param genderIdentity the gender identity to set
	 * @param nickNames a List of the nick name(s) to set
	 */
	public Person(String firstName, String lastName, String dob, 
			String genderIdentity, List<String> nickNames) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = LocalDate.parse(dob);
		this.genderIdentity = genderIdentity;
		this.nickNames = nickNames;
	}

	/**
	 * @return the Person's firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName set the Person's firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the Person's lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName set the Person's lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the Person's DateOfBirth (dob) as a LocalDate object
	 */
	public LocalDate getDOB() {
		return dob;
	}

	/**
	 * @param dob set the Person's DateOfBirth (2016-12-03 is proper format)
	 */
	public void setDOB(String dob) {
		this.dob = LocalDate.parse(dob);
	}
	
	/**
	 * @return the Person's genderIdentity
	 */
	public String getGenderIdentity() {
		return genderIdentity;
	}

	/** 
	 * @param genderIdentity set the Person's gender identity
	 */
	public void setGenderIdentity(String genderIdentity) {
		this.genderIdentity = genderIdentity;
	}
	
	/**
	 * @param nickNames set one or more nickName(s) by passing a List of String objects
	 */
	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}
	
	/**
	 * @return the Person's nickName(s) as a List of String objects
	 */
	public List<String> getNickNames() {
		return nickNames;
	}
	
	/**
	 * Override toString() to print Person's field values, rather than hashcode
	 */
	@Override
	public String toString() {
		String result = "Name: ";
		if (getFirstName() != null) {
			result += getFirstName() + " " + getLastName() + "\n";
		} else {
			result += "unavailable\n";
		}
		if (getDOB() != null) {
			result += "DOB: " + getDOB() + "\n";
		} else {
			result += "DOB: unavailable\n";
		}
		if (getGenderIdentity() != null) {
			result += "Gender Identity: " + getGenderIdentity() + "\n";
		} else {
			result += "Gender Identity: unavailable\n";
		}
		if (getNickNames() != null) {
			result += "Nickname(s): " + getNickNames() + "\n";
		} else {
			result += "Nickname(s): unavailable\n";
		}
	return result;
	}
}
package com.nickeson;

//JDK 1.8.0
import java.time.LocalDate;
import java.util.List;

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
	 * minimal constructor requires first & last name
	 * @param firstName the firstName to set upon instantiation
	 * @param lastName the lastName to set upon instantiation
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = null;
		this.genderIdentity = null;
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
	 * @return the Person's DateOfBirth (dob) as a LocalDate object (2016-12-03 format)
	 */
	public LocalDate getDOB() {
		return dob;
	}

	/**
	 * @param dob set the Person's DateOfBirth (2016-12-03 format)
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
	 * @return the String value of the Person
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
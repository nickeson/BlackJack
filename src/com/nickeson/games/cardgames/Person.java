package com.nickeson.games.cardgames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Person.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A class to model a Person for game play<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String genderIdentity;
	List<String> nickNames;

	/**
	 * default no-arg constructor warns against creating a null Person
	 */
	public Person() {
		System.out.print("You have created an anonymous Person with null values " +
				"that can be populated later.  ");
		System.out.println("You should, however, instantiate a Person with " +
				"(at minimum): firstName, lastName.");
	}
	
	/**
	 * minimal constructor requires first & last name
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * convenience constructor allows first and last name & age fields to be set
	 * upon instantiation
	 * @param firstName
	 * @param lastName
	 * @param age
	 */
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	/**
	 * convenience constructor allows first & last names, age and genderIdentity
	 * fields to be set upon instantiation
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param genderIdentity
	 */
	public Person(String firstName, String lastName, int age, String genderIdentity) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.genderIdentity = genderIdentity;
	}
	
	/**
	 * convenience constructor allows all Person fields to be set upon instantiation
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param genderIdentity
	 * @param nickNames
	 */
	public Person(String firstName, String lastName, int age, 
			String genderIdentity, List<String> nickNames) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.genderIdentity = genderIdentity;
		this.nickNames = nickNames;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * @return the genderIdentity
	 */
	public String getGenderIdentity() {
		return genderIdentity;
	}

	/** set the genderIdentity
	 * @param genderIdentity
	 */
	public void setGenderIdentity(String genderIdentity) {
		this.genderIdentity = genderIdentity;
	}
	
	/**
	 * @param nickNames the nickNames values to set
	 */
	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}
	
	/**
	 * @return the nickNames
	 */
	public List<String> getNickNames() {
		return nickNames;
	}
	
	/**
	 * Override toString() to print Person's field values, rather than hashcode
	 */
	@Override
	public String toString() {
		String result = getFirstName() + " " + getLastName() + " is " + getAge() + 
				" years old, " + getGenderIdentity() + 
				", and is also known as: " + getNickNames();
		return result;
	}
	
	// unit test method
	public static void main(String[] args) {
		Person testPers = new Person("Kris", "Nickeson", 39, "Male", 
				new ArrayList<String>(Arrays.asList("U-Turn", "MegaGiga", "Shorty")));
		System.out.println(testPers);
		System.out.println(new Person());
	}
}
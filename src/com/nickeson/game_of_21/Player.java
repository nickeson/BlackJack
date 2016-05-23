package com.nickeson.game_of_21;

//JDK 1.8.0
import java.util.ArrayList;

/****************************************************************************
 * <b>Title</b>: Player.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> Player class, subclass of Person<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class Player extends Person {
	private ArrayList<String> nickNames = new ArrayList<>();
		
	public Player() {
	}

	/**
	 * @param nickNames - the nickName(s) to set
	 */
	// (uses varargs to allow multiple or no nicknames to be passed to method
	public void setNickNames(String... nickNames) {
		for (String nn : nickNames) {
		this.nickNames.add(nn);
		}
	}
	
	/**
	 * @return the nickName(s)
	 */
	public ArrayList<String> getNickNames() {
		return nickNames;
	}
	
	// unit test main method
//	public static void main(String[] args) {
//		Player testPlayer = new Player();
//		Player testPlayer2 = new Player();
//		Player testPlayer3 = new Player();
		
//		testPlayer.setNickNames();	
//		testPlayer2.setNickNames("test1");
//		testPlayer3.setNickNames("test2", "test3");
		
//		System.out.println(testPlayer.getNickNames());	
//		System.out.println(testPlayer2.getNickNames());
//		System.out.println(testPlayer3.getNickNames());	
//	}
}
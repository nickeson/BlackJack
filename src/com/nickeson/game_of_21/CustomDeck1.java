package com.nickeson.game_of_21;

//JDK 1.8.0
import java.util.ArrayList;
import java.util.Collections;

/****************************************************************************
 * <b>Title</b>: StandardDeck.java <p/>
 * <b>Project</b>: game_of_21 <p/>
 * <b>Description: </b> A standard 52 card deck + 2 jokers<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

public class CustomDeck1 implements Deck {
	// use 'Object', not 'Card' --> polymorphism for other Object types in deck
	private ArrayList<Object> custDeck1 = new ArrayList<Object>();
	
	// define suits and card values
	private static String[] cardSuits = {"BrokenHearts", "BloodDiamonds", "GardenSpades", "BookClubs"};
    private static String[] cardValues = {"Ace", "King", "Queen", "Jack", "10",
                                   "9", "8", "7", "6", "5", "4", "3", "2", "Joker"};
	
    // build a deck with or without jokers by passing boolean arg to constructor
	public CustomDeck1(boolean hasJokers) {
		buildDeck();
		
		if (hasJokers == true) {
			// add 2 Jokers (they don't get a suit)
			custDeck1.add(new Card("","Joker"));
			custDeck1.add(new Card("","Joker"));	
		}
	}
	
	// build a deck with no jokers if no-arg constructor is called
	public CustomDeck1(){
		buildDeck();
	}
	
	public void buildDeck() {
		/* loop through the suits and values arrays, building new cards
		 * for each value of each suit (no jokers)
		 */
		for (String ol : getSuits())
		{
			for (String il : getCardVals())
			{
				if (!il.equals("Joker")) {
					custDeck1.add(new Card(ol,il));
				}
			}
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(custDeck1);
	}
	
	public static String[] getSuits() {
    	return cardSuits;
	}
    
    public static String[] getCardVals() {
    	return cardValues;
    }
	
 	// override toString to return Deck as String instead of hashcode
    @Override
 	public String toString()
 	{
	 	String result = "" + custDeck1;
	 	return result;
 	}
 	 
	// unit test method for StandardDeck class
	public static void main(String[] args) {
		CustomDeck1 myDeck = new CustomDeck1(true);
		myDeck.shuffleDeck();
		CustomDeck1 my2ndDeck = new CustomDeck1(false);	
		System.out.println("Deck with Jokers: " + myDeck);
		System.out.println("Deck without Jokers: " + my2ndDeck);	
	 }
}
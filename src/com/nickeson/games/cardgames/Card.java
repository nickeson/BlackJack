package com.nickeson.games.cardgames;

//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Card.java <p/>
 * <b>Project</b>: Card Games <p/>
 * <b>Description: </b> A class to define a Playing Card<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since May 17, 2016<p/>
 * updates:
 ****************************************************************************/

//public class Card implements Comparable<Card> {
public class Card {

    private String suit = null;
    private String rank = null;
    private int value = 0;
    
    /**
     * constructor requires Card suit, rank, value to be passed (at minimum)
     * @param suit the Card's suit
     * @param rank the Card's rank
     * @param value the Card's value
     */
    public Card(String suit, String rank, int value) {
    
        this.suit = suit; 
        this.rank = rank;
        this.value = value;
    }

	/**
	 * @return Card - the Card's suit
	 */
	public String getSuit() {
		return suit;
	}
	
	/**
	 * @param suit the Card suit to set
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * @return Card - the Card's rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @param rank the Card rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	/**
	 * @return Card - the Card's value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the Card value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return boolean - a Card suit comparison
	 */
	public boolean isSuit(String suit) {
		if (this.suit == null || this.suit.length() == 0) return false;
		return this.suit.equalsIgnoreCase(suit);
	}
	
	/**
	 * @return boolean - a Card rank comparison
	 */
	public boolean isRank(String rank) {
		if (this.rank == null || this.rank.length() == 0) return false;
		return this.rank.equalsIgnoreCase(rank);
	}
	
	/**
	 * @return boolean - a Card value comparison
	 */
	public boolean isValue(int value) {
		if (this.value == 0) return false;
		return true;
	}
	
	/**
     * print Card suit and rank, rather than hashcode
     */
    @Override
    public String toString() {
    	String currCard = null;
    	
    	if (suit != null && suit != "") {
			currCard = rank + " of " + suit;
    	} else {
    		// don't print suit if it doesn't exist (i.e., Jokers)
    		currCard = rank;
    	}
        return currCard;
    }

    // required to implement Comparator class
//    public int compareTo(Card c) {
//   	String currSuit = this.suit;
//  	String compSuit = c.getSuit();
//		int c1 = currSuit.compareTo(compSuit);
//		if (c1 < 0) {
//			return -1;
//		} else if (c1 > 0) {
//			return 1;
//		} else {

		// if suit is identical, compare value
//    	if (this.suit == c.getSuit()) {
//			if (this.value < c.getValue()) {
//				return 1;
//			} else {
//				return 0;
//			}
//		} else {
			// when suits are not identical, sort by suit
//			return this.suit.compareTo(c.getSuit());
//		}
//	}

    // unit test
//    public static void main(String[] args) {
//    	Card card = new Card("Spades", "Ace", 11);
//    	System.out.println(card);

//		BufferedImage cardFace = null;
//		try
//		{
//		  cardFace = ImageIO.read(new File("images/cardBack.png"));
//		}
//		catch (Exception e)
//		{
//		  e.printStackTrace();
//		  System.exit(1);
//		}
//    }
}
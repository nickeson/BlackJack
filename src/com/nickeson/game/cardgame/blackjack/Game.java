package com.nickeson.game.cardgame.blackjack;

import java.util.List;
import java.util.Map;
import com.nickeson.game.cardgame.DeckIntfc;
import com.nickeson.game.cardgame.EmptyDeckException;
import com.nickeson.game.cardgame.blackjack.BlackjackDealer;
//import com.nickeson.game.cardgame.Card;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Game.java <p/>
 * <b>Project</b>: Blackjack <p/>
 * <b>Description: </b> Blackjack game logic<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public class Game {
	
	private BlackjackDealer dealer = null;
	private	List<Player> playerArray = null;
	private DeckIntfc gameDeck = null;
	private Map<String, Object> acctBalanceMap = null;
	private Map<String, Object> configParamsMap = null;	
	private String dealerHand; // to print Dealer's Hand values
	private int dealerHandValue = 0;
	private boolean dealerHasPlayed = false;
	private String playerHand; // to print Player's Hand values
	private int playerHandValue = 0;
	private int betAmount;
	int initialWin = -1; // set initial Win to 'No Initial Win'
//	private boolean dealerHandVisible = false; // delete if it works without this initializer

	/**
	 * default constructor calls initializer and then gets all game params
	 */
	public Game() {
		Initializer init = new Initializer();
		playerArray = init.getPlayers();
		gameDeck = init.getGameShoe();
		dealer = new BlackjackDealer(gameDeck);
		acctBalanceMap = init.getAcctBalanceMap();
		configParamsMap = init.getConfig();
	}
	
	/**
	 * display Dealer's Hand with all cards face up (true) or with
	 * 2nd card face down (false)
	 * @param dealerHandVisible determines if Dealer's Hand prints with 
	 * all cards face up (true) or with 2nd card face down (false)
	 */
	private void showDealerHand(boolean dealerHandVisible) {
		for (Player q : playerArray) {
			if (q.getFirstName().equalsIgnoreCase("Dealer")) {

				if (dealerHandVisible) {
					System.out.println("\nDealer's Hand: " + q.getHand());
				} else {
					String dealerHand = "" + q.getHand();
					String tmpString = dealerHand.replace("[", "");
					String[] newString = tmpString.split(",");
					dealerHand = newString[0] + ", Face Down Card";
					System.out.println("Dealer's Hand: [" + dealerHand + "]");
				}
			}
		}
	}

	/**
	 * deal a starting Hand of Cards to each Player
	 */
	private void initialDeal() {
		for (Player p : playerArray) {
			try {
				dealer.dealHand(p);
				if (p.getFirstName().equalsIgnoreCase("Dealer")) {
					dealerHand = "" + p.getHand(); // Dealer's initial Hand
					dealerHandValue = p.getHand().calcValue(); // Dealer's initial Hand value
				} else {
					playerHand = "" + p.getHand(); // Player's initial Hand
					playerHandValue = p.getHand().calcValue(); // Player's initial Hand value
				}
			} catch (EmptyDeckException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * compare Player's Hand value to Dealer's Hand value
	 * returns 'Push' (0), 'Natural Blackjack' (1), no Initial Win (-1)
	 * @return 0 = 'Push', 1 = 'Natural Blackjack', -1 = 'no Initial Win'
	 */
	private int initialWinEval () {
		if (playerHandValue == 21 && dealerHandValue == 21) {
				System.out.println("Player and Dealer have tied at 21 (Push)");
				return 0; // Push
		} else {
			if (playerHandValue == 21 && dealerHandValue != 21) {
				System.out.println("Player has Won: Natural Blackjack!");
				System.out.println("Player's Hand: " + playerHand);
				System.out.println("Dealer's Hand: " + dealerHand);
				return 1; // Natural Blackjack
			} else {
				return -1; // No Initial Win
			}
		}
	}
	
	/**
	 * play the specified Player's Hand
	 * @param p the Player whose Hand to play
	 */
	private int playPlayerHand(Player p, int dealerHandValue) {
		playerHandValue = p.getHand().calcValue();
		String playerName = p.getFirstName() + " " + p.getLastName();
		boolean hitOrStand = true;

		System.out.print("\n");
		while ((playerHandValue < 21) && (hitOrStand == true)) {
			System.out.print("(H)it or (S)tand?: ");
			hitOrStand = p.hitOrStand();
			
			if (hitOrStand == true) {
				try {
					dealer.dealCard(p, 1);
				} catch (EmptyDeckException e) {
					e.printStackTrace();
				}
				System.out.println("\n" + playerName + "'s Hand: " + p.getHand());
				playerHandValue = p.getHand().calcValue();
			}
		}
//		p.scanner.close(); // Necessary?  When does this get closed if we don't use it?  Buggy if we do...
		return playerHandValue;
	}
	
	/**
	 * play the Dealer's Hand, return the Hand's value
	 * @param dealer the Dealer whose Hand to play
	 * @return the value of the Dealer's Hand
	 */
	private int playDealerHand(Player d) {
		showDealerHand(true); // print full Dealer's hand on Dealer's turn
		while (d.hitOrStand()) {
			System.out.println("Dealer hits...");
			try {
				dealer.dealCard(d, 1);
			} catch (EmptyDeckException e) {
				e.printStackTrace();
			}
			System.out.println("Dealer's Hand: " + d.getHand());	
		}
		dealerHandValue = d.getHand().calcValue();
		dealerHasPlayed = true;
		return dealerHandValue;
	}
	
	/**
	 * evaluates Win or Push by comparing Player's Hand to Dealer's Hand
	 * @param playerHandValue the Player's Hand to evaluate
	 * @param dealerHandValue the Dealer's Hand to evaluate
	 */
	private void finalWinEval(int playerHandValue, int dealerHandValue) {
		System.out.println("\nplayerHandValue: " + playerHandValue); // for testing
		System.out.println("dealerHandValue: " + dealerHandValue);	 // for testing
		if ((playerHandValue > dealerHandValue && playerHandValue <= 21) || 
				(playerHandValue <= 21 && dealerHandValue > 21)) {
			if (playerHandValue == 21) {
				System.out.println("\nPlayer Wins: Blackjack!");
			} else {
				System.out.println("\nPlayer Wins!");
			}
		} else {
			if (((playerHandValue < dealerHandValue) && dealerHandValue <= 21) ||
					(playerHandValue > 21 && dealerHandValue <= 21)) {
				System.out.println("\nDealer Wins!");
			} else {
				if ((playerHandValue == dealerHandValue) && (playerHandValue <= 21)) {
					System.out.println("\nPlayer and Dealer have tied (Push)");
					if (dealerHandValue == 21 && dealerHasPlayed != true) { // if Dealer got a Natural 21
						System.out.println("Dealer's Hand: " + dealerHand); // print Dealer's hand
					}
				}
			}
		}
	}

	/**
	 * main Game loop runs through game play for all players setup by Initializer
	 * @throws EmptyDeckException 
	 */
	private void runGameLoop() throws EmptyDeckException {
		String playerName;

		initialWin = initialWinEval(); // check Push/Natural status before Player(s)/Dealer take their turn(s)
		// run play loop for Player(s)
		for (Player p : playerArray) {
			if ((!p.getFirstName().equalsIgnoreCase("Dealer")) 
					&& ((initialWin == 0) || (initialWin == 1))) break; // move on to Dealer's turn if Player has 'Push' or 'Natural'
			playerName = p.getFirstName() + " " + p.getLastName();
			if (!(p.getFirstName().equalsIgnoreCase("Dealer"))) {
				showDealerHand(false);
				System.out.println(playerName + "'s Hand: " + p.getHand()); 
				playerHandValue = p.getHand().calcValue();

				playerHandValue = playPlayerHand(p, dealerHandValue); // take Player(s) turn
				if (playerHandValue == 21 && dealerHandValue != 21) {
					break;
				} else {
					if (playerHandValue > 21) {
						System.out.println(playerName + " has gone Bust!");
						break;
					}
				}
			}
		}
		// run play loop for Dealer
		for (Player p : playerArray) {
			if ((p.getFirstName().equalsIgnoreCase("Dealer")) 
					&& ((initialWin == 0) || (initialWin == 1))) break; // skip Dealer's turn if Player has 'Push' or 'Natural'
			if (p.getFirstName().equalsIgnoreCase("Dealer")) {
				dealerHandValue = playDealerHand(p);
				if (dealerHandValue > 21) {
					System.out.println("Dealer has gone Bust!");
					break;
				}
			}
		}
		if (initialWin == -1) {
			finalWinEval(playerHandValue, dealerHandValue);
		}
	}

	/**
	 * prompt Player for bet amount, update Player's betAmount value
	 */
	private void getPlayerBet() {
//		for (Player p : playerArray) {
		// set player's bet amount = map?	
//		}
	}
	
	/**
	 * update the Player's acctBalance by the specified amount
	 * @param amount the amount with which to update the Player's acctBalance
	 */
	private void updateBank(int amount) {
	}
	
	/**
	 * display any game closing messages to the view
	 */
	private void end() {
		System.out.println("\nThanks for Playing...");
	}
	
	/**
	 * main Blackjack game logic
	 */
	public static void main(String[] args) {
		Game blackjack = new Game();
		blackjack.getPlayerBet(); // currently does nothing
		blackjack.initialDeal();

		try {
			blackjack.runGameLoop(); // needs multiPlayer and betting capabilities, cleanup with extra methods
		} catch (EmptyDeckException e) {
			e.printStackTrace();
		}

		blackjack.updateBank(50); // stub currently does nothing
		blackjack.end();
	}
}
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
	private int dealerHandValue = 0;
	private int betAmount;

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
	 * deal a starting Hand of Cards to each Player
	 */
	private void initialDeal() {
		for (Player p : playerArray) {
			try {
				dealer.dealHand(p);
				if (p.getFirstName().equalsIgnoreCase("Dealer")) {
					dealerHandValue = p.getHand().calcValue();
				}
			} catch (EmptyDeckException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * main Game loop runs through game play for all players setup by Initializer
	 * @throws EmptyDeckException 
	 */
	private void runGameLoop() throws EmptyDeckException {
		boolean hitOrStand = true;
		boolean isDealer;
		int handValue = 0;
		String playerName;

		// play each player's Hand (not including Dealer)
		for (Player p : playerArray) {
			isDealer = p.getFirstName().equalsIgnoreCase("Dealer");
			playerName = p.getFirstName() + " " + p.getLastName();

			// show Dealer's Hand with 2nd Card face-down before each Player's turn (not Dealer's)
			if (!isDealer) {
				for (Player q : playerArray) {
					if (q.getFirstName().equalsIgnoreCase("Dealer")) {
						String dealerHand = "" + q.getHand();
						String tmpString = dealerHand.replace("[", "");
						String[] newString = tmpString.split(",");
						dealerHand = newString[0] + ", Face Down Card";
						dealerHandValue = q.getHand().calcValue();
						System.out.println("Dealer's Hand: [" + dealerHand + "]");
					}
				}
				// set initial, 'post-deal/pre-play' handValue for Player (not Dealer)
				System.out.println(playerName + "'s Hand: " + p.getHand()); 
				handValue = p.getHand().calcValue();
			}
			
			// run initial checks for Push / Natural Blackjack / Bust
			if (handValue == 21 && dealerHandValue == 21) {
				if (!isDealer) {
					System.out.println("\nPlayer and Dealer have tied at 21 (Push)");
				}
			} else {
				if (handValue == 21 && dealerHandValue != 21) {
					if (!isDealer) {
						System.out.println("\nPlayer has Won: Natural Blackjack!");
					}
				} else {
					if (!isDealer) { // non-Dealer block
						System.out.print("\n");
						while ((handValue < 21) && (hitOrStand == true)) {
							System.out.print("(H)it or (S)tand?: ");
							hitOrStand = p.hitOrStand();
							if (hitOrStand == true) {
								dealer.dealCard(p, 1);
								System.out.println("\n" + playerName + "'s Hand: " + p.getHand());
								handValue = p.getHand().calcValue();
							}
						}
						p.scanner.close(); // necessary?
						if (handValue == 21 && dealerHandValue != 21) {
							System.out.println("Player has Won: Blackjack!");
						} else {
							if (handValue > 21) {
								System.out.println(playerName + " has gone Bust!");
							}
						}
					} // end non-Dealer block

					if (isDealer) { // Dealer block
						System.out.println("\nDealer's Hand: " + p.getHand());
						while (p.hitOrStand()) {
							System.out.println("Dealer hits...");
							dealer.dealCard(p, 1);
							System.out.println("Dealer's Hand: " + p.getHand());	
						}
						dealerHandValue = p.getHand().calcValue();
						if (dealerHandValue > 21) {
							System.out.println("Dealer has gone Bust!");
						}
					} // end dealer block
				} // end Natural Blackjack 'else' clause
			} // end Player/Dealer Push 'else' clause
		} // end Player loop

		// after all players & dealer have taken their turns, do win/bust/push eval
		if ((handValue > dealerHandValue && handValue < 21) || 
				(handValue < 21 && dealerHandValue > 21)) {
			System.out.println("\nPlayer Wins!");
		} else {
			if (((handValue < dealerHandValue) && dealerHandValue <= 21) ||
					(handValue > 21 && dealerHandValue <= 21)) {
				System.out.println("\nDealer Wins!");
			} else {
				if ((handValue == dealerHandValue) && (handValue < 21)) {
					System.out.println("\nPlayer and Dealer have tied (Push)");
				}
			}
		}
//		System.out.println("\n<<Next Player>>\n"); // uncomment for multi-player setup
	} // end runGameLoop()

	private void getPlayerBet() {
//		for (Player p : playerArray) {
		// set player's bet amount = map?	
//		}
	}
	
	private void updateBank(int amount) {
	}
	
	/**
	 * display any game closing messages to the view
	 */
	private void end() {
		System.out.println("\nThanks for Playing...");
	}
	
	// contains all main game logic
	public static void main(String[] args) {
		Game blackjack = new Game();
		blackjack.getPlayerBet(); // currently does nothing
		blackjack.initialDeal(); // working

		try {
			blackjack.runGameLoop(); // in progress
		} catch (EmptyDeckException e) {
			e.printStackTrace();
		}

		blackjack.updateBank(50); // stub
		blackjack.end();
	}
}
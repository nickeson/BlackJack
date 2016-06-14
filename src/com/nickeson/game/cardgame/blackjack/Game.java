package com.nickeson.game.cardgame.blackjack;

import java.util.List;
import java.util.Map;
import com.nickeson.game.cardgame.DeckIntfc;
import com.nickeson.game.cardgame.EmptyDeckException;
import com.nickeson.game.cardgame.blackjack.BlackjackDealer;

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
			if (isDealer != true) { // set handValue for all Players, not Dealer
				handValue = p.getHand().calcValue();
			}

			// change this to only show first card until Dealer's turn
			if (isDealer == true) {
				System.out.println("Dealer's handValue: " + p.getHand().calcValue());
			}
			System.out.println(playerName + "'s Hand: " + p.getHand()); 
			
			// run initial checks for Push / Natural Blackjack / Bust
			if (handValue == 21 && dealerHandValue == 21) {
				System.out.println("Player and Dealer have tied at 21 (Push)");
			} else {
				if (handValue == 21 && dealerHandValue != 21) {
					System.out.println("Player has a Natural Blackjack!");
				} else {
					if (isDealer != true) { // for everyone BUT the Dealer

						// continue hOs loop until Bust or Stand (hOs = false) ** BROKEN - only allows H/S once! **
						while ((handValue < 21) && (hitOrStand == true)) {
							System.out.println("handValue: " + p.getHand().calcValue());
							System.out.println("(H)it or (S)tand?: ");
//							System.out.println("hos: " + hitOrStand); // for testing
							hitOrStand = p.hitOrStand();
//							System.out.println("hosAfter: " + hitOrStand); // for testing							
							if (hitOrStand == true) {
								dealer.dealCard(p, 1);
								hitOrStand = true; // reset hitOrStand to True
								System.out.println("Hand: " + p.getHand());
								handValue = p.getHand().calcValue(); // re-calculate handValue
							}
						}

						// final win/bust evaluation
						if (handValue == 21) {
							System.out.println("Player has Won with Blackjack!");
						} else {
							if ((handValue > dealerHandValue) && handValue < 21) {
								System.out.println("Player Wins!");
							} else {
									if ((handValue < dealerHandValue) && dealerHandValue <= 21) {
										System.out.println("Dealer Wins!");
									} else {
										if (handValue == dealerHandValue) {
											System.out.println("Player and Dealer"
													+ " have tied (Push)");
										} else {
											System.out.println("Player has Busted!");
										}
									}
							}
//							System.out.println("\n<<Next Player>>\n");
						} // end win/bust evaluation
					} // end if isDealer loop
				} // end non-Natural Blackjack loop
			} // end Natural Blackjack loop
		} // end Player loop
	} // end method

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
		System.out.println("Thanks for Playing!");
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
//		blackjack.end();
	}
}
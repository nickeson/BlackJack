package com.nickeson.game.cardgame.blackjack;

//JDK 1.8.0
import java.util.List;
import java.util.Scanner;
import com.nickeson.game.cardgame.DeckIntfc;
import com.nickeson.game.cardgame.EmptyDeckException;
import com.nickeson.game.cardgame.blackjack.BlackjackDealer;
//import java.util.Map;


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
	private	String playerName;
	private String dealerHand; // to print Dealer's Hand values
	private int dealerHandValue;
	private boolean dealerHasPlayed = false;
	private String playerHand; // to print Player's Hand values
	private int playerHandValue;
	private int initialWin = -1; // set initial Win to 'No Initial Win'
	private Scanner scanner = null;
	private int betAmount;
//	private Map<String, Object> acctBalanceMap = null;
//	private Map<String, Object> configParamsMap = null;	

	/**
	 * default constructor calls initializer and then gets all game setup params
	 */
	public Game() {
		Initializer init = new Initializer();
		playerArray = init.getPlayers();
		gameDeck = init.getGameShoe();
		dealer = new BlackjackDealer(gameDeck);
//		acctBalanceMap = init.getAcctBalanceMap();
//		configParamsMap = init.getConfig();
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
					dealerHand = "" + p.getHand(); // initial Hand
					dealerHandValue = p.getHand().calcValue(); // initial Hand value
				} else {
					playerHand = "" + p.getHand(); // initial Hand
					playerHandValue = p.getHand().calcValue(); // initial Hand value
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
				System.out.println("Player's Hand: " + playerHand);
				System.out.println("Dealer's Hand: " + dealerHand);	
				return 0;
		} else {
			if (playerHandValue == 21 && dealerHandValue != 21) {
				System.out.println("Player has Won: Natural Blackjack!");
				System.out.println("Player's Hand: " + playerHand);
				System.out.println("Dealer's Hand: " + dealerHand);
				return 1;
			} else {
				return -1;
			}
		}
	}
	
	/**
	 * Loop through Player(s), playing their Hand, checking for Bust
	 */
	public void playerLoop() {
		for (Player p : playerArray) {
			playerName = p.getFirstName() + " " + p.getLastName();
			if (!(p.getFirstName().equalsIgnoreCase("Dealer"))) {
				showDealerHand(false);
				System.out.println(playerName + "'s Hand: " + p.getHand()); 
				playerHandValue = p.getHand().calcValue(); // get initial playerHandValue
				playerHandValue = playPlayerHand(p, dealerHandValue); // hitOrStand, then update playerHandValue
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
//		System.out.println("\n<< Next Player's Turn >>\n"); // uncomment for multiPlayer
	}
	
	/**
	 * play the specified Player's Hand (requires comparison to Dealer's Hand),
	 * return the Player's Hand
	 * @param p the Player whose Hand to play
	 * @param dealerHandValue the value of the Dealer's Hand to use for comparison
	 * @return the value of the Player's Hand after all Hit or Stands are complete
	 */
	private int playPlayerHand(Player p, int dealerHandValue) {
		getPlayerBet(p);
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
		updateBank(p, betAmount);
		return playerHandValue;
	}
	
	/**
	 * play the Dealer's Hand, return the Hand's value
	 * @param dealer the Dealer whose Hand to play
	 * @return the value of the Dealer's Hand after all Hit or Stands are complete
	 */
	private int playDealerHand(Player d) {
		showDealerHand(true);
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
	 * evaluates final Win or Push by comparing Player's Hand to Dealer's Hand
	 * @param playerHandValue the Player's Hand to evaluate
	 * @param dealerHandValue the Dealer's Hand to evaluate
	 */
	private void finalWinEval(int playerHandValue, int dealerHandValue) {
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
					if (dealerHandValue == 21 && dealerHasPlayed != true) {
						System.out.println("Dealer's Hand: " + dealerHand);
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
		initialWin = initialWinEval();
		if (initialWin == -1) { 
			playerLoop();
			System.out.println("\n<< Dealer's Turn >>");
			for (Player p : playerArray) {
				if (p.getFirstName().equalsIgnoreCase("Dealer")) {
					dealerHandValue = playDealerHand(p);
					if (dealerHandValue > 21) {
						System.out.println("Dealer has gone Bust!");
						break;
					}
				}
			}
			finalWinEval(playerHandValue, dealerHandValue);
		}
	}

	/**
	 * get Player's bet amount using prompt
	 * @param the Player to query for a bet
	 * @return the Player's bet amount
	 */
	private int getPlayerBet(Player player) {
		int result = 0;
		// code to Prompt player for bet
		return result;
	}
	
	/**
	 * update the Player's acctBalance by the specified amount
	 * @param player the Player whose acctBalance to update
	 * @param amount the amount with which to update the Player's acctBalance
	 */
	private void updateBank(Player player, int amount) {
	}
	
	/**
	 * prompt Player to play game again
	 * @return true = play again, false = do not play again
	 */
	private boolean playAgainPrompt() {
		String inStr = null;
        scanner = new Scanner(System.in);
        boolean result = false;
        
        System.out.print("\nPlay Again? (Y/N): ");
        while (scanner.hasNextLine()) {
			inStr = scanner.nextLine();
			if(inStr.equalsIgnoreCase("y")) {
				result = true;
				break;
			} else {
				if (inStr.equalsIgnoreCase("n")) {
					result = false;
					break;
				} else {
					if (!inStr.isEmpty()) {
						System.out.print("Play Again? (Y/N): ");
					}
				}
			}
			if (inStr.isEmpty()) {
				System.out.print("Play Again? (Y/N): ");
			}
		}
        System.out.println("");
		return result;
	}
	
	/**
	 * main Blackjack game logic and playAgain loop
	 */
	public static void main(String[] args) {
		Game blackjack = new Game();
		do {
			blackjack.initialDeal();
			try {
				blackjack.runGameLoop(); // needs multiPlayer and betting capabilities added
			} catch (EmptyDeckException e) {
				e.printStackTrace();
			}
			blackjack = new Game(); // must reset for next Game
		} while (blackjack.playAgainPrompt());
		System.out.println("Thanks for Playing!");
		blackjack.scanner.close();
	}
}
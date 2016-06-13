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
//				p.getHand().sortBySuit();
//				int handValueSoft = p.getHand().calcValue(true);
//				int handValueHard = p.getHand().calcValue(false);	
//				System.out.println("Hand's soft value: " + p.getHand().calcValue(true));
//				System.out.println("Hand's hard value: " + p.getHand().calcValue(false));	
//				System.out.println("Blackjack Check: " + dealer.checkBlackjack(p.getHand()));
//				System.out.println("Bust Check: " + dealer.checkBust(p.getHand()));
				String playerName = p.getFirstName() + " " + p.getLastName();
				System.out.println(playerName + "'s Hand: " + p.getHand());
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
		for (Player p : playerArray) {
			boolean bj = dealer.checkBlackjack(p.getHand());
			boolean bust = dealer.checkBust(p.getHand());
			
			if (bj == true) {
				System.out.println("Congratulations " + p.getFirstName() + " "
						+ p.getLastName() + "- You have won!");
			} else {
				if (bust == true) {
						System.out.println(p.getFirstName() + " " + p.getLastName()
						+ " has Bust.  Please Play Again.");
				}
			}

			if (p.hitOrStand() == true) {
				dealer.dealCard(p, 1);
			}
			System.out.println(p.getHand());
		}
	}

	private void getPlayerBet() {
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
		blackjack.getPlayerBet();
		blackjack.initialDeal();
		try {
			blackjack.runGameLoop();
		} catch (EmptyDeckException e) {
			e.printStackTrace();
		}
		blackjack.updateBank(50);
//		blackjack.end();
	}
}
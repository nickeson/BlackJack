package com.nickeson.game;

import java.util.HashMap;
import java.util.Map;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: BetOptions.java <p/>
 * <b>Project</b>: Games <p/>
 * <b>Description: </b> A Map of options for game bet management<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public class BetOptions {

	private Map<String, Object> betOpt = new HashMap<String, Object>();

	/**
	 * default constructor defines Bet Options
	 */
	public BetOptions() {
		betOpt.put("blackjackMinBet", new Integer(5));
		betOpt.put("blackjackMaxBet", new Integer(100));	
	}
	
	/**
	 * returns the options from BetOptions as a Map object
	 * @return the options from BetOptions as a Map object
	 */
	public Map<String, Object> getBetOptions() {
		return betOpt;
	}
}
package com.nickeson.game;

//JDK 1.8.0
import java.util.HashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: Bank.java <p/>
 * <b>Project</b>: Games <p/>
 * <b>Description: </b> A generic banking class to be used during game play<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public class Bank {
	private Map<String, Object> acctBalanceMap = new HashMap<>(); // String = playerName, Object = acctBalance
	// entry here for config file location on filesystem

	/**
	 * default constructor uses values from config file for acctBalanceMap
	 */
	public Bank() {
		// entry to pull acctBalanceMap values from config file on filesystem
	}
	
	/**
	 * convenience constructor allows us to pass an acctBalanceMap to the Bank
	 * @param acctBalanceMap
	 */
	public Bank(Map<String, Object> acctBalanceMap) {
		this.acctBalanceMap = acctBalanceMap;
	}

	/**
	 * @return the acctBalanceMap
	 */
	public Map<String, Object> getAcctBalanceMap() {
		return acctBalanceMap;
	}

	/**
	 * @param acctBalanceMap the acctBalanceMap to set
	 */
	public void setAcctBalanceMap(Map<String, Object> acctBalanceMap) {
		this.acctBalanceMap = acctBalanceMap;
	}
}
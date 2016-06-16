package com.nickeson.game;

//JDK 1.8.0
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: Configurator.java <p/>
 * <b>Project</b>: Games <p/>
 * <b>Description: </b>Configure game parameters via config file<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 2.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public class Configurator {
//	private File configFile = null; // uncomment and update with location of configFile
	private Map<String, Object> configFileValuesMap = new HashMap<>();
	
	/**
	 * default constructor uses default configFile
	 */
	public Configurator() {
		// update configFileValuesMap with values from configFile
	}
	
	/**
	 * import configuration values from configFile
	 * @param configFile the configFile to import
	 * @return a Map of values imported from the configFile
	 */
	public Map<String, Object> importConfigValues(File configFile) {
//		this.configFile = configFile; // uncomment once we have a configFile location
		// code to read from configFile & update configFileValuesMap
		return configFileValuesMap;
	}
	
	/**
	 * exports all values from configFileValuesMap to configFile
	 */
	public void exportConfigValues() {
		// code to export configFileValuesMap entries to configFile
	}

	/**
	 * @param configFile the configFile to set
	 */
	public void setConfigFile(File configFile) {
//		this.configFile = configFile; // uncomment once we have a configFile location
	}
}
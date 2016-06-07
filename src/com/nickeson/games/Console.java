package com.nickeson.games;

import java.util.Scanner;

//JDK 1.8.0

/****************************************************************************
 * <b>Title</b>: Console.java <p/>
 * <b>Project</b>: Nickeson Base Libs <p/>
 * <b>Description: </b> Displays data output to a Console window and receives data input
 * from a keyboard<p/>
 * <b>Copyright:</b> Copyright (c) 2016<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author nickeson
 * @version 1.0
 * @since Jun 7, 2016<p/>
 * updates:
 ****************************************************************************/

public class Console implements View, Controller {

	private String outText = null; // text to output to Console
	private String inText = null; // text input from Console
	private String prompt = null; // text to prompt for input from Console
	
	/**
	 * default constructor requires us to use setter methods to be able to
	 * output messages or custom prompts for input to the Console
	 */
	public Console() {
	}

	/**
	 * convenience constructor allows passing a text String to be used as an 
	 * output message (isInput = false) or input prompt (isInput = true)
	 * @param text the text String to be used for output message or input prompt
	 * @param isInput false means text String is output message, true means text
	 * String is input prompt
	 */
	public Console(String text, boolean isInput) {
		if (isInput) {
			prompt = text;
			getInput();
		} else {
			outText = text;
			displayOutput();
		}
	}

	/**
	 * required method to implement the Controller interface - this implementation
	 * gets input from the Console and returns to the caller as an Object
	 * @return the object from the parsed Console input
	 */
	public Object getInput() {
		return getTextInput();
	}

	/**
	 * required method to implement the Controller interface - this implementation
	 * sends output to the Console
	 */
	public void displayOutput() {
		outputText();
	}
	
	/**
	 * returns the text input at the Console to the caller
	 * @return the text input at the Console to the caller
	 */
	private String getTextInput() {
		Scanner scanner = null;
		if (prompt == null) {
			System.out.println("Please enter input: ");
		} else {
			System.out.println(prompt);
		}

		if (inText == null) {
			try {
				scanner = new Scanner(System.in);
				inText = scanner.nextLine();
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		} return inText;
	}

	/**
	 * sends text output to the Console window
	 * @param outText the text to output to the Console window
	 */
	private void outputText() {
		if (outText != null) {
			System.out.println(outText);
		}
	}

	/**
	 * @param outText the output text to set
	 */
	public void setOutText(String outText) {
		this.outText = outText;
	}

	/**
	 * @param prompt the prompt text to set for display on the Console
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	// unit test
	public static void main(String[] args) {
		Console c = new Console();
//		Console c = new Console("New Prompt: ", true);
//		Console c = new Console("Test Output Message...", false);
//		c.setOutText("This is a test output message...");
//		c.outputText();

		c.setPrompt("Prompt: ");
		c.getTextInput();
		System.out.println(c.inText);
	}
}
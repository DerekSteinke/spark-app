package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientMessage {

	private String messageText;
	private final String time;
	
	/**
	 * @param string A string to create a ClientMessage object with, timestamped with the current time and dat in string format
	 */
	public ClientMessage(String string) {
		this.messageText = string;
		this.time = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());;
	}
	
	/**
	 * @param message A string to create a ClientMessage object with
	 * @param time The time the object was created in string format
	 */
	public ClientMessage(String message, String time) {
		this.messageText = message;
		this.time = time;
	}

	/**
	 * @return messageText
	 */
	public String getMessageText() {
		return messageText;
	}

	/**
	 * @param messageText
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	/**
	 * @return time
	 */
	public String getTime() {
		return time;
	}


	/**
	 * Reverses the text of messageText
	 */
	public void reverseMessage() {
		this.messageText = new StringBuilder(messageText).reverse().toString();
	}

}

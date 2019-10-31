package edu.srh.is.victim;

import edu.srh.is.operation.Communicator;

/**
 * Super Class for Victims
 * @author Vivek Yadav
 */
public abstract class Victim {

	// Exposed within the package and the child class
	String victimName;
	boolean communicationFlag = false;

	/**
	 * Super: Victim constructor
	 * @param victimName {@link String}
	 */
	public Victim(String victimName) {
		this.victimName = victimName;
	}

	/**
	 * Returns victim name
	 * @return victimName {@link String}
	 */
	public String getVictimName() {
		return victimName;
	}

	/**
	 * Returns victim name
	 * @return victimName {@link String}
	 */
	public boolean getCommunicationFlag() {
		return communicationFlag;
	}
	

	/**
	 * Send Message.
	 * @param communicator {@link Communicator}
	 * @param message {@link String}
	 * @return encryptedMessage {@link String}
	 */
	public abstract String sendMessage(Communicator communicator, String message);

	/**
	 * Receive Message.
	 * @param encryptedMessage {@link String}
	 * @return decryptedMessage {@link String}
	 */
	public abstract String receiveMessage(Communicator communicator, String encryptedMessage);

}

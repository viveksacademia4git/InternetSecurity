package edu.srh.is.victim;

/**
 * Super Class for Victims
 * @author Vivek Yadav
 */
public abstract class Victims {

	// Exposed within the package and the child class
	String victimName;
	boolean communicationFlag = false;

	/**
	 * Super: Victim constructor
	 * @param victimName {@link String}
	 */
	public Victims(String victimName) {
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
	 * Define the user to whom to communicate with.
	 * @param victim {@linkplain <? extends Victims>}
	 */
	public abstract void communicateWith(Class<? extends Victims> victim);

	public abstract void sendMessage(String message);

	public abstract String receiveMessage();

}

package edu.srh.is.victim;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import edu.srh.is.attacker.AgentSmith;
import edu.srh.is.operation.Communicator;
import edu.srh.is.util.MessageUtil;

/**
 * Super Class for Victims
 * @author Vivek Yadav
 */
public abstract class Victim {

	// Exposed within the package and the child class
	String victimName;
	boolean communicationFlag = false;

	public String name;
	public Communicator Comm;
	public BigInteger generator;

	private BigInteger randomElement;
	public BigInteger modOfGenerator;
	private BigInteger key;
	

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


	public void startEncryptedCommunication() {
		Comm = new Communicator();
		generator = Comm.getGenerator();

		randomElement = Comm.getRandomElement(); // randomElement <- Zq
		modOfGenerator = Comm.powMod(generator, randomElement); // modOfGenerator = generator^randomElement mod p
	}


	public void initiateDecryption(Communicator Comm) {
		this.Comm = Comm;
		randomElement = Comm.getRandomElement(); // randomElement <- Zq
		modOfGenerator = Comm.powMod(Comm.getGenerator(), randomElement); // modOfGenerator = generator ^ randomElement mod p
	}


	public void getFromPerson(BigInteger hB){
		key = Comm.powMod(hB, randomElement);
	}


	public BigInteger getKey(){
		return key;
	}


	public void sendMessageToUser(Victim B, String message) throws Exception{
		System.out.println("\n---- "+this.getVictimName()+" is sending a message ----");
		System.out.println("Message: " + message);
		byte[] cipher = MessageUtil.encryptMessage(message, key);
		System.out.println("Cipher: " + new String(cipher, "UTF-8"));
		B.receiveMessage(cipher);
	}


	public void sendMessageToUser(Victim B, AgentSmith E, String message) throws Exception{
		System.out.println("\n---- "+this.getVictimName()+" is sending a message ----");
		System.out.println("Message: " + message);
		byte[] cipher = MessageUtil.encryptMessage(message, key);
		System.out.println("Cipher: " + new String(cipher, "UTF-8"));
		E.getMessageFromPerson(cipher, B, this);
	}


	public void receiveMessage(byte[] cipherText) throws UnsupportedEncodingException{
		System.out.println("\n---- "+this.getVictimName()+" Received Message ----");
		System.out.println("Cipher: " + new String(cipherText, "UTF-8"));
		String message = MessageUtil.decryptMessage(cipherText, key);
		System.out.println("Message: " + message);
	}

}

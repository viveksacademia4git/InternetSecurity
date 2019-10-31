package edu.srh.is.attacker;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import edu.srh.is.util.MessageUtil;
import edu.srh.is.victim.Victim;

public class AgentSmith {

	private BigInteger Z;
	private BigInteger keyA;
	private BigInteger keyB;
	private BigInteger key;

	public AgentSmith() { }
	
	public void eavsdrop(Victim A, Victim B){
		Z = A.Comm.getRandomElement();
		key = A.Comm.powMod(A.Comm.getGenerator(), Z);

		keyA = A.Comm.powMod(A.modOfGenerator, Z);
		B.initiateDecryption(A.Comm);
		B.getFromPerson(key);

		keyB = A.Comm.powMod(B.modOfGenerator, Z);
		A.getFromPerson(key);
	}

	
	public BigInteger getKeyA(){
		return keyA;
	}


	public BigInteger getKeyB(){
		return keyB;
	}


	public void getMessageFromPerson(byte[] cipher, Victim B, Victim A) throws UnsupportedEncodingException{
		System.out.println("\n---- Agent Smith Got Message From "+A.getVictimName()+" ----");
		System.out.println("Cipher "+B.getVictimName()+": " + new String(cipher, "UTF-8"));
		String message = MessageUtil.decryptMessage(cipher, keyA);
		System.out.println("Message: " + message);
		byte[] cipherB = MessageUtil.encryptMessage(message, keyB);
		System.out.println("Cipher "+B.getVictimName()+": " + new String(cipherB, "UTF-8"));
		B.receiveMessage(cipherB);
	}

	
}

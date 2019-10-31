package edu.srh.is.util;

import java.math.BigInteger;
import java.util.Random;

public class MessageUtil {


	/**
	 * Returns the decryped message
	 * @param message {@link String}
	 * @return encryptedMessage {@link String}
	 */
	public static String encryptMessage(String message) {
		// TODO Encrypt Message and return the encrypted message
		return message;
	}

	/**
	 * Returns the decryped message
	 * @param encryptedMessage {@link String}
	 * @return decryptedMessage {@link String}
	 */
	public static String decryptMessage(String encryptedMessage) {
		// TODO Decrypt Message and return the decrypted message
		return encryptedMessage;
	}


	public static BigInteger getRandomBigInteger(BigInteger primeNumber) {
		Random rand = new Random();
		BigInteger result;
		do
			result = new BigInteger(primeNumber.bitCount(), rand);
		while(result.compareTo(primeNumber) >= 0 || result.compareTo(BigInteger.TWO) < 0);

		return result;
	}

}
